package mir.routines.pcm2java;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.parameters.OrdinaryParameter;
import org.palladiosimulator.pcm.repository.Parameter;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.attribute.ReplaceSingleValuedEAttribute;

@SuppressWarnings("all")
public class RenamedParameterEffect extends AbstractEffectRealization {
  public RenamedParameterEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final ReplaceSingleValuedEAttribute<Parameter, String> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private ReplaceSingleValuedEAttribute<Parameter, String> change;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine RenamedParameterEffect with input:");
    getLogger().debug("   ReplaceSingleValuedEAttribute: " + this.change);
    
    OrdinaryParameter javaParameter = getCorrespondingElement(
    	getCorrepondenceSourceJavaParameter(change), // correspondence source supplier
    	OrdinaryParameter.class,
    	(OrdinaryParameter _element) -> true, // correspondence precondition checker
    	null);
    if (javaParameter == null) {
    	return;
    }
    initializeRetrieveElementState(javaParameter);
    
    preprocessElementStates();
    new mir.routines.pcm2java.RenamedParameterEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, javaParameter);
    postprocessElementStates();
  }
  
  private EObject getCorrepondenceSourceJavaParameter(final ReplaceSingleValuedEAttribute<Parameter, String> change) {
    Parameter _affectedEObject = change.getAffectedEObject();
    return _affectedEObject;
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final ReplaceSingleValuedEAttribute<Parameter, String> change, final OrdinaryParameter javaParameter) {
      String _newValue = change.getNewValue();
      javaParameter.setName(_newValue);
    }
  }
}
