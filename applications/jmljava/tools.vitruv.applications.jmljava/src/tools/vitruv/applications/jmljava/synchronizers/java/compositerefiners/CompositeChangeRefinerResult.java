package tools.vitruv.applications.jmljava.synchronizers.java.compositerefiners;

import java.util.List;

import tools.vitruv.applications.jmljava.synchronizers.SynchronisationAbortedListener;
import tools.vitruv.applications.jmljava.synchronizers.CSSynchronizer;
import tools.vitruv.framework.correspondence.CorrespondenceModel;
import tools.vitruv.framework.userinteraction.UserInteracting;
import tools.vitruv.framework.util.command.VitruviusRecordingCommand;

/**
 * Base interface for all possible composite change refiner results. The only requirement is a
 * method, which can be used to apply the result.
 *
 * @author Stephan Seifermann
 *
 */
public interface CompositeChangeRefinerResult {

    /**
     * Applies the result to the models. Not all parameters might be used for this.
     *
     * @param transformationExecuting
     *            An EMF transformation executing.
     * @param blackboard
     *            The matching correspondence instance. This depends on the processed composite
     *            change.
     * @param ui
     *            A user interacting.
     * @param abortListener
     *            A listener for aborted synchronisations.
     * @return The result of the application process.
     */
    public List<VitruviusRecordingCommand> apply(CSSynchronizer transformationExecuting, CorrespondenceModel correspondenceModel, UserInteracting ui,
            SynchronisationAbortedListener abortListener);

}
