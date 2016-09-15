package tools.vitruv.applications.jmljava.tests.unittests.synchronizers.java;

import org.emftext.language.java.commons.CommonsPackage;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.parameters.Parameter;
import org.emftext.language.java.types.TypesPackage;
import org.junit.Test;

import tools.vitruv.applications.jmljava.changesynchronizer.ChangeBuilder;
import tools.vitruv.applications.jmljava.helper.Utilities;
import tools.vitruv.framework.change.description.ConcreteChange;
import tools.vitruv.framework.metamodel.ModelInstance;
import tools.vitruv.framework.util.datatypes.Pair;
import tools.vitruv.applications.jmljava.tests.unittests.synchronizers.TransformationTestsBase;
import tools.vitruv.applications.jmljava.tests.unittests.utils.ModelLoader.IResourceFiles;

public class JavaParameterTransformationsTest extends TransformationTestsBase {

    private static enum ResourceFiles implements IResourceFiles {
        JAVA("JavaParameterTransformationsTest.java.resource"),
        JML("JavaParameterTransformationsTest.jml.resource"),
        HELPER("Helper_Elements.java.resource"),
        
        EXPECTED_Rename("JavaParameterTransformationsTest_EXPECTED_Rename.jml.resource"),
        EXPECTED_RenameWithSpecifications("JavaParameterTransformationsTest_EXPECTED_RenameWithSpecifications.jml.resource"),
        EXPECTED_ChangeType("JavaParameterTransformationsTest_EXPECTED_ChangeType.jml.resource");

        private String modelFileName;

        private ResourceFiles(String modelFileName) {
            this.modelFileName = modelFileName;
        }

        @Override
        public String getModelFileName() {
            return modelFileName;
        }
    }

    private CompilationUnit cuJava;
    private tools.vitruv.domains.jml.language.jML.CompilationUnit cuJML;

    @Override
    protected Pair<ModelInstance, ModelInstance> getModelInstances() throws Exception {
        ModelInstance miJava = loadModelInstance(ResourceFiles.JAVA);
        cuJava = miJava.getUniqueRootEObjectIfCorrectlyTyped(CompilationUnit.class);
        ModelInstance miJML = loadModelInstance(ResourceFiles.JML);
        cuJML = miJML
                .getUniqueRootEObjectIfCorrectlyTyped(tools.vitruv.domains.jml.language.jML.CompilationUnit.class);
        return new Pair<ModelInstance, ModelInstance>(miJava, miJML);
    }
    
    @Test
    public void testRename() throws Exception {
        CloneContainer<Parameter> param = createClones(cuJava.getClassifiers().get(0).getMethods().get(0).getParameters().get(0));
        param.changed().setName("d");
        
        ConcreteChange change = ChangeBuilder.createUpdateChange(param.original(), param.changed(), CommonsPackage.eINSTANCE.getNamedElement_Name());

        callSynchronizer(change);

        assertEqualsModel(ResourceFiles.EXPECTED_Rename, cuJML);
        assertNumberOfRealUpdateCalls(2);
        assertNumberOfCorrespondences(1, param.changed());
        assertNumberOfCorrespondences(0, param.original());
    }
    
    @Test
    public void testRenameWithSpecifications() throws Exception {
        CloneContainer<Parameter> param = createClones(cuJava.getClassifiers().get(0).getMethods().get(2).getParameters().get(1));
        param.changed().setName("b");
        
        ConcreteChange change = ChangeBuilder.createUpdateChange(param.original(), param.changed(), CommonsPackage.eINSTANCE.getNamedElement_Name());

        callSynchronizer(change);

        assertEqualsModel(ResourceFiles.EXPECTED_RenameWithSpecifications, cuJML);
        assertNumberOfRealUpdateCalls(2);
        assertNumberOfCorrespondences(1, param.changed());
        assertNumberOfCorrespondences(0, param.original());
    }
    
    @Test
    public void testChangeType() throws Exception {
        CloneContainer<Parameter> param = createClones(cuJava.getClassifiers().get(0).getMethods().get(0).getParameters().get(0));
        param.changed().setTypeReference(Utilities.clone(cuJava.getClassifiers().get(0).getMethods().get(2).getParameters().get(0).getTypeReference()));
        
        ConcreteChange change = ChangeBuilder.createUpdateChange(param.original(), param.changed(), TypesPackage.eINSTANCE.getTypedElement_TypeReference());
        
        callSynchronizer(change);
        
        assertEqualsModel(ResourceFiles.EXPECTED_ChangeType, cuJML);
        assertNumberOfRealUpdateCalls(2);
        assertNumberOfCorrespondences(1, param.changed());
        assertNumberOfCorrespondences(0, param.original());
    }

}
