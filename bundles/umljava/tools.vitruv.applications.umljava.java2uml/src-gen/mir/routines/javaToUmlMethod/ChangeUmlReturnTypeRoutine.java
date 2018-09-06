package mir.routines.javaToUmlMethod;

import java.io.IOException;
import mir.routines.javaToUmlMethod.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLPackage;
import org.emftext.language.java.members.Method;
import org.emftext.language.java.types.TypeReference;
import tools.vitruv.applications.umljava.util.UmlJavaTypePropagationHelper;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractRepairRoutineRealization;
import tools.vitruv.extensions.dslsruntime.reactions.ReactionExecutionState;
import tools.vitruv.extensions.dslsruntime.reactions.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class ChangeUmlReturnTypeRoutine extends AbstractRepairRoutineRealization {
  private ChangeUmlReturnTypeRoutine.ActionUserExecution userExecution;
  
  private static class ActionUserExecution extends AbstractRepairRoutineRealization.UserExecution {
    public ActionUserExecution(final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy) {
      super(reactionExecutionState);
    }
    
    public EObject getCorrepondenceSourceUModel(final Method jMeth, final TypeReference jType, final Operation uOperation) {
      return UMLPackage.Literals.MODEL;
    }
    
    public EObject getElement1(final Method jMeth, final TypeReference jType, final Operation uOperation, final Model uModel) {
      return uOperation;
    }
    
    public void update0Element(final Method jMeth, final TypeReference jType, final Operation uOperation, final Model uModel) {
      Parameter uParam = uOperation.getReturnResult();
      if ((uParam == null)) {
        uParam = uOperation.createOwnedParameter("returnParameter", null);
        uParam.setDirection(ParameterDirectionKind.RETURN_LITERAL);
      }
      UmlJavaTypePropagationHelper.propagateTypeChangeToTypedMultiplicityElement(uParam, uParam, jMeth, this.correspondenceModel);
    }
    
    public EObject getCorrepondenceSourceUOperation(final Method jMeth, final TypeReference jType) {
      return jMeth;
    }
  }
  
  public ChangeUmlReturnTypeRoutine(final RoutinesFacade routinesFacade, final ReactionExecutionState reactionExecutionState, final CallHierarchyHaving calledBy, final Method jMeth, final TypeReference jType) {
    super(routinesFacade, reactionExecutionState, calledBy);
    this.userExecution = new mir.routines.javaToUmlMethod.ChangeUmlReturnTypeRoutine.ActionUserExecution(getExecutionState(), this);
    this.jMeth = jMeth;this.jType = jType;
  }
  
  private Method jMeth;
  
  private TypeReference jType;
  
  protected boolean executeRoutine() throws IOException {
    getLogger().debug("Called routine ChangeUmlReturnTypeRoutine with input:");
    getLogger().debug("   jMeth: " + this.jMeth);
    getLogger().debug("   jType: " + this.jType);
    
    org.eclipse.uml2.uml.Operation uOperation = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceUOperation(jMeth, jType), // correspondence source supplier
    	org.eclipse.uml2.uml.Operation.class,
    	(org.eclipse.uml2.uml.Operation _element) -> true, // correspondence precondition checker
    	null, 
    	false // asserted
    	);
    if (uOperation == null) {
    	return false;
    }
    registerObjectUnderModification(uOperation);
    org.eclipse.uml2.uml.Model uModel = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceUModel(jMeth, jType, uOperation), // correspondence source supplier
    	org.eclipse.uml2.uml.Model.class,
    	(org.eclipse.uml2.uml.Model _element) -> true, // correspondence precondition checker
    	null, 
    	false // asserted
    	);
    if (uModel == null) {
    	return false;
    }
    registerObjectUnderModification(uModel);
    // val updatedElement userExecution.getElement1(jMeth, jType, uOperation, uModel);
    userExecution.update0Element(jMeth, jType, uOperation, uModel);
    
    postprocessElements();
    
    return true;
  }
}
