package edu.kit.ipd.sdq.seifermann.thesis.monitorededitor.java.changeresponder;

import java.util.ArrayList;
import java.util.Collection;

import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.ChangeEventExtendedVisitor;
import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.ChangeSubmitter;
import edu.kit.ipd.sdq.vitruvius.framework.model.monitor.events.ChangeClassifyingEventExtension;

/**
 * Base class for change event visitors used as extension to the monitored
 * editor. This class supports only exactly one type of change event.
 * 
 * @param <T>
 *            The type of the processed change classifying event.
 */
public abstract class VisitorBase<T extends ChangeClassifyingEventExtension>
		implements ChangeEventExtendedVisitor {

	@SuppressWarnings("unchecked")
	@Override
	public void visit(ChangeClassifyingEventExtension changeClassifyingEvent,
			ChangeSubmitter submitter) {
		visitInternal((T) changeClassifyingEvent, submitter);
	}

	@Override
	public Collection<Class<? extends ChangeClassifyingEventExtension>> getTreatedClasses() {
		Collection<Class<? extends ChangeClassifyingEventExtension>> classes = new ArrayList<Class<? extends ChangeClassifyingEventExtension>>();
		classes.add(getTreatedClassInternal());
		return classes;
	}

	/**
	 * @return The supported event class.
	 */
	protected abstract Class<T> getTreatedClassInternal();

	/**
	 * Processes the given change event.
	 * 
	 * @param changeClassifyingEvent
	 *            The change classifying event.
	 * @param submitter
	 *            The change submitter.
	 */
	protected abstract void visitInternal(T changeClassifyingEvent,
			ChangeSubmitter submitter);

}
