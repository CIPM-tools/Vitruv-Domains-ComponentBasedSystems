package mir.responses.responses5_1ToJava.pcm2java;

import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.attribute.ReplaceSingleValuedEAttribute;
import tools.vitruv.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.seff.ResourceDemandingInternalBehaviour;

@SuppressWarnings("all")
class RenameResourceDemandingInternalBehaviorResponse extends AbstractResponseRealization {
  public RenameResourceDemandingInternalBehaviorResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return ReplaceSingleValuedEAttribute.class;
  }
  
  private boolean checkChangeProperties(final ReplaceSingleValuedEAttribute<ResourceDemandingInternalBehaviour, String> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof ResourceDemandingInternalBehaviour)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("entityName")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof ReplaceSingleValuedEAttribute<?, ?>)) {
    	return false;
    }
    ReplaceSingleValuedEAttribute typedChange = (ReplaceSingleValuedEAttribute)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    ReplaceSingleValuedEAttribute<ResourceDemandingInternalBehaviour, String> typedChange = (ReplaceSingleValuedEAttribute<ResourceDemandingInternalBehaviour, String>)change;
    mir.routines.pcm2java.RenameResourceDemandingInternalBehaviorEffect effect = new mir.routines.pcm2java.RenameResourceDemandingInternalBehaviorEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
