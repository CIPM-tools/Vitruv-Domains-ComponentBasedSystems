package mir.routines.ejbjava2pcm;

import tools.vitruv.applications.pcmjava.ejbtransformations.java2pcm.EJBJava2PcmHelper;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference;

import java.io.IOException;
import mir.routines.ejbjava2pcm.RoutinesFacade;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.commons.NamedElement;
import org.emftext.language.java.modifiers.AnnotationInstanceOrModifier;
import org.palladiosimulator.pcm.repository.Repository;

@SuppressWarnings("all")
public class CreateInterfaceAnnotationEffect extends AbstractEffectRealization {
  public CreateInterfaceAnnotationEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final InsertEReference<Interface, AnnotationInstanceOrModifier> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private InsertEReference<Interface, AnnotationInstanceOrModifier> change;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine CreateInterfaceAnnotationEffect with input:");
    getLogger().debug("   InsertEReference: " + this.change);
    
    
    preprocessElementStates();
    new mir.routines.ejbjava2pcm.CreateInterfaceAnnotationEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change);
    postprocessElementStates();
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.ejbjava2pcm.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final InsertEReference<Interface, AnnotationInstanceOrModifier> change) {
      final Repository repo = EJBJava2PcmHelper.findRepository(this.correspondenceModel);
      Interface _affectedEObject = change.getAffectedEObject();
      this.effectFacade.callCreateOperationInterface(repo, ((NamedElement) _affectedEObject));
    }
  }
}
