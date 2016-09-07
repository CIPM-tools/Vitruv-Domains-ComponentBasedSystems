package tools.vitruv.applications.jmljava.helper.java.shadowcopy;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import tools.vitruv.applications.jmljava.vitruvius.changesynchronizer.extensions.ModelURIProvider;
import tools.vitruv.framework.correspondence.CorrespondenceModel;

/**
 * Implementation of the ShadowCopyFactory.
 * 
 * @author Stephan Seifermann
 */
public class ShadowCopyFactoryImpl implements ShadowCopyFactory {

    private final ModelURIProvider javaModelUriProvider;
    
    /**
     * Constructor.
     * @param javaModelUriProvider The model uri provider instance for Java models.
     */
    @Inject
    ShadowCopyFactoryImpl(@Named("JavaModelUriProvider") ModelURIProvider javaModelUriProvider) {
        this.javaModelUriProvider = javaModelUriProvider;
    }
    
    @Override
    public ShadowCopy create(CorrespondenceModel ci, boolean useJMLCopy) {
        return new ShadowCopyImpl(ci, javaModelUriProvider, useJMLCopy);
    }

    @Override
    public ShadowCopy create(CorrespondenceModel ci) {
        return new ShadowCopyImpl(ci, javaModelUriProvider);
    }

}
