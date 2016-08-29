package mir.responses.responsesAllElementTypesToAllElementTypes.simpleChangesTests;

import allElementTypes.Root;
import com.google.common.base.Objects;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.AbstractResponseRealization;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.root.RemoveRootEObject;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
class HelperResponseForDeleteSecondTestModelResponse extends AbstractResponseRealization {
  public HelperResponseForDeleteSecondTestModelResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  private boolean checkTriggerPrecondition(final RemoveRootEObject<Root> change) {
    Root _oldValue = change.getOldValue();
    String _id = _oldValue.getId();
    boolean _equals = Objects.equal(_id, "EachTestModelSource");
    return _equals;
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return RemoveRootEObject.class;
  }
  
  private boolean checkChangeProperties(final RemoveRootEObject<Root> change) {
    EObject changedElement = change.getOldValue();
    // Check model element type
    if (!(changedElement instanceof Root)) {
    	return false;
    }
    
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof RemoveRootEObject<?>)) {
    	return false;
    }
    RemoveRootEObject typedChange = (RemoveRootEObject)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    if (!checkTriggerPrecondition(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    RemoveRootEObject<Root> typedChange = (RemoveRootEObject<Root>)change;
    mir.routines.simpleChangesTests.HelperResponseForDeleteSecondTestModelEffect effect = new mir.routines.simpleChangesTests.HelperResponseForDeleteSecondTestModelEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
