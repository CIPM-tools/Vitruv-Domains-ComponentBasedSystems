package tools.vitruv.applications.umljava.util

import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.Optional
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.uml2.uml.PrimitiveType
import org.eclipse.uml2.uml.Type
import org.emftext.language.java.classifiers.Classifier
import org.emftext.language.java.classifiers.ConcreteClassifier
import org.emftext.language.java.generics.GenericsFactory
import org.emftext.language.java.generics.QualifiedTypeArgument
import org.emftext.language.java.types.ClassifierReference
import org.emftext.language.java.types.NamespaceClassifierReference
import org.emftext.language.java.types.TypeReference
import org.emftext.language.java.types.TypesFactory
import tools.vitruv.domains.java.util.JavaModificationUtil
import tools.vitruv.extensions.dslsruntime.reactions.helper.ReactionsCorrespondenceHelper
import tools.vitruv.framework.correspondence.CorrespondenceModel
import tools.vitruv.framework.userinteraction.UserInteractor

import static tools.vitruv.applications.umljava.util.CommonUtil.*
import static tools.vitruv.applications.umljava.util.java.JavaTypeUtil.*
import java.util.LinkedList
import tools.vitruv.framework.userinteraction.UserInteractionOptions.WindowModality
import org.eclipse.uml2.uml.TypedElement
import org.emftext.language.java.containers.CompilationUnit
import org.emftext.language.java.imports.ClassifierImport
import org.emftext.language.java.imports.ImportsFactory
import org.eclipse.uml2.uml.LiteralUnlimitedNatural
import org.emftext.language.java.parameters.OrdinaryParameter
import org.emftext.language.java.members.Method
import org.emftext.language.java.members.Field
import org.eclipse.uml2.uml.Parameter
import org.eclipse.uml2.uml.MultiplicityElement

/**
 * Helper class for the Uml <-> Java - reactions. Contains functions for handling java::TypeReferences
 * and user interaction concerned with Type and CollectionType propagation.
 * 
 * @author Torsten Syma
 */
class UmlJavaTypePropagationHelper {
    private static val logger = Logger.getLogger(UmlJavaTypePropagationHelper.simpleName)
    
	private static val supportedCollectionTypes = #[ArrayList, LinkedList, HashSet]
	
	def static boolean isCollectionTypeReference(TypeReference jRef){
		val classifier = getClassifier(jRef)
		if (classifier !== null){
			val qualifiedName = getQualifiedName(classifier)
			if (supportedCollectionTypes.exists[it.name == qualifiedName]){
				return true
			}
		}
		return false
	}
	
	/**
	 * Prompts a message to the user that allows him to choose a collection datatype.
	 * 
	 * @param userInteractor the userInteractor to prompt the message
	 * @return the selected Collection implementation Class 
	 */
    def static Class<? extends Collection> userSelectCollectionType(UserInteractor userInteractor) {
        val String selectTypeMsg = "Select a Collection type for the association end"
        val int selectedType = userInteractor.singleSelectionDialogBuilder.message(selectTypeMsg)
            .choices(supportedCollectionTypes.map[it.name]).windowModality(WindowModality.MODAL).startInteraction()
        return supportedCollectionTypes.get(selectedType)
    }
	
	
	def static dispatch TypeReference getInnerTypeRefOfCollectionReference(TypeReference collRef){
		return null
	}
	def static dispatch TypeReference getInnerTypeRefOfCollectionReference(ClassifierReference collRef){
		val typeArgument = collRef.typeArguments.head
		if (typeArgument !== null && typeArgument instanceof QualifiedTypeArgument){
			val typeRef = (typeArgument as QualifiedTypeArgument).typeReference
			return typeRef
		}
		return null
	}
	def static dispatch TypeReference getInnerTypeRefOfCollectionReference(NamespaceClassifierReference collRef){
		return 
			if(!collRef.classifierReferences.nullOrEmpty) 
				getInnerTypeRefOfCollectionReference(collRef.classifierReferences.head) 
			else null
	}
	
	def static dispatch Classifier getClassifier(Void jRef){
		return null
	}
	def static dispatch Classifier getClassifier(TypeReference jRef){
		return null
	}
	def static dispatch Classifier getClassifier(org.emftext.language.java.types.PrimitiveType jRef){
		return null
	}
	def static dispatch Classifier getClassifier(ClassifierReference jRef){
		var classifier = jRef.target
		if (classifier === null) return null
		
		// resolve
		if (classifier.eIsProxy) {
			val resSet = classifier.eResource.resourceSet
			classifier = EcoreUtil.resolve(classifier, resSet) as Classifier
		}
		//normalize
		normalizeURI(classifier) // TODO is this really necessary? slowdown and errors for bigger classes like ArrayList
		return classifier
	}
	def static dispatch Classifier getClassifier(NamespaceClassifierReference jRef){
		return 
			if(!jRef.classifierReferences.nullOrEmpty) 
				getClassifier(jRef.classifierReferences.head) 
			else null
	}
		
	def static dispatch Type getUmlTypeFromReference(TypeReference jRef, CorrespondenceModel cm){
		return null
	}
	def static dispatch Type getUmlTypeFromReference(org.emftext.language.java.types.PrimitiveType jRef, CorrespondenceModel cm){
		return mapJavaPrimitiveToUmlPrimitive(jRef, cm)
	}
	def static dispatch Type getUmlTypeFromReference(ClassifierReference jRef, CorrespondenceModel cm){
		val unwrappedPrimitive = unwrapWrappedPrimitiveType(jRef)
		if (unwrappedPrimitive !== null) return getUmlTypeFromReference(jRef, cm)
		
		val classifier = getClassifier(jRef)
		if (classifier !== null)
			return ReactionsCorrespondenceHelper.getCorrespondingObjectsOfType(cm, classifier, null, Type).head
		else {
			return null
		}
	}
	def static dispatch Type getUmlTypeFromReference(NamespaceClassifierReference jRef, CorrespondenceModel cm){
		return 
			if(!jRef.classifierReferences.nullOrEmpty) 
				getUmlTypeFromReference(jRef.classifierReferences.head, cm) 
			else null
	}
	
	
	//Copied from Java2PCMUtils
	def private static normalizeURI(EObject eObject) {
		if (null === eObject.eResource || null === eObject.eResource.resourceSet) {
			return false
		}
		val resource = eObject.eResource
		val resourceSet = resource.resourceSet
		val uri = resource.getURI
		val uriConverter = resourceSet.getURIConverter
		val normalizedURI = uriConverter.normalize(uri)
		resource.URI = normalizedURI
		return true
	}
	
	def static String getQualifiedName(Classifier classifier){
		if (classifier instanceof ConcreteClassifier){
			val namespace = if (classifier.containingCompilationUnit !== null) classifier.containingCompilationUnit.namespaces.join(".") else ""
			val qualifiedName = if (namespace != "") namespace + "." + classifier.name else classifier.name
			return qualifiedName
		}
		else {
			// can't retrieve namespaces
			return classifier.name
		}
	}
	
	def static org.emftext.language.java.types.PrimitiveType unwrapWrappedPrimitiveType(TypeReference jRef){
		val classifier = getClassifierFromTypeReference(jRef)
		if (classifier === null) return null
		val qualifiedName = getQualifiedName(classifier)
		
		return switch(qualifiedName){
			case "java.lang.Boolean":	TypesFactory.eINSTANCE.createBoolean
			case "java.lang.Byte":		TypesFactory.eINSTANCE.createByte
			case "java.lang.Character":	TypesFactory.eINSTANCE.createChar
			case "java.lang.Double":	TypesFactory.eINSTANCE.createDouble
			case "java.lang.Float":		TypesFactory.eINSTANCE.createFloat
			case "java.lang.Integer":	TypesFactory.eINSTANCE.createInt
			case "java.lang.Long":		TypesFactory.eINSTANCE.createLong
			case "java.lang.Short":		TypesFactory.eINSTANCE.createShort
			case "java.lang.Void":		TypesFactory.eINSTANCE.createVoid
			default: null
		}
	}
	
	def static PrimitiveType mapJavaPrimitiveToUmlPrimitive(org.emftext.language.java.types.PrimitiveType jRef, CorrespondenceModel cm){
		//TODO
	}
	
	def static org.emftext.language.java.types.PrimitiveType mapUmlPrimitiveToJavaPrimitive(PrimitiveType uType){
		//TODO
	}
	
	/////////////////////////////////////////////
	/////////////////////////////////////////////
		
	def static void addJavaImport(CompilationUnit compUnit, TypeReference jTypeRef){
		if (jTypeRef instanceof org.emftext.language.java.types.PrimitiveType){
			return // nothing to do
		}
		else if (jTypeRef.target !== null && jTypeRef.target instanceof ConcreteClassifier){
			val jType = jTypeRef.target as ConcreteClassifier
			addJavaImport(compUnit, jType)
			//add imports for typeArguments if any exist
			if (jTypeRef instanceof NamespaceClassifierReference){
				val typeArguments = (jTypeRef as NamespaceClassifierReference).classifierReferences.get(0).typeArguments
				for (typeArgument : typeArguments.filter(QualifiedTypeArgument).filter[it.typeReference !== null]){
					typeArgument.typeReference
					addJavaImport(compUnit, typeArgument.typeReference)
				}
			}
		}
		else {
			//shouldn't occur
		}
	}
	
	def static ClassifierImport addJavaImport(CompilationUnit compUnit, ConcreteClassifier jType){
		if (compUnit === null){
			throw new IllegalStateException("Tried to add a java import without passing a CompilationUnit.")
		}
		if (jType === null || jType instanceof org.emftext.language.java.types.PrimitiveType){
			return null // nothing to do
		}
		
		val targetNamespace = if (jType.containingCompilationUnit !== null) jType.containingCompilationUnit.namespaces.join(".") else ""
		val qualifiedName = if (targetNamespace != "") targetNamespace + "." + jType.name else jType.name
		
		val samePackage = false // TODO targetNamespace.equals(compUnit.namespaces.join("."))
		val alreadyImported = compUnit.imports.filterNull.filter(ClassifierImport).exists[
			it.classifier.name == jType.name
			// EcoreUtil.equals(it.classifier, jType) 
			// compares all features and internal references (which is expensive for real classes like ArrayList)
		]
		if (!samePackage && !alreadyImported) {
			val classifierImport = ImportsFactory.eINSTANCE.createClassifierImport
			if (null !== jType.containingCompilationUnit) {
				if (null !== jType.containingCompilationUnit.namespaces) {
					classifierImport.namespaces.addAll(jType.containingCompilationUnit.namespaces)
				}
			}
			classifierImport.classifier = jType
			compUnit.imports.add(classifierImport)
			return classifierImport
	    }
	    else {
	    	return null // nothing to do
	    }
	}
	
	
	def static TypeReference createTypeReference(
		Type uType, 
		Optional<? extends ConcreteClassifier> jType, 
		TypeReference defaultReference,
		UserInteractor userInteractor
	){
		var TypeReference typeReference = null
    	if (jType.isPresent) {
    		typeReference = JavaModificationUtil.createNamespaceClassifierReference(jType.get)
    	}
    	else if (uType !== null && uType instanceof PrimitiveType) {
    		typeReference = mapUmlPrimitiveToJavaPrimitive(uType as PrimitiveType) // TODO impl correct mapping
    	}
    	else if (uType === null) {
    		typeReference = defaultReference
    	}
    	
    	if (typeReference === null){
    		showMessage(userInteractor, "Something went wrong and no java::TypeReference could be created for:\n\t" + uType
    			+ "\nUsing " + defaultReference.target +" instead."
    		)
    		typeReference = defaultReference
    	}
    	return typeReference
	}
	
	def static NamespaceClassifierReference createCollectionTypeReference (
		NamespaceClassifierReference collectionTypeReference,
		TypeReference innerTypeReference
	){    	
		// wrap typeReference if necessary
		var wrappedInnerReference = innerTypeReference
		if (wrappedInnerReference instanceof org.emftext.language.java.types.PrimitiveType){
			wrappedInnerReference = JavaModificationUtil.getWrapperTypeReferenceForPrimitiveType(wrappedInnerReference)
		}
		
        // set the inner type reference on the NamespaceClassifierReference of the Collection type
        val qualifiedTypeArgument = GenericsFactory.eINSTANCE.createQualifiedTypeArgument();
		qualifiedTypeArgument.typeReference = wrappedInnerReference;
		collectionTypeReference.classifierReferences.get(0).typeArguments += qualifiedTypeArgument;
		
		return collectionTypeReference
	}
	
	def static NamespaceClassifierReference createCollectionTypeReference (
		ConcreteClassifier collectionTypeClassifier,
		TypeReference innerTypeReference
	){
    	val collectionTypeReference = JavaModificationUtil.createNamespaceClassifierReference(collectionTypeClassifier)
		return createCollectionTypeReference(collectionTypeReference, innerTypeReference)
	}
	
	def static NamespaceClassifierReference createCollectionTypeReference (
		Class<? extends Collection> collectionType,
		TypeReference innerTypeReference
	){
    	val collectionNamespace = collectionType.name.replace("." + collectionType.simpleName, "")
    	val collectionSimpleName = collectionType.simpleName
    	val collectionTypeReference = JavaModificationUtil.createNamespaceClassifierReferenceForName(collectionNamespace, collectionSimpleName)
    	
		return createCollectionTypeReference(collectionTypeReference, innerTypeReference)
	}
	
	
	
	////////////////////// type propagation routine uml <-> java////////////
	
	private def static propagateTypedMultiplicityElementTypeChanged(
		TypedElement uElement, int lower, int upper, // uml::Property or uml::Parameter
		org.emftext.language.java.types.TypedElement jElement, // java::Field, java::Parameter, or java::Method
		Optional<? extends ConcreteClassifier> jType, // new type retrieved from correspondences
		TypeReference defaultReference,
		UserInteractor userInteractor
	) {
    	var typeReference = createTypeReference(uElement.type, jType, defaultReference, userInteractor)
    	
		if(lower == 0 && upper == LiteralUnlimitedNatural.UNLIMITED) {
    		if(isCollectionTypeReference(jElement.typeReference)){
    			// reuse previously selected CollectionType
    			val collectionClassifier = getClassifier(jElement.typeReference) as ConcreteClassifier
    			typeReference = createCollectionTypeReference(collectionClassifier, typeReference)
    		}
    		else {
    			// no previously selected CollectionType
	        	val Class<? extends Collection> collectionType = userSelectCollectionType(userInteractor)
				typeReference = createCollectionTypeReference(collectionType, typeReference)
    		}
		}
		
		jElement.typeReference = typeReference
		addJavaImport(jElement.containingCompilationUnit, typeReference)
	}
	
	def static propagateTypedMultiplicityElementTypeChanged_defaultObject(
		TypedElement uElement, int lower, int upper, // uml::Property or uml::Parameter
		org.emftext.language.java.types.TypedElement jElement, // java::Field, java::Parameter, or java::Method
		Optional<? extends ConcreteClassifier> jType, // new type retrieved from correspondences
		UserInteractor userInteractor
	) {
		val objectNsRef = JavaModificationUtil.createNamespaceClassifierReference(jElement.objectClass)// default to java.lang.Object
		propagateTypedMultiplicityElementTypeChanged(uElement, lower, upper, jElement, jType, objectNsRef, userInteractor)
	}
	
	def static propagateTypedMultiplicityElementTypeChanged_defaultVoid(
		TypedElement uElement, int lower, int upper, // uml::Property or uml::Parameter
		org.emftext.language.java.types.TypedElement jElement, // java::Field, java::Parameter, or java::Method
		Optional<? extends ConcreteClassifier> jType, // new type retrieved from correspondences
		UserInteractor userInteractor
	) {
		val voidRef = TypesFactory.eINSTANCE.createVoid
		propagateTypedMultiplicityElementTypeChanged(uElement, lower, upper, jElement, jType, voidRef, userInteractor)
	}
	
	def static propagateTypeChangeToTypedMultiplicityElement(
		TypedElement uTyped, MultiplicityElement uMultiplicity, // same element -- uml::Property or uml::Parameter
		org.emftext.language.java.types.TypedElement jElement, // java::Field, java::Parameter, or java::Method
		CorrespondenceModel cm
	){
		val jType = jElement.typeReference
		val isCollectionReference = isCollectionTypeReference(jType)
    	if (isCollectionReference){
    		uMultiplicity.lower = 0
    		uMultiplicity.upper = LiteralUnlimitedNatural.UNLIMITED
    		val innerTypeRef = getInnerTypeRefOfCollectionReference(jType)
    		val innerType = if(innerTypeRef !== null) getUmlTypeFromReference(innerTypeRef, cm) else null
    		uTyped.type = innerType
    	}
    	else {
    		uTyped.type = getUmlTypeFromReference(jType, cm)
    	}
	}
	
}