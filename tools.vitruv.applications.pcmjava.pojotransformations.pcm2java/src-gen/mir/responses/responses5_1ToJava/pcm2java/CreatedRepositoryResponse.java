package mir.responses.responses5_1ToJava.pcm2java;

import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.root.InsertRootEObject;
import tools.vitruv.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.repository.Repository;

@SuppressWarnings("all")
class CreatedRepositoryResponse extends AbstractResponseRealization {
  public CreatedRepositoryResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return InsertRootEObject.class;
  }
  
  private boolean checkChangeProperties(final InsertRootEObject<Repository> change) {
    EObject changedElement = change.getNewValue();
    // Check model element type
    if (!(changedElement instanceof Repository)) {
    	return false;
    }
    
    return true;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (!(change instanceof InsertRootEObject<?>)) {
    	return false;
    }
    InsertRootEObject typedChange = (InsertRootEObject)change;
    if (!checkChangeProperties(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    InsertRootEObject<Repository> typedChange = (InsertRootEObject<Repository>)change;
    mir.routines.pcm2java.CreatedRepositoryEffect effect = new mir.routines.pcm2java.CreatedRepositoryEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
