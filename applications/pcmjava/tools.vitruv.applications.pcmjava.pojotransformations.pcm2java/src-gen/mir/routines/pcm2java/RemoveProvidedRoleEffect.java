package mir.routines.pcm2java;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.imports.ClassifierImport;
import org.emftext.language.java.types.NamespaceClassifierReference;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class RemoveProvidedRoleEffect extends AbstractEffectRealization {
  public RemoveProvidedRoleEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final ProvidedRole providedRole) {
    super(responseExecutionState, calledBy);
    				this.providedRole = providedRole;
  }
  
  private ProvidedRole providedRole;
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
    }
  }
  
  private static class CallRoutinesUserExecution extends AbstractEffectRealization.UserExecution {
    public CallRoutinesUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    @Extension
    private RoutinesFacade effectFacade;
  }
  
  private EObject getElement0(final ProvidedRole providedRole, final ClassifierImport requiredInterfaceImport, final NamespaceClassifierReference namespaceClassifierReference) {
    return requiredInterfaceImport;
  }
  
  private EObject getCorrepondenceSourceRequiredInterfaceImport(final ProvidedRole providedRole) {
    return providedRole;
  }
  
  private EObject getElement1(final ProvidedRole providedRole, final ClassifierImport requiredInterfaceImport, final NamespaceClassifierReference namespaceClassifierReference) {
    return namespaceClassifierReference;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine RemoveProvidedRoleEffect with input:");
    getLogger().debug("   ProvidedRole: " + this.providedRole);
    
    ClassifierImport requiredInterfaceImport = getCorrespondingElement(
    	getCorrepondenceSourceRequiredInterfaceImport(providedRole), // correspondence source supplier
    	ClassifierImport.class,
    	(ClassifierImport _element) -> true, // correspondence precondition checker
    	null);
    if (requiredInterfaceImport == null) {
    	return;
    }
    initializeRetrieveElementState(requiredInterfaceImport);
    NamespaceClassifierReference namespaceClassifierReference = getCorrespondingElement(
    	getCorrepondenceSourceNamespaceClassifierReference(providedRole), // correspondence source supplier
    	NamespaceClassifierReference.class,
    	(NamespaceClassifierReference _element) -> true, // correspondence precondition checker
    	null);
    if (namespaceClassifierReference == null) {
    	return;
    }
    initializeRetrieveElementState(namespaceClassifierReference);
    deleteObject(getElement0(providedRole, requiredInterfaceImport, namespaceClassifierReference));
    deleteObject(getElement1(providedRole, requiredInterfaceImport, namespaceClassifierReference));
    
    preprocessElementStates();
    postprocessElementStates();
  }
  
  private EObject getCorrepondenceSourceNamespaceClassifierReference(final ProvidedRole providedRole) {
    return providedRole;
  }
}
