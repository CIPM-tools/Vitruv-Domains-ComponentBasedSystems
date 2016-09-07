package mir.routines.pcm2java;

import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.members.ClassMethod;
import org.emftext.language.java.members.Member;
import org.emftext.language.java.members.impl.MembersFactoryImpl;
import org.emftext.language.java.types.TypesFactory;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.seff.ResourceDemandingInternalBehaviour;

@SuppressWarnings("all")
public class CreatedResourceDemandingInternalBehaviorEffect extends AbstractEffectRealization {
  public CreatedResourceDemandingInternalBehaviorEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final InsertEReference<BasicComponent, ResourceDemandingInternalBehaviour> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private InsertEReference<BasicComponent, ResourceDemandingInternalBehaviour> change;
  
  private EObject getElement0(final InsertEReference<BasicComponent, ResourceDemandingInternalBehaviour> change, final org.emftext.language.java.classifiers.Class componentClass, final ClassMethod javaMethod) {
    return javaMethod;
  }
  
  private EObject getElement1(final InsertEReference<BasicComponent, ResourceDemandingInternalBehaviour> change, final org.emftext.language.java.classifiers.Class componentClass, final ClassMethod javaMethod) {
    ResourceDemandingInternalBehaviour _newValue = change.getNewValue();
    return _newValue;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine CreatedResourceDemandingInternalBehaviorEffect with input:");
    getLogger().debug("   InsertEReference: " + this.change);
    
    org.emftext.language.java.classifiers.Class componentClass = getCorrespondingElement(
    	getCorrepondenceSourceComponentClass(change), // correspondence source supplier
    	org.emftext.language.java.classifiers.Class.class,
    	(org.emftext.language.java.classifiers.Class _element) -> true, // correspondence precondition checker
    	null);
    if (componentClass == null) {
    	return;
    }
    initializeRetrieveElementState(componentClass);
    ClassMethod javaMethod = MembersFactoryImpl.eINSTANCE.createClassMethod();
    initializeCreateElementState(javaMethod);
    
    addCorrespondenceBetween(getElement0(change, componentClass, javaMethod), getElement1(change, componentClass, javaMethod), "");
    preprocessElementStates();
    new mir.routines.pcm2java.CreatedResourceDemandingInternalBehaviorEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, componentClass, javaMethod);
    postprocessElementStates();
  }
  
  private EObject getCorrepondenceSourceComponentClass(final InsertEReference<BasicComponent, ResourceDemandingInternalBehaviour> change) {
    BasicComponent _affectedEObject = change.getAffectedEObject();
    return _affectedEObject;
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final InsertEReference<BasicComponent, ResourceDemandingInternalBehaviour> change, final org.emftext.language.java.classifiers.Class componentClass, final ClassMethod javaMethod) {
      ResourceDemandingInternalBehaviour _newValue = change.getNewValue();
      String _entityName = _newValue.getEntityName();
      javaMethod.setName(_entityName);
      org.emftext.language.java.types.Void _createVoid = TypesFactory.eINSTANCE.createVoid();
      javaMethod.setTypeReference(_createVoid);
      EList<Member> _members = componentClass.getMembers();
      _members.add(javaMethod);
    }
  }
}
