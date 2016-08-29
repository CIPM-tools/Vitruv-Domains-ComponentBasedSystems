package mir.responses.responsesAllElementTypesToAllElementTypes.simpleChangesTests;

import allElementTypes.NonRoot;
import allElementTypes.NonRootObjectContainerHelper;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.AbstractResponseRealization;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.EChange;
import edu.kit.ipd.sdq.vitruvius.framework.changes.echange.feature.reference.InsertEReference;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
class HelperResponseForNonRootObjectContainerContentsInitializationResponse extends AbstractResponseRealization {
  public HelperResponseForNonRootObjectContainerContentsInitializationResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return InsertEReference.class;
  }
  
  private boolean checkChangeProperties(final InsertEReference<NonRootObjectContainerHelper, NonRoot> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof NonRootObjectContainerHelper)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("nonRootObjectsContainment")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof InsertEReference<?, ?>)) {
    	return false;
    }
    InsertEReference typedChange = (InsertEReference)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    InsertEReference<NonRootObjectContainerHelper, NonRoot> typedChange = (InsertEReference<NonRootObjectContainerHelper, NonRoot>)change;
    mir.routines.simpleChangesTests.HelperResponseForNonRootObjectContainerContentsInitializationEffect effect = new mir.routines.simpleChangesTests.HelperResponseForNonRootObjectContainerContentsInitializationEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
