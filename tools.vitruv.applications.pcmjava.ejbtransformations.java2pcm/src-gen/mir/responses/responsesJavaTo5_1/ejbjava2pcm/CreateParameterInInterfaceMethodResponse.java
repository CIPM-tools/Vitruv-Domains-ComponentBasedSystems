package mir.responses.responsesJavaTo5_1.ejbjava2pcm;

import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;
import tools.vitruv.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.members.InterfaceMethod;
import org.emftext.language.java.parameters.Parameter;

@SuppressWarnings("all")
class CreateParameterInInterfaceMethodResponse extends AbstractResponseRealization {
  public CreateParameterInInterfaceMethodResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return InsertEReference.class;
  }
  
  private boolean checkChangeProperties(final InsertEReference<InterfaceMethod, Parameter> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof InterfaceMethod)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("parameters")) {
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
    InsertEReference<InterfaceMethod, Parameter> typedChange = (InsertEReference<InterfaceMethod, Parameter>)change;
    mir.routines.ejbjava2pcm.CreateParameterInInterfaceMethodEffect effect = new mir.routines.ejbjava2pcm.CreateParameterInInterfaceMethodEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
