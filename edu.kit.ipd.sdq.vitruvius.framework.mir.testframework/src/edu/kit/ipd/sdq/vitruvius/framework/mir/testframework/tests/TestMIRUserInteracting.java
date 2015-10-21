package edu.kit.ipd.sdq.vitruvius.framework.mir.testframework.tests;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.emf.common.util.URI;

import edu.kit.ipd.sdq.vitruvius.framework.mir.executor.interfaces.MIRUserInteracting;

import static org.junit.Assert.*;

public class TestMIRUserInteracting implements MIRUserInteracting {
	
	private Queue<Object> inputQueue = new LinkedList<Object>();

	public void pushUserInput(Object input) {
		inputQueue.add(input);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T takeInputOfType(Class<T> type) {
		Object next = inputQueue.poll();
		if (next == null) {
			fail("No input found for user interaction.");
			return null;
		}
		
		if (!(type.isInstance(next))) {
			fail("User input of type " + type.getName() + " expected, but found " + next.getClass().getName());
			return null;
		}
		
		return (T) next;
	}
	
	@Override
	public URI askForNewResource(String message) {
		return(takeInputOfType(URI.class));
	}

	public void assertEmpty() {
		assertTrue("Input Queue must be empty", inputQueue.isEmpty());
	}
}
