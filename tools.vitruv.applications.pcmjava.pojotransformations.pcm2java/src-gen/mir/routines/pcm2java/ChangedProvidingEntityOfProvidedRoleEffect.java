package mir.routines.pcm2java;

import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.reference.ReplaceSingleValuedEReference;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;

@SuppressWarnings("all")
public class ChangedProvidingEntityOfProvidedRoleEffect extends AbstractEffectRealization {
  public ChangedProvidingEntityOfProvidedRoleEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final ReplaceSingleValuedEReference<OperationProvidedRole, InterfaceProvidingEntity> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private ReplaceSingleValuedEReference<OperationProvidedRole, InterfaceProvidingEntity> change;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine ChangedProvidingEntityOfProvidedRoleEffect with input:");
    getLogger().debug("   ReplaceSingleValuedEReference: " + this.change);
    
    
    preprocessElementStates();
    new mir.routines.pcm2java.ChangedProvidingEntityOfProvidedRoleEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change);
    postprocessElementStates();
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final ReplaceSingleValuedEReference<OperationProvidedRole, InterfaceProvidingEntity> change) {
      OperationProvidedRole _affectedEObject = change.getAffectedEObject();
      final OperationProvidedRole operationProvidedRole = ((OperationProvidedRole) _affectedEObject);
      this.effectFacade.callAddProvidedRole(operationProvidedRole);
    }
  }
}
