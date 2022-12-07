package tools.vitruv.framework.change.echange.command

import java.util.List
import org.eclipse.emf.common.command.Command
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.command.AddCommand
import org.eclipse.emf.edit.command.SetCommand
import tools.vitruv.framework.change.echange.command.RemoveAtCommand
import tools.vitruv.framework.change.echange.eobject.CreateEObject
import tools.vitruv.framework.change.echange.eobject.DeleteEObject
import tools.vitruv.framework.change.echange.feature.attribute.InsertEAttributeValue
import tools.vitruv.framework.change.echange.feature.attribute.RemoveEAttributeValue
import tools.vitruv.framework.change.echange.feature.attribute.ReplaceSingleValuedEAttribute
import tools.vitruv.framework.change.echange.feature.reference.InsertEReference
import tools.vitruv.framework.change.echange.feature.reference.RemoveEReference
import tools.vitruv.framework.change.echange.feature.reference.ReplaceSingleValuedEReference
import tools.vitruv.framework.change.echange.root.InsertRootEObject
import tools.vitruv.framework.change.echange.root.RemoveRootEObject
import org.eclipse.emf.edit.command.RemoveCommand
import org.apache.log4j.Logger
import tools.vitruv.framework.change.echange.EChange
import tools.vitruv.framework.change.echange.feature.UnsetFeature
import edu.kit.ipd.sdq.activextendannotations.Utility
import static extension tools.vitruv.framework.change.echange.command.ChangeCommandUtil.getEditingDomain
import static extension tools.vitruv.framework.change.echange.command.ChangeCommandUtil.alreadyContainsObject

/**
 * Switch to create commands for all EChange classes.
 * The commands applies the EChanges forward.
 */
@Utility
package class ApplyForwardCommandSwitch {
	static val Logger logger = Logger.getLogger(ApplyForwardCommandSwitch)
	
	def package dispatch static List<Command> getCommands(EChange change) {
		#[]
	}
	
	/**
	 * Dispatch method to create commands to apply a {@link UnsetFeature} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(UnsetFeature<EObject, ?> change) {
		val editingDomain = change.affectedEObject.editingDomain
		return #[new SetCommand(editingDomain, change.affectedEObject, change.affectedFeature, SetCommand.UNSET_VALUE)]
	}
	
	/**
	 * Dispatch method to create commands to apply a {@link InsertEAttributeValue} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(InsertEAttributeValue<EObject, Object> change) {
		val editingDomain = change.affectedEObject.editingDomain
		return #[new AddCommand(editingDomain, change.affectedEObject, change.affectedFeature, change.newValue,
				change.index)]
	}

	/**
	 * Dispatch method to create commands to apply a {@link RemoveEAttributeValue} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(RemoveEAttributeValue<EObject, Object> change) {
		val editingDomain = change.affectedEObject.editingDomain
		return #[new RemoveAtCommand(editingDomain, change.affectedEObject, change.affectedFeature, change.oldValue, change.index)]
	}

	/**
	 * Dispatch method to create commands to apply a {@link ReplaceSingleValuedEAttribute} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(ReplaceSingleValuedEAttribute<EObject, Object> change) {
		val editingDomain = change.affectedEObject.editingDomain
		return #[new SetCommand(editingDomain, change.affectedEObject, change.affectedFeature, if (change.isIsUnset) SetCommand.UNSET_VALUE else change.newValue)]
	}

	/**
	 * Dispatch method to create commands to apply a {@link InsertEReference} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(InsertEReference<EObject, EObject> change) {
		val editingDomain = change.affectedEObject.editingDomain
		if(change.affectedEObject.alreadyContainsObject(change.affectedFeature, change.newValue)) {
			if (change.affectedFeature.EOpposite === null) {
				logger.warn("Tried to add value " + change.newValue + ", but although there is no opposite feature it was already contained in " + change.affectedEObject);
			} 
			return #[];
		}
		return #[new AddCommand(editingDomain, change.affectedEObject, change.affectedFeature, change.newValue,
			change.index)];
	}
	
	/**
	 * Dispatch method to create commands to apply a {@link RemoveEReference} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(RemoveEReference<EObject, EObject> change) {
		val editingDomain = change.affectedEObject.editingDomain
		if(!change.affectedEObject.alreadyContainsObject(change.affectedFeature, change.oldValue)) {
			if (change.affectedFeature.EOpposite === null) {
				logger.warn("Tried to remove value " + change.oldValue + ", but although there is no opposite feature it was already contained in " + change.affectedEObject);
			} 
			return #[];
		}
		return #[new RemoveAtCommand(editingDomain, change.affectedEObject, change.affectedFeature, change.oldValue, change.index)]
	}

	/**
	 * Dispatch method to create commands to apply a {@link ReplaceSingleValuedEReference} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(ReplaceSingleValuedEReference<EObject, EObject> change) {
		val editingDomain = change.affectedEObject.editingDomain
		if(change.affectedEObject.alreadyContainsObject(change.affectedFeature, change.newValue)) {
			if (change.affectedFeature.EOpposite === null) {
				logger.warn("Tried to add value " + change.newValue + ", but although there is no opposite feature it was already contained in " + change.affectedEObject);
			} 
			return #[];
		}
		return #[new SetCommand(editingDomain, change.affectedEObject, change.affectedFeature, if (change.isIsUnset) SetCommand.UNSET_VALUE else change.newValue)]
	}

	/**
	 * Dispatch method to create commands to apply a {@link InsertRootEObject} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(InsertRootEObject<EObject> change) {
		val editingDomain = change.newValue.editingDomain
		// Will be automatically removed from resource because object can only be in one resource.	
		return #[new AddCommand(editingDomain, change.resource.getContents, change.newValue, change.index)]
	}

	/**
	 * Dispatch method to create commands to apply a {@link RemoveRootEObject} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(RemoveRootEObject<EObject> change) {
		val editingDomain = change.oldValue.editingDomain
		return #[new RemoveCommand(editingDomain, change.resource.getContents, change.oldValue)];
	}

	/**
	 * Dispatch method to create commands to apply a {@link CreateEObject} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(CreateEObject<EObject> change) {
		return #[]
	}

	/**
	 * Dispatch method to create commands to apply a {@link DeleteEObject} change forward.
	 * @param object The change which commands should be created.
	 */
	def package dispatch static List<Command> getCommands(DeleteEObject<EObject> change) {
		return #[]
	}

}