package mir.routines.pcm2java;

import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.reference.RemoveEReference;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;

@SuppressWarnings("all")
public class DeletedComponentEffect extends AbstractEffectRealization {
  public DeletedComponentEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final RemoveEReference<Repository, RepositoryComponent> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private RemoveEReference<Repository, RepositoryComponent> change;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine DeletedComponentEffect with input:");
    getLogger().debug("   RemoveEReference: " + this.change);
    
    
    preprocessElementStates();
    new mir.routines.pcm2java.DeletedComponentEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
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
    
    private void executeUserOperations(final RemoveEReference<Repository, RepositoryComponent> change) {
      RepositoryComponent _oldValue = change.getOldValue();
      RepositoryComponent _oldValue_1 = change.getOldValue();
      String _entityName = _oldValue_1.getEntityName();
      this.effectFacade.callDeleteJavaPackage(_oldValue, _entityName, "");
      RepositoryComponent _oldValue_2 = change.getOldValue();
      this.effectFacade.callDeleteJavaClassifier(_oldValue_2);
    }
  }
}
