package mir.responses.responsesJavaTo5_1.ejbjava2pcm;

import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;
import tools.vitruv.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.types.TypeReference;

@SuppressWarnings("all")
class CreateImplementsResponse extends AbstractResponseRealization {
  public CreateImplementsResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return InsertEReference.class;
  }
  
  private boolean checkChangeProperties(final InsertEReference<org.emftext.language.java.classifiers.Class, TypeReference> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof org.emftext.language.java.classifiers.Class)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("implements")) {
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
    InsertEReference<org.emftext.language.java.classifiers.Class, TypeReference> typedChange = (InsertEReference<org.emftext.language.java.classifiers.Class, TypeReference>)change;
    mir.routines.ejbjava2pcm.CreateImplementsEffect effect = new mir.routines.ejbjava2pcm.CreateImplementsEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
