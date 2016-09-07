package mir.responses.responses5_1ToJava.pcm2java;

import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.RemoveEReference;
import tools.vitruv.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationSignature;

@SuppressWarnings("all")
class DeletedOperationSignatureResponse extends AbstractResponseRealization {
  public DeletedOperationSignatureResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return RemoveEReference.class;
  }
  
  private boolean checkChangeProperties(final RemoveEReference<OperationInterface, OperationSignature> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof OperationInterface)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("signatures__OperationInterface")) {
    	return false;
    }
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof RemoveEReference<?, ?>)) {
    	return false;
    }
    RemoveEReference typedChange = (RemoveEReference)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    RemoveEReference<OperationInterface, OperationSignature> typedChange = (RemoveEReference<OperationInterface, OperationSignature>)change;
    mir.routines.pcm2java.DeletedOperationSignatureEffect effect = new mir.routines.pcm2java.DeletedOperationSignatureEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
