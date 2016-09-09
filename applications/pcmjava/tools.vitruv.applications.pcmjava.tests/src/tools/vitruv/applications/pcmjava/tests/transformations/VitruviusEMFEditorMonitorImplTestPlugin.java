package tools.vitruv.applications.pcmjava.tests.transformations;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryFactory;

import tools.vitruv.framework.change.description.EMFModelChange;
import tools.vitruv.framework.change.recording.AtomicEMFChangeRecorder;
import tools.vitruv.framework.tests.util.TestUtil;
import tools.vitruv.framework.util.bridges.EcoreResourceBridge;
import tools.vitruv.framework.util.datatypes.VURI;

public class VitruviusEMFEditorMonitorImplTestPlugin {

    private static final Logger logger = Logger
            .getLogger(VitruviusEMFEditorMonitorImplTestPlugin.class.getSimpleName());

    // private DefaultEditorPartAdapterFactoryImpl factory;
    int detectedChanges = 0;

    @Before
    public void setUp() throws Exception {
        TestUtil.initializeLogger();
    }

    @Test
    public void testChangeDescription2Change() throws Throwable {
        final AtomicEMFChangeRecorder changeRecorder = new AtomicEMFChangeRecorder();
        final ResourceSet rs = new ResourceSetImpl();
        final VURI vuri = VURI.getInstance(TestUtil.PROJECT_URI + "/modelTest/repo.repository");
        final Resource resource = rs.createResource(vuri.getEMFUri());
        final Repository repo = RepositoryFactory.eINSTANCE.createRepository();
        repo.setEntityName("name");
        EcoreResourceBridge.saveEObjectAsOnlyContent(repo, resource);
        changeRecorder.beginRecording(VURI.getInstance(resource), Collections.singletonList(resource));
        repo.setEntityName("TestNewName");
        final List<EMFModelChange> changes = changeRecorder.endRecording();
        for (EMFModelChange change : changes) {
        	change.prepare();
        	logger.warn(change);
        }
        assertTrue("No changes detected ", 0 < changes.size());
    }
}
