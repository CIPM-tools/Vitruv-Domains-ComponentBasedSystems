package tools.vitruv.applications.pcmjava.tests.pojotransformations.java2pcm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.Repository;

import tools.vitruv.applications.pcmjava.gplimplementation.pojotransformations.java2pcm.transformations.ClassMappingTransformation;
import tools.vitruv.applications.pcmjava.tests.util.PCM2JaMoPPTestUtils;

public class TypeReferenceMappingTransformationTest extends Java2PCMPackageMappingTransformationTest {

    @Test
    public void testAddImplementsToClassWithCorrespondingComponent() throws Throwable {
        // crete repo
        final Repository repo = this.addRepoContractsAndDatatypesPackage();
        // create class
        this.addSecondPackageCorrespondsWithoutCorrespondences();
        this.testUserInteractor.addNextSelections(ClassMappingTransformation.SELECT_CREATE_BASIC_COMPONENT);
        final BasicComponent basicComponent = this.addClassInSecondPackage(BasicComponent.class);
        this.createPackageWithPackageInfo(repo.getEntityName(), "contracts");
        // create interface
        final OperationInterface opInterface = this.createInterfaceInPackageBasedOnJaMoPPPackageWithCorrespondence("contracts",
                PCM2JaMoPPTestUtils.INTERFACE_NAME);

        // add the implement relation
        final OperationProvidedRole opr = super.addImplementsCorrespondingToOperationProvidedRoleToClass(
                basicComponent.getEntityName(), opInterface.getEntityName());

        assertEquals("The interface proivieded by the provided role is not the expected interface",
                opr.getProvidedInterface__OperationProvidedRole().getId(), opInterface.getId());
        assertEquals("The component that provides the interface is not the expected component",
                opr.getProvidingEntity_ProvidedRole().getId(), basicComponent.getId());
    }

}
