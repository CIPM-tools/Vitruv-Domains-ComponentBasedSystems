package tools.vitruv.framework.views;

import java.util.List;

import tools.vitruv.change.composite.description.PropagatedChange;
import tools.vitruv.framework.views.changederivation.ChangeDerivingTimingListener;

/**
 * A {@link View} that allows to commit its changes back to the underlying {@link ChangeableViewSource}.
 */
public interface CommittableView extends View {
	/**
	 * Registers a listener to be notified of how long specific parts of this view's commit
	 * process take. The listener is a generic extension point - this framework has no
	 * dependency on whoever implements it. Default implementation ignores the listener, for
	 * implementers that have no notion of timing to report;
	 * {@link tools.vitruv.framework.views.impl.ChangeDerivingView} does.
	 *
	 * @param timingListener may be <code>null</code>, in which case no measurements are reported.
	 */
	default void setTimingListener(ChangeDerivingTimingListener timingListener) {
		// no-op by default
	}

	/**
	 * Commits the changes made to the view and its containing elements to the
	 * underlying {@link ChangeableViewSource}. This explicitly includes all changes
	 * that have been made before calling this method. Whether changes will
	 * effectively be recorded depends on this view. It is permissible for a view
	 * not to record any changes if it deems them irrelevant.
	 * 
	 * To ensure that the view is not modified ({@link #isModified()}) afterwards
	 * because further changes may be performed to the underlying sources during
	 * commit, consider using {@link #commitChangesAndUpdate()} instead to perform
	 * an update of the view afterwards.
	 * 
	 * @return the changes resulting from propagating the recorded changes
	 * @throws IllegalStateException if called on a closed view
	 * @see #isClosed()
	 * @see #commitChangesAndUpdate()
	 */
	List<PropagatedChange> commitChanges();

	/**
	 * Convenience method for subsequent execution of {@link #commitChanges()} and
	 * {@link #update()}. Commits the changes made to the view and its containing
	 * elements to the underlying {@link ChangeableViewSource} and updates the view
	 * elements from the {@link ChangeableViewSource} afterwards to reflect
	 * potential further changes made during commit.
	 * 
	 * @return the changes resulting from propagating the recorded changes
	 * @throws IllegalStateException if called on a closed view
	 * @see #commitChanges()
	 * @see #update()
	 * @see #isClosed()
	 */
	default List<PropagatedChange> commitChangesAndUpdate() {
		List<PropagatedChange> changes = commitChanges();
		update();
		return changes;
	}
}
