package mir.responses.responsesJavaTo5_1.ejbjava2pcm;

import tools.vitruv.applications.pcmjava.ejbtransformations.java2pcm.EJBAnnotationHelper;
import tools.vitruv.extensions.dslsruntime.response.AbstractResponseRealization;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;
import tools.vitruv.framework.userinteraction.UserInteracting;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.java.classifiers.ConcreteClassifier;
import org.emftext.language.java.containers.CompilationUnit;

@SuppressWarnings("all")
class CreatedInterfaceResponse extends AbstractResponseRealization {
  public CreatedInterfaceResponse(final UserInteracting userInteracting) {
    super(userInteracting);
  }
  
  private boolean checkTriggerPrecondition(final InsertEReference<CompilationUnit, ConcreteClassifier> change) {
    ConcreteClassifier _newValue = change.getNewValue();
    boolean _isEJBBuisnessInterface = EJBAnnotationHelper.isEJBBuisnessInterface(_newValue);
    return _isEJBBuisnessInterface;
  }
  
  public static Class<? extends EChange> getExpectedChangeType() {
    return InsertEReference.class;
  }
  
  private boolean checkChangeProperties(final InsertEReference<CompilationUnit, ConcreteClassifier> change) {
    EObject changedElement = change.getAffectedEObject();
    // Check model element type
    if (!(changedElement instanceof CompilationUnit)) {
    	return false;
    }
    
    // Check feature
    if (!change.getAffectedFeature().getName().equals("classifiers")) {
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
    if (!checkTriggerPrecondition(typedChange)) {
    	return false;
    }
    getLogger().debug("Passed precondition check of response " + this.getClass().getName());
    return true;
  }
  
  public void executeResponse(final EChange change) {
    InsertEReference<CompilationUnit, ConcreteClassifier> typedChange = (InsertEReference<CompilationUnit, ConcreteClassifier>)change;
    mir.routines.ejbjava2pcm.CreatedInterfaceEffect effect = new mir.routines.ejbjava2pcm.CreatedInterfaceEffect(this.executionState, this, typedChange);
    effect.applyRoutine();
  }
}
