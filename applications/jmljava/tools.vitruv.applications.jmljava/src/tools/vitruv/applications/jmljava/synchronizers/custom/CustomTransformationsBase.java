package tools.vitruv.applications.jmljava.synchronizers.custom;

import tools.vitruv.framework.correspondence.CorrespondenceModel;
import tools.vitruv.framework.util.command.TransformationResult;
import tools.vitruv.framework.userinteraction.UserInteracting;
import tools.vitruv.applications.jmljava.helper.java.shadowcopy.ShadowCopyFactory;
import tools.vitruv.applications.jmljava.synchronizers.CustomTransformation;
import tools.vitruv.applications.jmljava.synchronizers.SynchronisationAbortedListener;

/**
 * Base class for custom transformations, which are not inherited from
 * {@link EObjectMappingTransformation}. It performs the necessary VURI operations.
 *
 * @author Stephan Seifermann
 *
 */
public abstract class CustomTransformationsBase implements CustomTransformation {

    protected final ShadowCopyFactory shadowCopyFactory;
    protected SynchronisationAbortedListener abortListener;

    /**
     * Constructor.
     *
     * @param shadowCopyFactory
     *            A shadow copy factory.
     */
    protected CustomTransformationsBase(final ShadowCopyFactory shadowCopyFactory) {
        this.shadowCopyFactory = shadowCopyFactory;
    }

    @Override
    public TransformationResult execute(final CorrespondenceModel correspondenceModel, final UserInteracting userInteracting,
            final SynchronisationAbortedListener abortListener) {
        this.abortListener = abortListener;
        return this.executeInternal(correspondenceModel, userInteracting);
    }

    /**
     * Executes the transformation.
     *
     * @param ci
     *            The matching correspondence instance.
     * @param userInteracting
     *            A user interacting.
     * @return The transformationresult
     */
    protected abstract TransformationResult executeInternal(CorrespondenceModel correspondenceModel, UserInteracting userInteracting);
}
