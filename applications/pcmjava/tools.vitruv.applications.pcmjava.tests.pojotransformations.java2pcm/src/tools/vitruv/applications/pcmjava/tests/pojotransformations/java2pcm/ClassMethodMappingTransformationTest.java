package tools.vitruv.applications.pcmjava.tests.pojotransformations.java2pcm;

import org.junit.Test;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;

import tools.vitruv.applications.pcmjava.tests.util.JaMoPP2PCMTransformationTest;
import tools.vitruv.applications.pcmjava.tests.util.PCM2JaMoPPTestUtils;

public class ClassMethodMappingTransformationTest extends Java2PCMPackageMappingTransformationTest {

    @Test
    public void testAddClassMethodWithCorrespondence() throws Throwable {
        // create repo
        super.addRepoContractsAndDatatypesPackage();
        this.testUserInteractor.addNextSelections(JaMoPP2PCMTransformationTest.SELECT_NOTHING_DECIDE_LATER);
        // create component implementing class
        super.addPackageAndImplementingClass(PCM2JaMoPPTestUtils.BASIC_COMPONENT_NAME);
        // create interface
        super.createInterfaceInPackageBasedOnJaMoPPPackageWithCorrespondence("contracts", PCM2JaMoPPTestUtils.INTERFACE_NAME);
        // create interface method
        super.addMethodToInterfaceWithCorrespondence(PCM2JaMoPPTestUtils.INTERFACE_NAME,
                PCM2JaMoPPTestUtils.OPERATION_SIGNATURE_1_NAME);
        // add implements/provided role
        super.addImplementsCorrespondingToOperationProvidedRoleToClass(
                PCM2JaMoPPTestUtils.BASIC_COMPONENT_NAME + "Impl", PCM2JaMoPPTestUtils.INTERFACE_NAME);

        // actual test: add class method to implementing class that overrides the interface
        final ResourceDemandingSEFF correspondingSeff = super.addClassMethodToClassThatOverridesInterfaceMethod(
                PCM2JaMoPPTestUtils.BASIC_COMPONENT_NAME + "Impl", PCM2JaMoPPTestUtils.OPERATION_SIGNATURE_1_NAME);

        // assert the correspondingSEFF
        assertCorrespondingSEFF(correspondingSeff,  PCM2JaMoPPTestUtils.OPERATION_SIGNATURE_1_NAME);
    }

}
