package tools.vitruv.framework.views.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tools.vitruv.framework.views.ChangeableViewSource;
import tools.vitruv.framework.views.ViewSelection;
import tools.vitruv.framework.views.ViewSelector;
import tools.vitruv.framework.views.changederivation.ChangeDerivingTimingListener;
import tools.vitruv.framework.views.changederivation.DefaultStateBasedChangeResolutionStrategy;

/**
 * Tests the timing hook added to {@link ChangeDerivingView#commitChanges()}, attached via
 * {@link ChangeDerivingView#setTimingListener(ChangeDerivingTimingListener)} rather than through
 * the constructor - the listener is never read until {@code commitChanges()} runs, so it can be
 * attached any time after the view already exists.
 * Uses plain Ecore objects (always available in any EMF runtime) rather than a dedicated test
 * metamodel - nothing here depends on what kind of model object is being tracked.
 */
class ChangeDerivingViewTimingTest {

	private ViewCreatingViewType<? extends ViewSelector> viewType;
	private ChangeableViewSource viewSource;
	private ViewSelection selection;
	private ChangeDerivingTimingListener timingListener;

	@SuppressWarnings("unchecked")
	@BeforeEach
	void setUp() {
		viewType = mock(ViewCreatingViewType.class);
		viewSource = mock(ChangeableViewSource.class);
		selection = mock(ViewSelection.class);
		timingListener = mock(ChangeDerivingTimingListener.class);
	}

	@Test
	void commitChanges_newlyRegisteredRoot_reportsBothChangeGenerationAndPropagation() throws Exception {
		BasicView basicView = new BasicView(viewType, viewSource, selection);
		try (ChangeDerivingView view = new ChangeDerivingView(basicView,
				new DefaultStateBasedChangeResolutionStrategy())) {
			view.setTimingListener(timingListener);
			// Registered after wrapping, so it is absent from the "original state" snapshot the
			// comparison runs against - a genuine insertion, not a no-op.
			EClass root = EcoreFactory.eINSTANCE.createEClass();
			view.registerRoot(root, URI.createURI("test://root.xmi"));

			view.commitChanges();

			verify(timingListener).onMeasurement(eq("changeGeneration"), anyLong());
			verify(timingListener).onMeasurement(eq("changeDerivingPropagation"), anyLong());
		}
	}

	@Test
	void commitChanges_resourceUnchangedSinceLastUpdate_onlyReportsChangeGeneration() throws Exception {
		// The constructor refuses an already-modified BasicView, so a root cannot be registered
		// before wrapping. Instead: register, do a first commit (a genuine creation - the
		// baseline is still "empty" at this point, only update() ever moves it forward), then
		// update() to make this state the new baseline, and only then commit again with no
		// further edits - that second commit is the actual "nothing changed" scenario.
		BasicView basicView = new BasicView(viewType, viewSource, selection);
		try (ChangeDerivingView view = new ChangeDerivingView(basicView,
				new DefaultStateBasedChangeResolutionStrategy())) {
			view.setTimingListener(timingListener);
			EClass root = EcoreFactory.eINSTANCE.createEClass();
			view.registerRoot(root, URI.createURI("test://root.xmi"));
			view.commitChanges();
			view.update();
			clearInvocations(timingListener);

			view.commitChanges();

			verify(timingListener).onMeasurement(eq("changeGeneration"), anyLong());
			verify(timingListener, never()).onMeasurement(eq("changeDerivingPropagation"), anyLong());
		}
	}

	@Test
	void commitChanges_withoutATimingListener_runsWithoutError() throws Exception {
		// setTimingListener() is never called here at all - this is what every caller that
		// predates this feature still does, and it must keep working exactly as before.
		BasicView basicView = new BasicView(viewType, viewSource, selection);
		try (ChangeDerivingView view = new ChangeDerivingView(basicView,
				new DefaultStateBasedChangeResolutionStrategy())) {
			EClass root = EcoreFactory.eINSTANCE.createEClass();
			view.registerRoot(root, URI.createURI("test://root.xmi"));

			assertDoesNotThrow(view::commitChanges);
		}
	}

	@Test
	void setTimingListener_calledOnTheResultOfWithChangeDerivingTrait_isHonoredByTheReturnedView() throws Exception {
		// withChangeDerivingTrait(strategy) itself takes no listener - setTimingListener is a
		// separate, later call on whatever CommittableView it returns, not a constructor concern.
		try (BasicView basicView = new BasicView(viewType, viewSource, selection)) {
			var result = basicView.withChangeDerivingTrait(new DefaultStateBasedChangeResolutionStrategy());
			assertInstanceOf(ChangeDerivingView.class, result);

			result.setTimingListener(timingListener);
			EClass root = EcoreFactory.eINSTANCE.createEClass();
			result.registerRoot(root, URI.createURI("test://root.xmi"));
			result.commitChanges();

			verify(timingListener).onMeasurement(eq("changeGeneration"), anyLong());
			result.close();
		}
	}
}
