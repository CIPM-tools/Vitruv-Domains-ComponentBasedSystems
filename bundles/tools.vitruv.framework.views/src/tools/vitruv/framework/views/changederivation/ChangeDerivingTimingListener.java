package tools.vitruv.framework.views.changederivation;

/**
 * A listener that can be notified of how long specific parts of the change-deriving process
 * took. This framework does not know or care who implements this interface or what it does
 * with the measurements - it is a generic extension point, not something tied to any specific
 * consumer, so that consumers (e.g. a project that wants to collect performance measurements)
 * can observe timing without this framework needing a dependency back on that consumer.
 *
 * @see tools.vitruv.framework.views.View#withChangeDerivingTrait(StateBasedChangeResolutionStrategy,
 *      ChangeDerivingTimingListener)
 */
public interface ChangeDerivingTimingListener {

    /**
     * Called once a measured part of the change-deriving process has finished.
     *
     * @param label a fixed name identifying which part of the process was measured.
     * @param durationNanos how long that part took, in nanoseconds.
     */
    void onMeasurement(String label, long durationNanos);
}
