package mir.routines.simpleChangesTests;

import allElementTypes.NonRoot;
import allElementTypes.NonRootObjectContainerHelper;
import allElementTypes.Root;
import com.google.common.base.Objects;
import java.io.IOException;
import mir.routines.simpleChangesTests.RoutinesFacade;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import tools.vitruv.dsls.response.tests.simpleChangesTests.SimpleChangesTestsExecutionMonitor;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class InsertNonContainmentReferenceEffect extends AbstractEffectRealization {
  private RoutinesFacade effectFacade;
  
  private InsertNonContainmentReferenceEffect.EffectUserExecution userExecution;
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
    }
    
    public EObject getCorrepondenceSourceTargetElement(final Root root, final NonRoot insertedNonRoot) {
      return root;
    }
    
    public EObject getElement1(final Root root, final NonRoot insertedNonRoot, final Root targetElement) {
      return targetElement;
    }
    
    public void update0Element(final Root root, final NonRoot insertedNonRoot, final Root targetElement) {
      NonRootObjectContainerHelper _nonRootObjectContainerHelper = targetElement.getNonRootObjectContainerHelper();
      EList<NonRoot> _nonRootObjectsContainment = _nonRootObjectContainerHelper.getNonRootObjectsContainment();
      final Function1<NonRoot, Boolean> _function = (NonRoot it) -> {
        String _id = it.getId();
        String _id_1 = insertedNonRoot.getId();
        return Boolean.valueOf(Objects.equal(_id, _id_1));
      };
      final NonRoot addedNonRoot = IterableExtensions.<NonRoot>findFirst(_nonRootObjectsContainment, _function);
      EList<NonRoot> _multiValuedNonContainmentEReference = targetElement.getMultiValuedNonContainmentEReference();
      _multiValuedNonContainmentEReference.add(addedNonRoot);
    }
    
    public void callRoutine1(final Root root, final NonRoot insertedNonRoot, final Root targetElement, @Extension final RoutinesFacade _routinesFacade) {
      SimpleChangesTestsExecutionMonitor _instance = SimpleChangesTestsExecutionMonitor.getInstance();
      _instance.set(SimpleChangesTestsExecutionMonitor.ChangeType.InsertNonContainmentEReference);
    }
  }
  
  public InsertNonContainmentReferenceEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final Root root, final NonRoot insertedNonRoot) {
    super(responseExecutionState, calledBy);
    this.userExecution = new mir.routines.simpleChangesTests.InsertNonContainmentReferenceEffect.EffectUserExecution(getExecutionState(), this);
    this.effectFacade = new mir.routines.simpleChangesTests.RoutinesFacade(getExecutionState(), this);
    this.root = root;this.insertedNonRoot = insertedNonRoot;
  }
  
  private Root root;
  
  private NonRoot insertedNonRoot;
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine InsertNonContainmentReferenceEffect with input:");
    getLogger().debug("   Root: " + this.root);
    getLogger().debug("   NonRoot: " + this.insertedNonRoot);
    
    Root targetElement = getCorrespondingElement(
    	userExecution.getCorrepondenceSourceTargetElement(root, insertedNonRoot), // correspondence source supplier
    	Root.class,
    	(Root _element) -> true, // correspondence precondition checker
    	null);
    if (targetElement == null) {
    	return;
    }
    initializeRetrieveElementState(targetElement);
    // val updatedElement userExecution.getElement1(root, insertedNonRoot, targetElement);
    userExecution.update0Element(root, insertedNonRoot, targetElement);
    
    userExecution.callRoutine1(root, insertedNonRoot, targetElement, effectFacade);
    
    postprocessElementStates();
  }
}
