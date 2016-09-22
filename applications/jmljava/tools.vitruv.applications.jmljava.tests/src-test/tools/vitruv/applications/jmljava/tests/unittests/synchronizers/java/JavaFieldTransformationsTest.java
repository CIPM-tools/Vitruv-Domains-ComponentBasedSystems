package tools.vitruv.applications.jmljava.tests.unittests.synchronizers.java;

import org.emftext.language.java.commons.CommonsPackage;
import org.emftext.language.java.containers.CompilationUnit;
import org.emftext.language.java.members.Field;
import org.emftext.language.java.modifiers.Modifier;
import org.emftext.language.java.modifiers.ModifiersFactory;
import org.emftext.language.java.modifiers.ModifiersPackage;
import org.emftext.language.java.types.TypeReference;
import org.emftext.language.java.types.TypesPackage;
import org.junit.Test;

import tools.vitruv.applications.jmljava.changesynchronizer.ChangeBuilder;
import tools.vitruv.applications.jmljava.helper.Utilities;
import tools.vitruv.framework.change.description.ConcreteChange;
import tools.vitruv.framework.metamodel.ModelInstance;
import tools.vitruv.framework.util.datatypes.Pair;
import tools.vitruv.applications.jmljava.tests.unittests.synchronizers.TransformationTestsBase;
import tools.vitruv.applications.jmljava.tests.unittests.synchronizers.TransformationTestsBase.CloneContainer;
import tools.vitruv.applications.jmljava.tests.unittests.utils.ModelLoader.IResourceFiles;

public class JavaFieldTransformationsTest extends TransformationTestsBase {
    
    private static enum ResourceFiles implements IResourceFiles {
        JAVA("JavaFieldTransformationsTest.java.resource"),
        JML("JavaFieldTransformationsTest.jml.resource"),
        HELPER("Helper_Elements.java.resource"),
        
        EXPECTED_Rename("JavaFieldTransformationsTest_EXPECTED_Rename.jml.resource"),
        EXPECTED_RenameWithSpecifications("JavaFieldTransformationsTest_EXPECTED_RenameWithSpecifications.jml.resource"),
        EXPECTED_ChangeType("JavaFieldTransformationsTest_EXPECTED_ChangeType.jml.resource"),
        EXPECTED_ReplaceModifier("JavaFieldTransformationsTest_EXPECTED_ReplaceModifier.jml.resource");

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
    public void testChangeName() throws Exception {
        CloneContainer<Field> field = createClones(cuJava.getClassifiers().get(0).getFields().get(1));
        field.changed().setName("otherName");
        
        ConcreteChange change = ChangeBuilder.createUpdateChange(field.original(), field.changed(), CommonsPackage.eINSTANCE.getNamedElement_Name());

        callSynchronizer(change);

        assertEqualsModel(ResourceFiles.EXPECTED_Rename, cuJML);
        assertNumberOfRealUpdateCalls(2);
        assertNumberOfCorrespondences(5, field.changed());
        assertNumberOfCorrespondences(0, field.original());
    }
    
    @Test
    public void testChangeNameWithSpecifications() throws Exception {
        CloneContainer<Field> field = createClones(cuJava.getClassifiers().get(0).getFields().get(0));
        field.changed().setName("otherName");

        ConcreteChange change = ChangeBuilder.createUpdateChange(field.original(), field.changed(), CommonsPackage.eINSTANCE.getNamedElement_Name());

        callSynchronizer(change);

        assertEqualsModel(ResourceFiles.EXPECTED_RenameWithSpecifications, cuJML);
        assertNumberOfRealUpdateCalls(2);
        assertNumberOfCorrespondences(5, field.changed());
        assertNumberOfCorrespondences(0, field.original());
    }
    
    @Test
    public void testReplaceModifier() throws Exception {
        CloneContainer<Field> field = createClones(cuJava.getClassifiers().get(0).getFields().get(1));
        Modifier newModifier = ModifiersFactory.eINSTANCE.createProtected();
        field.changed().getAnnotationsAndModifiers().remove(0);
        field.changed().getAnnotationsAndModifiers().add(0, newModifier);
        Modifier oldModifier = field.original().getModifiers().get(0);
        
        ConcreteChange change = ChangeBuilder.createReplaceChangeInList(field.original(), field.changed(), ModifiersPackage.eINSTANCE.getAnnotableAndModifiable_AnnotationsAndModifiers(), newModifier, oldModifier);
        
        callSynchronizer(change);

        assertEqualsModel(ResourceFiles.EXPECTED_ReplaceModifier, cuJML);
        assertNumberOfRealUpdateCalls(0);
        assertNumberOfCorrespondences(1, newModifier);
        assertNumberOfCorrespondences(0, oldModifier);
    }
    
    @Test
    public void testReplaceType() throws Exception {
        CloneContainer<Field> field = createClones(cuJava.getClassifiers().get(0).getFields().get(1));
        TypeReference newType = Utilities.clone(cuJava.getClassifiers().get(0).getMethods().get(2).getTypeReference());
        field.changed().setTypeReference(newType);
        
        ConcreteChange change = ChangeBuilder.createUpdateChange(field.original(), field.changed(), TypesPackage.eINSTANCE.getTypedElement_TypeReference());
        
        callSynchronizer(change);
        
        assertEqualsModel(ResourceFiles.EXPECTED_ChangeType, cuJML);
        assertNumberOfRealUpdateCalls(0);       
    }
}
