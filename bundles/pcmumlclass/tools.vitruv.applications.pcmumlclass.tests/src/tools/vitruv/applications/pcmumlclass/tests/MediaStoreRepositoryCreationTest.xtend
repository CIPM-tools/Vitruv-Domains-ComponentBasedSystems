package tools.vitruv.applications.pcmumlclass.tests

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import org.apache.log4j.Logger
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.compare.Comparison
import org.eclipse.emf.compare.EMFCompare
import org.eclipse.emf.compare.scope.DefaultComparisonScope
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.Model
import org.eclipse.uml2.uml.Package
import org.eclipse.uml2.uml.PackageableElement
import org.eclipse.uml2.uml.Parameter
import org.junit.Test
import tools.vitruv.applications.pcmumlclass.DefaultLiterals

import static org.junit.Assert.*
import org.eclipse.uml2.uml.Interface
import org.eclipse.emf.ecore.EObject
import org.palladiosimulator.pcm.repository.Repository
import org.junit.Ignore
import org.palladiosimulator.pcm.repository.ProvidedRole

class MediaStoreRepositoryCreationTest extends PcmUmlClassApplicationTest {

    protected static val final Logger logger = Logger.getLogger(typeof(MediaStoreRepositoryCreationTest).simpleName);

//	private static val PCM_MEDIA_STORE_REPOSITORY_PATH = "resources/model/ms.repository"
	// all SEFFs removed because the TUID-generator failed for ResourceDemandParameters 
	private static val PCM_MEDIA_STORE_REPOSITORY_PATH = "resources/model/ms_noSEFF.repository" 
	// MediaAccess-Component removed, because the TUIDs of the two uml::Generalization corresponding to the two ProvidedRoles 
	// collide, since their types are null before the type is set, because of the delayed attribute set. 
	// Any subsequent changes on one of the Generalizations (e.g. setting the correct general-value) changes both correspondence entries,
	// which leads to multiple ProvidedInterface-Correspondences being detected for one Generalization and an exception being thrown on the next change.  
	// SOLVED by stepwise ProvidedRole insertion
//	private static val PCM_MEDIA_STORE_REPOSITORY_PATH = "resources/model/ms_noSEFF_noMediaAccess.repository" 

	private static val UML_MEDIA_STORE_REPOSITORY_PATH = "resources/model/ms_repository_noSEFF_unedited.uml"
//	private static val UML_MEDIA_STORE_REPOSITORY_PATH = "resources/model/ms_repository_noSEFF_noMediaAccess_unedited.uml"
	 
	private static val UML_GENERATED_MEDIA_STORE_MODEL_PATH = "model-gen/ms_repository.uml"
	private static val PCM_GENERATED_MEDIA_STORE_MODEL_PATH = "model-gen/ms_repository.repository"
	private static val UML_GENERATED_MEDIA_STORE_MODEL_PATH_2 = "model-gen/ms_repository_backward.uml"
	private static val PCM_GENERATED_MEDIA_STORE_MODEL_PATH_2 = "model-gen/ms_repository_backward.repository"

	@Test
	@Ignore //skip until needed because of performance
	def void testMediaStoreRepositoryCreation_PCM2UML() {
		val uri = URI.createURI(PCM_MEDIA_STORE_REPOSITORY_PATH)
		val pcmMsRepositoryResource = resourceSet.getResource(uri,true)
		assertNotNull(pcmMsRepositoryResource)
		val pcmMsRepository = pcmMsRepositoryResource.contents.head as Repository
		assertNotNull(pcmMsRepository)
		
		simulateRepositoryInsertion_PCM(pcmMsRepository, PCM_GENERATED_MEDIA_STORE_MODEL_PATH, UML_GENERATED_MEDIA_STORE_MODEL_PATH)
		
		assertModelExists(PCM_GENERATED_MEDIA_STORE_MODEL_PATH)
		assertModelExists(UML_GENERATED_MEDIA_STORE_MODEL_PATH)
	}
	
	private def simulateRepositoryInsertion_PCM(Repository inOriginalRepository, String pcmOutputPath, String umlOutputPath){
		val originalRepository = inOriginalRepository
		val originalComponentList = originalRepository.components__Repository.clone.toList
		// insert ProvidedRoles later one by one, to avoid TUID collisions
		val originalComponentProvidedRoleMap = new HashMap<String, List<ProvidedRole>>()
		for (originalComponent : originalRepository.components__Repository){
			originalComponentProvidedRoleMap.put(originalComponent.entityName, originalComponent.providedRoles_InterfaceProvidingEntity.clone.toList)
			originalComponent.providedRoles_InterfaceProvidingEntity.clear
		}
		
		userInteractor.addNextTextInput(umlOutputPath) // answers where to save the corresponding .uml model
		createAndSynchronizeModel(pcmOutputPath, originalRepository)
		var generatedRepository = reloadResourceAndReturnRoot(originalRepository) as Repository
		
		// now insert ProvidedRoles one by one and synchronize in between, to avoid TUID collisions
		for (originalComponent : originalComponentList){
			for (originalPrividedRole : originalComponentProvidedRoleMap.getOrDefault(originalComponent.entityName, new ArrayList<ProvidedRole>())){
				val generatedComponent = generatedRepository.components__Repository.findFirst[it.entityName == originalComponent.entityName]
				assertNotNull(generatedComponent)
				generatedComponent.providedRoles_InterfaceProvidingEntity += originalPrividedRole
				saveAndSynchronizeChanges(generatedRepository)
				generatedRepository = reloadResourceAndReturnRoot(generatedRepository) as Repository
			}
		}
		return generatedRepository 
	}
	
	@Test
	@Ignore //skip until needed because of performance
	def void testMediaStoreRepositoryCreation_UML2PCM() {
		val uri = URI.createURI(UML_MEDIA_STORE_REPOSITORY_PATH)
		val umlMsRepositoryResource = resourceSet.getResource(uri,true)
		assertNotNull(umlMsRepositoryResource)
		val umlMsModel = umlMsRepositoryResource.contents.head as Model
		assertNotNull(umlMsModel)
		simulateRepositoryInsertion_UML(umlMsModel, UML_GENERATED_MEDIA_STORE_MODEL_PATH, PCM_GENERATED_MEDIA_STORE_MODEL_PATH)
	}
	
	@Test
	@Ignore //skip until needed because of performance
	def void testMediaStoreRepositoryCreation_PCM2UML2PCM() {
		// forwards
		val uri = URI.createURI(PCM_MEDIA_STORE_REPOSITORY_PATH)
		val pcmMsRepositoryResource = resourceSet.getResource(uri,true)
		assertNotNull(pcmMsRepositoryResource)
		val pcmMsRepository = pcmMsRepositoryResource.contents.head as Repository
		assertNotNull(pcmMsRepository)
		
		simulateRepositoryInsertion_PCM(pcmMsRepository, PCM_GENERATED_MEDIA_STORE_MODEL_PATH, UML_GENERATED_MEDIA_STORE_MODEL_PATH)
		
		assertModelExists(PCM_GENERATED_MEDIA_STORE_MODEL_PATH)
		assertModelExists(UML_GENERATED_MEDIA_STORE_MODEL_PATH)
		
		// backwards 
		val umlMsRepositoryResource = getModelResource(UML_GENERATED_MEDIA_STORE_MODEL_PATH)
		assertNotNull(umlMsRepositoryResource)
		val umlMsModel = umlMsRepositoryResource.contents.head as Model
		assertNotNull(umlMsModel)
		simulateRepositoryInsertion_UML(umlMsModel, UML_GENERATED_MEDIA_STORE_MODEL_PATH_2, PCM_GENERATED_MEDIA_STORE_MODEL_PATH_2)
		
		assertModelExists(PCM_GENERATED_MEDIA_STORE_MODEL_PATH_2)
		assertModelExists(UML_GENERATED_MEDIA_STORE_MODEL_PATH_2)
		
		val comparison = compare(
			resourceSet.getResource(URI.createURI(PCM_MEDIA_STORE_REPOSITORY_PATH),true), 
			getModelResource(PCM_GENERATED_MEDIA_STORE_MODEL_PATH_2)
		)
		assertEquals("Encountered differences after round-trip batch creation. (that was kind of expected)" + comparison.differences.size, 0, comparison.differences.size)
		// expected (and found deltas):
		//	- each PCM element has a different id since it is unique and those are newly generated elements
		//	- the ProvidedRole elements are detected as deletion and add, because id and name are changed (name cannot be synchronized via UML)
		//	- TODO PrimitiveType references are unset, because their synchronization does not work yet
		//	- Parameter modifiers are set to INOUT, because UML has no enum element for NONE
		//	- FailureType is lost, because it is not propagated (limited scope of this master's thesis)
	}
	
	private def simulateDataTypeInsertion_UML(Model umlRepositoryModel, PackageableElement umlDataType){
		val repositoryPackage = umlRepositoryModel.nestedPackages.head
		assertNotNull(repositoryPackage)
		val datatypesPackage = repositoryPackage.nestedPackages
			.findFirst[it.name == DefaultLiterals.DATATYPES_PACKAGE_NAME]
		assertNotNull(datatypesPackage)
		
		datatypesPackage.packagedElements += umlDataType
		saveAndSynchronizeChanges(umlRepositoryModel)
		return reloadResourceAndReturnRoot(umlRepositoryModel) as Model 
	}
	
	private def simulateContractsPackageElementInsertion_UML(Model umlRepositoryModel, PackageableElement originalContractsPackageElement){
		var repositoryPackage = umlRepositoryModel.nestedPackages.head
		assertNotNull(repositoryPackage)
		var contractsPackage = repositoryPackage.nestedPackages
			.findFirst[it.name == DefaultLiterals.CONTRACTS_PACKAGE_NAME]
		assertNotNull(contractsPackage)
		
		if (!(originalContractsPackageElement instanceof Interface)){
			contractsPackage.packagedElements += originalContractsPackageElement
			return umlRepositoryModel
		}
		val originalInterface = originalContractsPackageElement as Interface
		
		// add each operation without its parameters because at least the returnParameters will be already generated
		val originalOperationParameterMapping = new HashMap<String, List<Parameter>>()
		for (originalOperation : originalInterface.ownedOperations){
			originalOperationParameterMapping.put(originalOperation.name, originalOperation.ownedParameters.clone.toList)
			originalOperation.ownedParameters.clear
		}
		contractsPackage.packagedElements += originalInterface
		saveAndSynchronizeChanges(umlRepositoryModel)
		
		//retrieve elements after reload
		repositoryPackage = umlRepositoryModel.nestedPackages.head
		assertNotNull(repositoryPackage)
		contractsPackage = repositoryPackage.nestedPackages
			.findFirst[it.name == DefaultLiterals.CONTRACTS_PACKAGE_NAME]
		assertNotNull(contractsPackage)
		var generatedInterface = contractsPackage.packagedElements
			.filter(Interface).findFirst[it.name == originalInterface.name]
		assertNotNull(generatedInterface)
		
		for (generatedOperation : generatedInterface.ownedOperations){
			// merge each Parameter from the originalOperation with the generated Operation element
			for (originalParameter : originalOperationParameterMapping.getOrDefault(generatedOperation.name, new ArrayList<Parameter>)){
				val generatedParameter = generatedOperation.ownedParameters.findFirst[it.name == originalParameter.name]
				if (generatedParameter !== null){
					mergeElements(originalParameter, generatedParameter, "name")
				}
				else {
					generatedOperation.ownedParameters += originalParameter // else add the whole Parameter
				}
			}
		}
		
		saveAndSynchronizeChanges(umlRepositoryModel)
		return reloadResourceAndReturnRoot(umlRepositoryModel) as Model
	}
	
	
	private def simulateComponentInsertion_UML(Model inUmlRepositoryModel, Package originalComponentPackage, int userDisambigutationComponentType){
		var generatedModel = inUmlRepositoryModel
		var generatedRepositoryPackage = generatedModel.nestedPackages.head
		assertNotNull(generatedRepositoryPackage)
		
		// Simulate adding a Component via round-trip by adding the components package.
		// For that, first remove the implementation from the original package to avoid duplication.
		val originalComponentImpl = originalComponentPackage.packagedElements.filter(Class).head
		assertNotNull(originalComponentImpl)
		originalComponentPackage.packagedElements -= originalComponentImpl
		assertTrue(originalComponentPackage.packagedElements.empty)
		
		userInteractor.addNextSingleSelection(userDisambigutationComponentType)
		generatedRepositoryPackage.nestedPackages += originalComponentPackage //throws UUID error when tested on its own
		saveAndSynchronizeChanges(generatedModel) //should generate generatedComponentImpl
		generatedModel = reloadResourceAndReturnRoot(generatedModel) as Model 
		
		generatedRepositoryPackage = generatedModel.nestedPackages.head
		assertNotNull(generatedRepositoryPackage)
		var generatedComponentPackage = generatedRepositoryPackage.nestedPackages
			.findFirst[it.name == originalComponentPackage.name]
		assertNotNull(generatedComponentPackage)
		var generatedComponentImpl = generatedComponentPackage.packagedElements
			.filter(Class).findFirst[it.name == originalComponentImpl.name]
		assertNotNull(generatedComponentImpl)
		
		// merge everything except operations which are separately handled, because the constructor and some of its parameters will have been generated.
		mergeElements(originalComponentImpl, generatedComponentImpl, "ownedOperation")
		
		// merge the original with the generated constructor
		val originalConstructor = originalComponentImpl.ownedOperations.findFirst[it.name == originalComponentImpl.name]
		val generatedConstructor = generatedComponentImpl.ownedOperations.findFirst[it.name == originalComponentImpl.name]
		assertNotNull(originalConstructor)
		assertNotNull(generatedConstructor)
//		mergeElements(originalConstructor, generatedConstructor, "ownedParameter") // somehow still removes the parameters and dangling elements cause exception
		for (originalParameter : originalConstructor.ownedParameters.clone){
			val generatedParameter = generatedConstructor.ownedParameters.findFirst[it.name == originalParameter.name]
			if (generatedParameter !== null){
				mergeElements(originalParameter, generatedParameter, "name")
			}
			else {
				generatedConstructor.ownedParameters += originalParameter
			}
		}
		// move/copy the remaining operations
		for (originalOperation : originalComponentImpl.ownedOperations.clone.filter[it.name != originalComponentImpl.name]){
			generatedComponentImpl.ownedOperations += originalOperation
		}
		
		saveAndSynchronizeChanges(generatedModel)
		generatedModel = reloadResourceAndReturnRoot(generatedModel) as Model 
		return generatedModel
	}
	
	private def simulateRepositoryInsertion_UML(Model originalRepositoryModel, String umlOutputPath, String pcmOutputPath) {
		assertNotNull(originalRepositoryModel)
		val umlRepositoryPackage = originalRepositoryModel.nestedPackages.head
		assertNotNull(umlRepositoryPackage)
		val originalContractsPackage = umlRepositoryPackage.nestedPackages
			.findFirst[it.name == DefaultLiterals.CONTRACTS_PACKAGE_NAME]
		val originalDatatypesPackage = umlRepositoryPackage.nestedPackages
			.findFirst[it.name == DefaultLiterals.DATATYPES_PACKAGE_NAME]
		val originalComponentPackages = umlRepositoryPackage.nestedPackages
			.filter[it !== originalContractsPackage && it !== originalDatatypesPackage].toList
		umlRepositoryPackage.nestedPackages.clear
		
		userInteractor.addNextSingleSelection(DefaultLiterals.USER_DISAMBIGUATE_REPOSITORY_SYSTEM__REPOSITORY) // rootelement is supposed to be a repository
		userInteractor.addNextTextInput(pcmOutputPath) // answers where to save the corresponding .pcm model
		createAndSynchronizeModel(umlOutputPath, originalRepositoryModel)
		var generatedModel = reloadResourceAndReturnRoot(originalRepositoryModel) as Model
		
		// Create copies of the lists outside the model so that containment is irrelevant
		// and that the loops do not iterate over a changing List.
		for (originalDatatype : originalDatatypesPackage.packagedElements.clone){
			generatedModel = simulateDataTypeInsertion_UML(generatedModel, originalDatatype) 
		}
		for (originalContractsPackageElement : originalContractsPackage.packagedElements.clone){
			generatedModel = simulateContractsPackageElementInsertion_UML(generatedModel, originalContractsPackageElement)
		}
		for (originalComponentPackage : originalComponentPackages){
			generatedModel = simulateComponentInsertion_UML(generatedModel, originalComponentPackage, DefaultLiterals.USER_DISAMBIGUATE_REPOSITORYCOMPONENT_TYPE__BASIC_COMPONENT)
		}
		return generatedModel
	}
	
	public def Comparison compare(Notifier original, Notifier generated) {
		val comparator = EMFCompare.builder().build();
		val scope = new DefaultComparisonScope(original, generated, original)
		return comparator.compare(scope);
	}
	
	public def mergeElements(EObject original, EObject generated, String ... skipFeatures){
		for (feature : original.eClass.EAllStructuralFeatures){
			if(!feature.derived && feature.changeable && original.eIsSet(feature) && !skipFeatures.contains(feature.name)){
				generated.eSet(feature, original.eGet(feature))
			}
		}
	}
}
