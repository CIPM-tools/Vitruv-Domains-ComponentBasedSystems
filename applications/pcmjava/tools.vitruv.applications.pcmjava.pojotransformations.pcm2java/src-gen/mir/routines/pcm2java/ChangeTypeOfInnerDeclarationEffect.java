package mir.routines.pcm2java;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.types.TypeReference;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.InnerDeclaration;
import tools.vitruv.applications.pcmjava.pojotransformations.pcm2java.Pcm2JavaHelper;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;
import tools.vitruv.framework.change.echange.feature.reference.ReplaceSingleValuedEReference;

@SuppressWarnings("all")
public class ChangeTypeOfInnerDeclarationEffect extends AbstractEffectRealization {
  public ChangeTypeOfInnerDeclarationEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final ReplaceSingleValuedEReference<InnerDeclaration, DataType> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private ReplaceSingleValuedEReference<InnerDeclaration, DataType> change;
  
  private EObject getCorrepondenceSourceNewJavaDataType(final ReplaceSingleValuedEReference<InnerDeclaration, DataType> change) {
    DataType _newValue = change.getNewValue();
    return _newValue;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine ChangeTypeOfInnerDeclarationEffect with input:");
    getLogger().debug("   ReplaceSingleValuedEReference: " + this.change);
    
    org.emftext.language.java.classifiers.Class newJavaDataType = getCorrespondingElement(
    	getCorrepondenceSourceNewJavaDataType(change), // correspondence source supplier
    	org.emftext.language.java.classifiers.Class.class,
    	(org.emftext.language.java.classifiers.Class _element) -> true, // correspondence precondition checker
    	null);
    initializeRetrieveElementState(newJavaDataType);
    
    preprocessElementStates();
    new mir.routines.pcm2java.ChangeTypeOfInnerDeclarationEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, newJavaDataType);
    postprocessElementStates();
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final ReplaceSingleValuedEReference<InnerDeclaration, DataType> change, final org.emftext.language.java.classifiers.Class newJavaDataType) {
      final InnerDeclaration innerDeclaration = change.getAffectedEObject();
      DataType _newValue = change.getNewValue();
      final TypeReference newDataTypeReference = Pcm2JavaHelper.createTypeReference(_newValue, newJavaDataType);
      this.effectFacade.callChangeInnerDeclarationType(innerDeclaration, newDataTypeReference);
    }
  }
}
