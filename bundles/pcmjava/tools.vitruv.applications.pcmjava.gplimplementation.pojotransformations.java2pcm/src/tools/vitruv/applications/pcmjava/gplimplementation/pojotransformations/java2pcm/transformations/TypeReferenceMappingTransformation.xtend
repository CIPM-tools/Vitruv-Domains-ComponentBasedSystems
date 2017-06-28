package tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.java2pcm.transformations

import org.eclipse.emf.ecore.EObject
import org.emftext.language.java.classifiers.Class
import org.emftext.language.java.types.ClassifierReference
import org.emftext.language.java.types.NamespaceClassifierReference
import org.emftext.language.java.types.TypeReference
import org.palladiosimulator.pcm.repository.BasicComponent
import org.palladiosimulator.pcm.repository.OperationInterface
import org.palladiosimulator.pcm.repository.RepositoryFactory

import static extension tools.vitruv.framework.correspondence.CorrespondenceModelUtil.*
import static extension tools.vitruv.framework.util.bridges.CollectionBridge.*
import tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.util.transformationexecutor.DefaultEObjectMappingTransformation
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.util.EcoreUtil
import tools.vitruv.applications.pcmjava.util.java2pcm.Java2PcmUtils

class TypeReferenceMappingTransformation extends DefaultEObjectMappingTransformation {
	private static val logger = Logger.getLogger(TypeReferenceMappingTransformation)
	
	override getClassOfMappedEObject() {
		return TypeReference
	}

	/**
	 * called when a type Reference has been created.
	 * If it is a NamespaceClassifierReference of a ClassifierReference check whether 
	 * the reference is in the implements of a class. If yes--> check whether the interface has a corresponding 
	 * OperationInterface and the class has a corresponding component--> if yes: create an OperationProvidedRole
	 */
	override createEObject(EObject eObject) {
		if (implementsChanged(eObject)) {
			logger.debug("Added interface implementation: " + eObject + " for " + eObject.eContainer);
			val jaMoPPClass = eObject.eContainer as Class

			var interfaceClassifier = Java2PcmUtils.getTargetClassifierFromImplementsReferenceAndNormalizeURI(
				eObject as TypeReference)
			logger.debug("Interface classifier: " + interfaceClassifier);
			if(null == interfaceClassifier){
				return null
			}
			val correspondingInterfaces = correspondenceModel.getCorrespondingEObjectsByType(if (interfaceClassifier.eIsProxy) EcoreUtil.resolve(interfaceClassifier, eObject) else interfaceClassifier,
				OperationInterface)
			logger.debug("Corresponding interface: " + correspondingInterfaces);
			if (correspondingInterfaces.nullOrEmpty) {
				return null
			}
			val operationInterface = correspondingInterfaces.get(0)
			val correspondingBasicComponents = correspondenceModel.
				getCorrespondingEObjectsByType(jaMoPPClass, BasicComponent)
			logger.debug("Corresponding basic components: " + correspondingBasicComponents);
			if (correspondingBasicComponents.nullOrEmpty) {
				return null
			}
			val basicComponent = correspondingBasicComponents.get(0)
			logger.debug("Propagated interface implementation change with target: " + interfaceClassifier);
			return createOperationProvidedRole(basicComponent, operationInterface).toList
		}
		return null
	}

	/**
	 * if a implements reference has been removed remove the corresponding objects as well
	 */
	override removeEObject(EObject eObject) {
		return null
	}

	def private boolean implementsChanged(EObject eObject) {
		if (eObject instanceof NamespaceClassifierReference || eObject instanceof ClassifierReference) {
			val container = eObject.eContainer
			if (container instanceof Class) {
				val jaMoPPClass = eObject.eContainer as Class
				val referenceIsInImplements = jaMoPPClass.implements.contains(eObject)
				if (referenceIsInImplements) {
					return true
				}
			}
		}
		return false
	}

	def private createOperationProvidedRole(BasicComponent basicComponent, OperationInterface opInterface) {
		val operationProvidedRole = RepositoryFactory.eINSTANCE.createOperationProvidedRole
		operationProvidedRole.providedInterface__OperationProvidedRole = opInterface
		operationProvidedRole.providingEntity_ProvidedRole = basicComponent
		operationProvidedRole.entityName = basicComponent.entityName + "_provides_" + opInterface.entityName
		return operationProvidedRole
	}

}
