package mir.routines.ejbjava2pcm;

import tools.vitruv.applications.pcmjava.ejbtransformations.java2pcm.EJBJava2PcmHelper;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.correspondence.Correspondence;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;
import tools.vitruv.framework.correspondence.CorrespondenceModelUtil;
import java.io.IOException;
import java.util.Set;
import mir.routines.ejbjava2pcm.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.Method;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.OperationSignature;

@SuppressWarnings("all")
public class CreateClassMethodInEJBClassEffect extends AbstractEffectRealization {
  public CreateClassMethodInEJBClassEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final InsertEReference<org.emftext.language.java.classifiers.Class, Member> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private InsertEReference<org.emftext.language.java.classifiers.Class, Member> change;
  
  private EObject getCorrepondenceSourceBasicComponent(final InsertEReference<org.emftext.language.java.classifiers.Class, Member> change) {
    org.emftext.language.java.classifiers.Class _affectedEObject = change.getAffectedEObject();
    return _affectedEObject;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine CreateClassMethodInEJBClassEffect with input:");
    getLogger().debug("   InsertEReference: " + this.change);
    
    BasicComponent basicComponent = getCorrespondingElement(
    	getCorrepondenceSourceBasicComponent(change), // correspondence source supplier
    	BasicComponent.class,
    	(BasicComponent _element) -> true, // correspondence precondition checker
    	null);
    if (basicComponent == null) {
    	return;
    }
    initializeRetrieveElementState(basicComponent);
    
    preprocessElementStates();
    new mir.routines.ejbjava2pcm.CreateClassMethodInEJBClassEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, basicComponent);
    postprocessElementStates();
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.ejbjava2pcm.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final InsertEReference<org.emftext.language.java.classifiers.Class, Member> change, final BasicComponent basicComponent) {
      Member _newValue = change.getNewValue();
      org.emftext.language.java.classifiers.Class _affectedEObject = change.getAffectedEObject();
      final Method method = EJBJava2PcmHelper.getOoverridenInterfaceMethod(((ClassMethod) _newValue), ((org.emftext.language.java.classifiers.Class) _affectedEObject));
      final Set<OperationSignature> correspondingEObjects = CorrespondenceModelUtil.<OperationSignature, Correspondence>getCorrespondingEObjectsByType(this.correspondenceModel, method, OperationSignature.class);
      OperationSignature opSignature = null;
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(correspondingEObjects);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        OperationSignature _get = ((OperationSignature[])Conversions.unwrapArray(correspondingEObjects, OperationSignature.class))[0];
        opSignature = _get;
      }
      Member _newValue_1 = change.getNewValue();
      this.effectFacade.callCreateSEFFForClassMethod(basicComponent, opSignature, ((ClassMethod) _newValue_1));
    }
  }
}
