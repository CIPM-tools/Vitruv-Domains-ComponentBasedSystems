package mir.reactions.reactionsUmlToUml.class2comp;

import tools.vitruv.domains.uml.UmlDomainProvider;
import tools.vitruv.extensions.dslsruntime.reactions.AbstractReactionsExecutor;
import tools.vitruv.framework.userinteraction.UserInteracting;

@SuppressWarnings("all")
public class ExecutorUmlToUml extends AbstractReactionsExecutor {
  public ExecutorUmlToUml(final UserInteracting userInteracting) {
    super(userInteracting,
    	new UmlDomainProvider().getDomain(), 
    	new UmlDomainProvider().getDomain());
  }
  
  protected void setup() {
    tools.vitruv.framework.userinteraction.UserInteracting userInteracting = getUserInteracting();
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.CreatedClassModelReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.CreatedClassModelReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.RenamedClassModelReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.RenamedClassModelReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.RenamedElementReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.RenamedElementReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.CreatedUmlClassReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.CreatedUmlClassReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.RenameClassReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.RenameClassReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.DeletedClassReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.DeletedClassReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.CreatedPrimitiveDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.CreatedPrimitiveDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.CreatedDataTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.CreatedDataTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.DataTypeClassAttributeCreatedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.DataTypeClassAttributeCreatedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.DataTypeClassAttributeRenamedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.DataTypeClassAttributeRenamedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.DataTypeClassAttributeDeletedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.DataTypeClassAttributeDeletedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.ChangedAttributeTypeReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.ChangedAttributeTypeReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.CreatePackageReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.CreatePackageReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.MoveClassToDifferentPackageReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.MoveClassToDifferentPackageReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.PackageRenamedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.PackageRenamedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.PackageDeletedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.PackageDeletedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.ElementVisibilityChangedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.ElementVisibilityChangedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.CreatedInterfaceReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.CreatedInterfaceReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.InterfaceRealizedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.InterfaceRealizedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.InterfaceDeletedReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.InterfaceDeletedReaction(userInteracting));
    this.addReaction(mir.reactions.reactionsUmlToUml.class2comp.AddedUsesRelationshipReaction.getExpectedChangeType(), new mir.reactions.reactionsUmlToUml.class2comp.AddedUsesRelationshipReaction(userInteracting));
  }
}
