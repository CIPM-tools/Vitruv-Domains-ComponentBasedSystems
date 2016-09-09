package mir.responses;

import tools.vitruv.framework.change.processing.impl.AbstractChange2CommandTransforming;
import tools.vitruv.framework.util.datatypes.VURI;

/**
 * The {@link interface tools.vitruv.framework.change.processing.Change2CommandTransforming} for transformations between the metamodels http://www.emftext.org/java and http://palladiosimulator.org/PalladioComponentModel/5.1.
 * To add further change processors overwrite the setup method.
 */
public abstract class AbstractChange2CommandTransformingJavaTo5_1 extends AbstractChange2CommandTransforming {
	public AbstractChange2CommandTransformingJavaTo5_1() {
		super (VURI.getInstance("http://www.emftext.org/java"),
			VURI.getInstance("http://palladiosimulator.org/PalladioComponentModel/5.1"));
	}
	
	/**
	 * Adds the response change processors to this {@link AbstractChange2CommandTransformingJavaTo5_1}.
	 * For adding further change processors overwrite this method and call the super method at the right place.
	 */
	protected void setup() {
		this.addChangeMainprocessor(new mir.responses.responsesJavaTo5_1.ejbjava2pcm.ExecutorJavaTo5_1(getUserInteracting()));
	}
	
}
