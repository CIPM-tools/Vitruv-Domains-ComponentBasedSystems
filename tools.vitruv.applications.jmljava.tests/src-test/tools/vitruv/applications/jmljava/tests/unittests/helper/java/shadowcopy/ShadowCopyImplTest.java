package tools.vitruv.applications.jmljava.tests.unittests.helper.java.shadowcopy;

import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.members.InterfaceMethod;
import org.junit.BeforeClass;
import org.junit.Test;

import tools.vitruv.domains.jml.language.jML.JMLSpecifiedElement;
import tools.vitruv.applications.jmljava.helper.java.shadowcopy.ShadowCopy;
import tools.vitruv.applications.jmljava.helper.Utilities;
import tools.vitruv.framework.correspondence.CorrespondenceModel;
import tools.vitruv.framework.metamodel.ModelInstance;
import tools.vitruv.framework.metamodel.ModelProviding;
import tools.vitruv.framework.util.datatypes.Pair;
import tools.vitruv.applications.jmljava.tests.unittests.utils.CommonTasks;
import tools.vitruv.applications.jmljava.tests.unittests.utils.Initializer;
import tools.vitruv.applications.jmljava.tests.unittests.utils.ModelLoader.IResourceFiles;

public class ShadowCopyImplTest {

	private enum JavaResourceFiles implements IResourceFiles {
		SingleLineSpecMethodSpecs("SingleLineSpecMethodSpecs.java.resource"), GhostFieldReference(
				"GhostFieldReference.java.resource"), BehaviorMethodSpecifications(
				"BehaviorMethodSpecifications.java.resource"), MultiLineSpecMethodSpecs(
				"MultiLineSpecMethodSpecs.java.resource"), Invariants(
				"Invariants.java.resource"), AbstractMethodInClass(
				"AbstractMethodInClass.java.resource"), ForallExpression(
				"ForallExpression.java.resource"), ArrayReturnType("ArrayReturnType.java.resource");

		private final String modelFileName;

		JavaResourceFiles(String modelFileName) {
			this.modelFileName = modelFileName;
		}

		@Override
		public String getModelFileName() {
			return modelFileName;
		}
	}

	private enum JMLResourceFiles implements IResourceFiles {
		SingleLineSpecMethodSpecs("SingleLineSpecMethodSpecs.jml.resource"), GhostFieldReference(
				"GhostFieldReference.jml.resource"), BehaviorMethodSpecifications(
				"BehaviorMethodSpecifications.jml.resource"), MultiLineSpecMethodSpecs(
				"MultiLineSpecMethodSpecs.jml.resource"), Invariants(
				"Invariants.jml.resource"), AbstractMethodInClass(
				"AbstractMethodInClass.jml.resource"), ForallExpression(
				"ForallExpression.jml.resource"), ArrayReturnType("ArrayReturnType.jml.resource"),

		SingleLineSpecMethodSpecs_EXPECTED(
				"SingleLineSpecMethodSpecs_EXPECTED.jml.resource"), GhostFieldReference_EXPECTED(
				"GhostFieldReference_EXPECTED.jml.resource"), BehaviorMethodSpecifications_EXPECTED(
				"BehaviorMethodSpecifications_EXPECTED.jml.resource"), AbstractMethodInClass_EXPECTED(
				"AbstractMethodInClass_EXPECTED.jml.resource"), AbstractMethodInClass_EXPECTED2(
						"AbstractMethodInClass_EXPECTED2.jml.resource"), ForallExpression_EXPECTED(
				"ForallExpression_EXPECTED.jml.resource"), ArrayReturnType_EXPECTED("ArrayReturnType_EXPECTED.jml.resource");

		private final String modelFileName;

		JMLResourceFiles(String modelFileName) {
			this.modelFileName = modelFileName;
		}

		@Override
		public String getModelFileName() {
			return modelFileName;
		}
	}

	private ShadowCopy shadowCopy;
	private CompilationUnit javaCu;
	private tools.vitruv.domains.jml.language.jML.CompilationUnit jmlCu;

	private void setup(JavaResourceFiles javaResource,
			JMLResourceFiles jmlResource, boolean useJMLCopy) throws Exception {
		ModelInstance javaModelInstance = CommonTasks.loadModelInstance(
				javaResource, ShadowCopyImplTest.class, true);
		javaCu = javaModelInstance
				.getUniqueRootEObjectIfCorrectlyTyped(CompilationUnit.class);
		ModelInstance jmlModelInstance = CommonTasks.loadModelInstance(
				jmlResource, ShadowCopyImplTest.class, true);
		jmlCu = jmlModelInstance
				.getUniqueRootEObjectIfCorrectlyTyped(tools.vitruv.domains.jml.language.jML.CompilationUnit.class);
		Pair<ModelInstance, ModelInstance> modelInstances = new Pair<ModelInstance, ModelInstance>(
				javaModelInstance, jmlModelInstance);
		ModelProviding modelProviding = CommonTasks
				.createModelProviding(modelInstances);
		CorrespondenceModel ci = CommonTasks.createCorrespondenceModel(
				CommonTasks.createMapping(), modelProviding, modelInstances);
		shadowCopy = CommonTasks.createShadowCopyFactory(javaModelInstance)
				.create(ci, useJMLCopy);
	}

	private void assertEqualsModels(JMLResourceFiles expected) throws Exception {
		CommonTasks.assertEqualsModel(
				CommonTasks.loadModelInstance(expected, this)
						.getUniqueRootEObject(), jmlCu);
	}

	@BeforeClass
	public static void init() {
		Initializer.initJaMoPP();
		Initializer.initJML();
		Initializer.initLogging();
	}

	/**
	 * Scenario: One method with single line specs for it, which reference its
	 * parameters. The parameter name is changed.
	 * 
	 * Expected result: The references in the specification are renamed too.
	 */
	@Test
	public void testSingleLineSpecMethodSpecs() throws Exception {
		setup(JavaResourceFiles.SingleLineSpecMethodSpecs,
				JMLResourceFiles.SingleLineSpecMethodSpecs, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		ClassMethod shadowCopyMethod = (ClassMethod) shadowCopy
				.getShadowCopyCorrespondences().getShadow(
						javaCu.getClassifiers().get(0).getMethods().get(0));
		shadowCopyMethod.getParameters().get(0).setName("qq123");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.SingleLineSpecMethodSpecs_EXPECTED);
	}

	/**
	 * Scenario: There are two specification only elements: A ghost field and a
	 * model method. The model method references the field in its body and
	 * specification. The name of the ghost field is changed.
	 * 
	 * Expected result: The references in the specification and the body are
	 * renamed too.
	 */
	@Test
	public void testGhostFieldReference() throws Exception {
		setup(JavaResourceFiles.GhostFieldReference,
				JMLResourceFiles.GhostFieldReference, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		JMLSpecifiedElement jmlGhostField = Utilities.getFirstChildOfType(
				jmlCu, JMLSpecifiedElement.class);
		Field shadowCopyField = (Field) shadowCopy
				.getShadowCopyCorrespondences().getMember(jmlGhostField);
		shadowCopyField.setName("owner2");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.GhostFieldReference_EXPECTED);
	}

	/**
	 * Scenario: There are two methods: A regular method with behavior
	 * specification clauses and a model method. The model method is referenced
	 * by the behavior specifications. The name of the model method is changed.
	 * 
	 * Expected result: The specifications are updated.
	 */
	@Test
	public void testBehaviorMethodSpecifications() throws Exception {
		setup(JavaResourceFiles.BehaviorMethodSpecifications,
				JMLResourceFiles.BehaviorMethodSpecifications, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		JMLSpecifiedElement jmlModelMethod = Utilities.getFirstChildOfType(
				jmlCu, JMLSpecifiedElement.class);
		ClassMethod shadowCopyMethod = (ClassMethod) shadowCopy
				.getShadowCopyCorrespondences().getMember(jmlModelMethod);
		shadowCopyMethod.setName("modelMethod2");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.BehaviorMethodSpecifications_EXPECTED);
	}

//	@Test
//	public void testDetectUnresolvedReferenceForModelMethod() throws Exception {
//		setup(JavaResourceFiles.BehaviorMethodSpecifications,
//				JMLResourceFiles.BehaviorMethodSpecifications, false);
//		shadowCopy.setupShadowCopyWithJMLSpecifications(false);
//		JMLSpecifiedElement jmlModelMethod = Utilities.getFirstChildOfType(
//				jmlCu, JMLSpecifiedElement.class);
//		Member shadowCopyMember = shadowCopy.getShadowCopyCorrespondences()
//				.getMember(jmlModelMethod);
//		Utilities.deleteEObjectInParent(shadowCopyMember);
//		Map<EObject, Collection<EStructuralFeature.Setting>> unresolvedReferences = shadowCopy
//				.findUnresolvedReferencesInShadowCopy();
//
//		assertEquals(2, unresolvedReferences.size());
//	}
//
//	@Test
//	public void testDetectUnresolvedReferenceForGhostField() throws Exception {
//		setup(JavaResourceFiles.GhostFieldReference,
//				JMLResourceFiles.GhostFieldReference, false);
//		shadowCopy.setupShadowCopyWithJMLSpecifications(false);
//		JMLSpecifiedElement jmlModelMethod = Utilities.getFirstChildOfType(
//				jmlCu, JMLSpecifiedElement.class);
//		Member shadowCopyMember = shadowCopy.getShadowCopyCorrespondences()
//				.getMember(jmlModelMethod);
//		Utilities.deleteEObjectInParent(shadowCopyMember);
//		Map<EObject, Collection<EStructuralFeature.Setting>> unresolvedReferences = shadowCopy
//				.findUnresolvedReferencesInShadowCopy();
//
//		assertEquals(2, unresolvedReferences.size());
//	}
//
//	@Test
//	public void testDetectUnresolvedReferenceForRegularMethod()
//			throws Exception {
//		setup(JavaResourceFiles.MultiLineSpecMethodSpecs,
//				JMLResourceFiles.MultiLineSpecMethodSpecs, false);
//		shadowCopy.setupShadowCopyWithJMLSpecifications(false);
//		shadowCopy.removeShadowCopyElementForOriginalElement(javaCu
//				.getClassifiers().get(0).getMembers().get(1));
//		Map<EObject, Collection<EStructuralFeature.Setting>> unresolvedReferences = shadowCopy
//				.findUnresolvedReferencesInShadowCopy();
//
//		assertEquals(1, unresolvedReferences.size());
//	}
//
//	@Test
//	public void testDetectUnresolvedReferenceForRegularMethodWithInvariants()
//			throws Exception {
//		setup(JavaResourceFiles.Invariants, JMLResourceFiles.Invariants, false);
//		shadowCopy.setupShadowCopyWithJMLSpecifications(false);
//		shadowCopy.removeShadowCopyElementForOriginalElement(javaCu
//				.getClassifiers().get(0).getMembers().get(0));
//		Map<EObject, Collection<EStructuralFeature.Setting>> unresolvedReferences = shadowCopy
//				.findUnresolvedReferencesInShadowCopy();
//
//		assertEquals(1, unresolvedReferences.size());
//	}
//
//	@Test
//	public void testDetectUnresolvedReferenceForRegularFieldWithInvariants()
//			throws Exception {
//		setup(JavaResourceFiles.Invariants, JMLResourceFiles.Invariants, false);
//		shadowCopy.setupShadowCopyWithJMLSpecifications(false);
//		shadowCopy.removeShadowCopyElementForOriginalElement(javaCu
//				.getClassifiers().get(0).getMembers().get(1));
//		Map<EObject, Collection<EStructuralFeature.Setting>> unresolvedReferences = shadowCopy
//				.findUnresolvedReferencesInShadowCopy();
//
//		assertFalse(unresolvedReferences.isEmpty());
//	}
//
//	@Test
//	public void testDetectUnresolevdReferenceForAbstractMethod()
//			throws Exception {
//		setup(JavaResourceFiles.AbstractMethodInClass,
//				JMLResourceFiles.AbstractMethodInClass, false);
//		shadowCopy.setupShadowCopyWithJMLSpecifications(false);
//		shadowCopy.removeShadowCopyElementForOriginalElement(javaCu
//				.getClassifiers().get(0).getMembers().get(1));
//		Map<EObject, Collection<EStructuralFeature.Setting>> unresolvedReferences = shadowCopy
//				.findUnresolvedReferencesInShadowCopy();
//
//		assertFalse(unresolvedReferences.isEmpty());
//	}

	@Test
	public void testRenamingForAbstractMethodParameter() throws Exception {
		setup(JavaResourceFiles.AbstractMethodInClass,
				JMLResourceFiles.AbstractMethodInClass, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		InterfaceMethod shadowCopyMethod = (InterfaceMethod) shadowCopy
				.getShadowCopyCorrespondences().getShadow(
						javaCu.getClassifiers().get(0).getMethods().get(0));
		shadowCopyMethod.getParameters().get(0).setName("qq123");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.AbstractMethodInClass_EXPECTED);
	}

	@Test
	public void testRenamingInForallExpression() throws Exception {
		setup(JavaResourceFiles.ForallExpression,
				JMLResourceFiles.ForallExpression, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		ClassMethod shadowCopyMethod = (ClassMethod) shadowCopy
				.getShadowCopyCorrespondences().getShadow(
						javaCu.getClassifiers().get(0).getMethods().get(0));
		shadowCopyMethod.getParameters().get(0).setName("qq123");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.ForallExpression_EXPECTED);
	}
	
	@Test
	public void testRenamingWithArrayReturnType() throws Exception {
		setup(JavaResourceFiles.ArrayReturnType,
				JMLResourceFiles.ArrayReturnType, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		ClassMethod shadowCopyMethod = (ClassMethod) shadowCopy
				.getShadowCopyCorrespondences().getShadow(
						javaCu.getClassifiers().get(0).getMethods().get(0));
		shadowCopyMethod.getParameters().get(0).setName("qq123");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.ArrayReturnType_EXPECTED);
	}
	
	@Test
	public void testRenamingMethodUsedInAbstractMethodSpecification() throws Exception {
		setup(JavaResourceFiles.AbstractMethodInClass,
				JMLResourceFiles.AbstractMethodInClass, false);
		shadowCopy.setupShadowCopyWithJMLSpecifications(true);
		ClassMethod shadowCopyMethod = (ClassMethod) shadowCopy.getShadowCopyCorrespondences().getShadow(javaCu.getClassifiers().get(0).getMethods().get(1));
		shadowCopyMethod.setName("qq123");
		shadowCopy.updateOriginalJMLSpecifications();

		assertEqualsModels(JMLResourceFiles.AbstractMethodInClass_EXPECTED2);
	}

}
