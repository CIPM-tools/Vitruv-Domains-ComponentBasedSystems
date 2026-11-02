package tools.vitruv.framework.views;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import org.junit.jupiter.api.Test;

import tools.vitruv.framework.views.changederivation.ChangeDerivingTimingListener;

/**
 * Tests {@link CommittableView}'s default {@code setTimingListener(listener)} method - the
 * fallback for implementers (other than
 * {@link tools.vitruv.framework.views.impl.ChangeDerivingView}) that have no notion of timing to
 * report. Documents the current, intentional behavior: such an implementer silently ignores the
 * call rather than erroring, so any {@code CommittableView} can safely have a listener attached
 * without first checking what kind of view it actually is.
 */
class ViewDefaultTimingDelegationTest {

	@Test
	void defaultMethod_doesNothing_andNeverTouchesTheListener() {
		CommittableView view = mock(CommittableView.class, CALLS_REAL_METHODS);
		ChangeDerivingTimingListener timingListener = mock(ChangeDerivingTimingListener.class);

		view.setTimingListener(timingListener);

		verifyNoInteractions(timingListener);
	}
}
