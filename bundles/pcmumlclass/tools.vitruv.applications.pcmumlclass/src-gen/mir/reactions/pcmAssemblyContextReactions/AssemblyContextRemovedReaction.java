package mir.reactions.pcmAssemblyContextReactions;

import mir.routines.pcmAssemblyContextReactions.RoutinesFacade;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Extension;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionRealization;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.change.echange.feature.reference.RemoveEReference;

@SuppressWarnings("all")
public class AssemblyContextRemovedReaction extends AbstractReactionRealization {
  private RemoveEReference<ComposedProvidingRequiringEntity, AssemblyContext> removeChange;
  
  private int currentlyMatchedChange;
  
  public AssemblyContextRemovedReaction(final RoutinesFacade routinesFacade) {
    super(routinesFacade);
  }
  
  public void executeReaction(final EChange change) {
    if (!checkPrecondition(change)) {
    	return;
    }
    org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity affectedEObject = removeChange.getAffectedEObject();
    EReference affectedFeature = removeChange.getAffectedFeature();
    org.palladiosimulator.pcm.core.composition.AssemblyContext oldValue = removeChange.getOldValue();
    int index = removeChange.getIndex();
    				
    getLogger().trace("Passed change matching of Reaction " + this.getClass().getName());
    if (!checkUserDefinedPrecondition(removeChange, affectedEObject, affectedFeature, oldValue, index)) {
    	resetChanges();
    	return;
    }
    getLogger().trace("Passed complete precondition check of Reaction " + this.getClass().getName());
    				
    mir.reactions.pcmAssemblyContextReactions.AssemblyContextRemovedReaction.ActionUserExecution userExecution = new mir.reactions.pcmAssemblyContextReactions.AssemblyContextRemovedReaction.ActionUserExecution(this.executionState, this);
    userExecution.callRoutine1(removeChange, affectedEObject, affectedFeature, oldValue, index, this.getRoutinesFacade());
    
    resetChanges();
  }
  
  private void resetChanges() {
    removeChange = null;
    currentlyMatchedChange = 0;
  }
  
  private boolean matchRemoveChange(final EChange change) {
    if (change instanceof RemoveEReference<?, ?>) {
    	RemoveEReference<org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity, org.palladiosimulator.pcm.core.composition.AssemblyContext> _localTypedChange = (RemoveEReference<org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity, org.palladiosimulator.pcm.core.composition.AssemblyContext>) change;
    	if (!(_localTypedChange.getAffectedEObject() instanceof org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity)) {
    		return false;
    	}
    	if (!_localTypedChange.getAffectedFeature().getName().equals("assemblyContexts__ComposedStructure")) {
    		return false;
    	}
    	if (!(_localTypedChange.getOldValue() instanceof org.palladiosimulator.pcm.core.composition.AssemblyContext)) {
    		return false;
    	}
    	this.removeChange = (RemoveEReference<org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity, org.palladiosimulator.pcm.core.composition.AssemblyContext>) change;
    	return true;
    }
    
    return false;
  }
  
  public boolean checkPrecondition(final EChange change) {
    if (currentlyMatchedChange == 0) {
    	if (!matchRemoveChange(change)) {
    		resetChanges();
    		return false;
    	} else {
    		currentlyMatchedChange++;
    	}
    }
    
    return true;
  }
  
  private boolean checkUserDefinedPrecondition(final RemoveEReference removeChange, final ComposedProvidingRequiringEntity affectedEObject, final EReference affectedFeature, final AssemblyContext oldValue, final int index) {
    boolean _contains = affectedEObject.getAssemblyContexts__ComposedStructure().contains(oldValue);
    return (!_contains);
  }
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public void callRoutine1(final RemoveEReference removeChange, final ComposedProvidingRequiringEntity affectedEObject, final EReference affectedFeature, final AssemblyContext oldValue, final int index, @Extension final RoutinesFacade _routinesFacade) {
      _routinesFacade.removeCorrespondingAssemblyContextProperty(oldValue, affectedEObject);
    }
  }
}
