package tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.java2pcm.transformations

import tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.util.transformationexecutor.EmptyEObjectMappingTransformation
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.emftext.language.java.classifiers.ClassifiersFactory
import org.emftext.language.java.classifiers.Interface
import org.emftext.language.java.containers.Package
import org.palladiosimulator.pcm.repository.OperationInterface
import org.palladiosimulator.pcm.repository.Repository
import org.palladiosimulator.pcm.repository.RepositoryFactory

import static extension tools.vitruv.framework.util.bridges.CollectionBridge.*
import tools.vitruv.applications.pcmjava.util.pcm2java.PCM2JaMoPPUtils
import tools.vitruv.applications.pcmjava.util.java2pcm.JaMoPP2PCMUtils
import tools.vitruv.applications.pcmjava.util.PCMJaMoPPUtils
import tools.vitruv.framework.util.command.ChangePropagationResult

/**
 * Maps a JaMoPP interface to a PCM interface 
 * Triggered when a CUD operation on JaMoPP interface is detected.
 */
class InterfaceMappingTransformation extends EmptyEObjectMappingTransformation {

	val private static final Logger logger = Logger.getLogger(InterfaceMappingTransformation.name)

	override getClassOfMappedEObject() {
		return Interface
	}

	/**
	 * Called when a Java-interface was added to the source code
	 * Determines whether the interface is architecture relevant or not
	 * An interface is architectural relevant, if 
	 * i) checking whether it is in the contracts package
	 * ii) asking the developer (not yet implemented)
	 */
	override createEObject(EObject eObject) {
		val Interface jaMoPPInterface = eObject as Interface
		try {
			val Package jaMoPPPackage = PCM2JaMoPPUtils.
				getContainingPackageFromCorrespondenceModel(jaMoPPInterface, correspondenceModel)
			var boolean createInterface = false
			if (null != jaMoPPPackage && jaMoPPPackage.name.equals("contracts")) {

				//i)
				createInterface = true
			} else {

				//ii)
				val String msg = "The created interface is not in the contracts packages. Should an architectural interface be created for the interface " +
					jaMoPPInterface.name + " ?"
				createInterface = super.modalTextYesNoUserInteracting(msg)
			}
			if (createInterface) {
				logger.debug("Created interface: " + eObject);
				var OperationInterface opInterface = RepositoryFactory.eINSTANCE.createOperationInterface
				opInterface.setEntityName(jaMoPPInterface.name)
				val Repository repo = JaMoPP2PCMUtils.getRepository(correspondenceModel)
				opInterface.setRepository__Interface(repo)
				return opInterface.toList
			}

		} catch (Exception e) {
			logger.info(e)
		}
		return null;
	}

	/**
	 * called when an interface method has been created
	 * 
	 */
	override createNonRootEObjectInList(EObject newAffectedEObject, EObject oldAffectedEObject, EReference affectedReference, EObject newValue,
		int index, EObject[] newCorrespondingEObjects) {
		val transformationResult = new ChangePropagationResult
		JaMoPP2PCMUtils.
			createNewCorrespondingEObjects(newValue, newCorrespondingEObjects,
				correspondenceModel, transformationResult)
		return transformationResult
	}

	/**
	 * Called when a Java-interface was removed. Also removes the corresponding PCM Interface (if there is one)
	 * Does not ask the developer whether the PCM interface should be removed also.
	 */
	override removeEObject(EObject eObject) {
		return null
	}

	/**
	 * we do not really need the method deleteNonRootEObjectInList in InterfaceMappingTransformation because the deletion of the 
	 * object has already be done in removeEObject.
	 * We just return an empty TransformationChangeResult 
	 */
	override deleteNonRootEObjectInList(EObject newAffectedEObject, EObject oldAffectedEObject, EReference affectedReference, EObject oldValue,
		int index, EObject[] oldCorrespondingEObjectsToDelete) {
			PCMJaMoPPUtils.deleteNonRootEObjectInList(oldAffectedEObject, oldValue, correspondenceModel)
	}

	override updateSingleValuedEAttribute(EObject eObject, EAttribute affectedAttribute, Object oldValue,
		Object newValue) {
		val transformationResult = new ChangePropagationResult
		JaMoPP2PCMUtils.updateNameAsSingleValuedEAttribute(eObject, affectedAttribute, oldValue, newValue,
			featureCorrespondenceMap, correspondenceModel, transformationResult)
		return transformationResult
	}

	override setCorrespondenceForFeatures() {
		var interfaceNameAttribute = ClassifiersFactory.eINSTANCE.createInterface.eClass.getEAllAttributes.filter[attribute|
			attribute.name.equalsIgnoreCase("name")].iterator.next
		var opInterfaceNameAttribute = RepositoryFactory.eINSTANCE.createOperationInterface.eClass.getEAllAttributes.
			filter[attribute|attribute.name.equalsIgnoreCase("entityName")].iterator.next
		featureCorrespondenceMap.put(interfaceNameAttribute, opInterfaceNameAttribute)
	}

	override createNonRootEObjectSingle(EObject affectedEObject, EReference affectedReference, EObject newValue,
		EObject[] newCorrespondingEObjects) {
		logger.warn(
			"method createNonRootEObjectSingle should not be called for " + InterfaceMappingTransformation.simpleName +
				" transformation")
		return new ChangePropagationResult
	}

}
