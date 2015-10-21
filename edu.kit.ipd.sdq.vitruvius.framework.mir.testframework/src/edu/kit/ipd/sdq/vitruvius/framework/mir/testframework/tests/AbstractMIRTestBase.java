package edu.kit.ipd.sdq.vitruvius.framework.mir.testframework.tests;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;

import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.FileChange.FileChangeKind;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.helpers.JavaHelper;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.impl.AbstractMIRChange2CommandTransforming;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.impl.AbstractMIRMappingRealization;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.interfaces.MIRMappingRealization;
import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.interfaces.MIRUserInteracting;
import edu.kit.ipd.sdq.vitruvius.framework.mir.helpers.EclipseProjectHelper;
import edu.kit.ipd.sdq.vitruvius.framework.run.changesynchronizer.ChangeSynchronizerImpl;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.EcoreResourceBridge;
import edu.kit.ipd.sdq.vitruvius.framework.util.bridges.JavaBridge;
import edu.kit.ipd.sdq.vitruvius.tests.VitruviusEMFCasestudyTest;
import edu.kit.ipd.sdq.vitruvius.tests.util.TestUtil;

import static org.junit.Assert.*;

/**
 * Abstract test class for a mapping generated by MIR.
 * 
 * @author Dominik Werle
 */
public abstract class AbstractMIRTestBase extends VitruviusEMFCasestudyTest {
	private static final Logger LOGGER = Logger.getLogger(AbstractMIRTestBase.class);
	private static final String MODEL_PATH = TestUtil.PROJECT_URI + "/model";
	
	protected TestMIRUserInteracting userInteracting = new TestMIRUserInteracting();

	@Override
	protected void setUserInteractor(UserInteracting newUserInteracting, ChangeSynchronizerImpl changeSynchronizerImpl)
			throws Throwable {
		// not in MIR mappings
		// TODO: check if the correct type is inherited / rewrite
	}

	@Override
	public void setUpTest() throws Throwable {
		LOGGER.trace("generating project " + TestUtil.PROJECT_URI + " and MIR file...");
		EclipseProjectHelper eph = new EclipseProjectHelper(TestUtil.PROJECT_URI);
		eph.reinitializeProject();
		eph.getProject().getFolder("model").create(true, true, null);

		super.setUpTest();

		// The Change2CommandTransfomer class has to be loaded here to determine the
		// mappings for injection.
		@SuppressWarnings("unchecked")
		Set<MIRMappingRealization> mappings = Collections
				.checkedSet(JavaHelper.requireType(
						getChange2CommandTransformerClass()
								.getField(AbstractMIRChange2CommandTransforming.MAPPINGS_FIELD_NAME).get(null),
						Set.class), AbstractMIRMappingRealization.class);

		for (MIRMappingRealization mapping : mappings) {
			JavaBridge.setFieldInClass(AbstractMIRMappingRealization.class, "userInteracting", mapping,
					userInteracting);
		}
	}

	// Utility functions
	/**
	 * Creates a model, saves it and triggers synchronisation. The Path of the
	 * model is relative to {@link MODEL_PATH} (normally: MockupProject/model).
	 */
	protected <T extends EObject> T createManipulateSaveAndSyncModel(String modelPath, Supplier<T> manipulate)
			throws IOException {
		final String resourcePath = MODEL_PATH + "/" + modelPath;

		final VURI resourceVURI = VURI.getInstance(resourcePath);

		final T result = manipulate.get();
		final URI resourceURI = URI.createPlatformResourceURI(resourcePath, false);
		final Resource resource = EcoreResourceBridge.loadResourceAtURI(resourceURI, resourceSet);
		EcoreResourceBridge.saveEObjectAsOnlyContent(result, resource);

		this.synchronizeFileChange(FileChangeKind.CREATE, resourceVURI);

		return result;
	}

	protected EObject createAndSyncModelWithRootObject(String modelPath, EObject rootEObject) throws IOException {
		return createManipulateSaveAndSyncModel(modelPath, () -> rootEObject);
	}

	protected <T extends EObject, R> R recordManipulateSaveAndSync(T input, Function<T, R> manipulate)
			throws IOException {
		changeRecorder.beginRecording(Collections.singletonList(input));
		R result = manipulate.apply(input);
		EcoreResourceBridge.saveResource(input.eResource());
		this.triggerSynchronization(input);

		return result;
	}

	protected <T extends EObject> void recordManipulateSaveAndSync(T input, Consumer<T> manipulate) throws IOException {
		recordManipulateSaveAndSync(input, it -> {
			manipulate.accept(it);
			return null;
		});
	}
	
	protected static URI createModelURI(String fileName) {
		return URI.createPlatformResourceURI(MODEL_PATH + "/" + fileName, false);
	}
	
	/**
	 * @see JavaHelper#requireType(Object, Class)
	 * @see JavaHelper#requireType(Object, Class, String)
	 */
	protected static void assertType(String message, Object object, Class<?> type) {
		assertNotNull(object);
		assertTrue(message, type.isInstance(object));
	}
	
	protected static void assertOCL(String message, EObject context, String oclPredicate) {
		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		OCLHelper<EClassifier, ?, ?, Constraint> helper = ocl.createOCLHelper();

		OCLExpression<EClassifier> predicate = null;
		try {
			predicate = helper.createQuery(oclPredicate);
		} catch (ParserException e) {
			predicate = null;
			e.printStackTrace();
		}
		
		assertTrue(message, ocl.check(context, predicate));
	}

}
