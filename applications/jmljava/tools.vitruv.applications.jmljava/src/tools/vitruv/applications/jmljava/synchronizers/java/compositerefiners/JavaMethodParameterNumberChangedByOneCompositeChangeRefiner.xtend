package tools.vitruv.applications.jmljava.synchronizers.java.compositerefiners

import tools.vitruv.applications.jmljava.helper.java.shadowcopy.ShadowCopyFactory
import tools.vitruv.framework.change.description.CompositeChange
import tools.vitruv.framework.util.datatypes.VURI
import tools.vitruv.framework.meta.change.feature.EFeatureChange
import org.emftext.language.java.members.Method
import org.emftext.language.java.parameters.Parameter
import tools.vitruv.framework.change.echange.feature.FeatureEChange
import tools.vitruv.framework.change.description.VitruviusChangeFactory
import tools.vitruv.domains.java.echange.feature.JavaFeatureEChange

class JavaMethodParameterNumberChangedByOneCompositeChangeRefiner extends CompositeChangeRefinerBase {
	
	new(ShadowCopyFactory shadowCopyFactory) {
		super(shadowCopyFactory)
	}
	
	override match(CompositeChange change) {
		var CompositeChangeRefinerBase.AddDeleteContainer addAndDeleteChanges = null
		try {
			addAndDeleteChanges = getAddAndDeleteChanges(change)
		} catch (IllegalArgumentException e) {
			return false
		}
		
		val deleteChanges = addAndDeleteChanges.deleteChanges
		val addChanges = addAndDeleteChanges.addChanges
		
		if (Math.abs(deleteChanges.size - addChanges.size) != 1) {
			return false
		}
		
		if (deleteChanges.exists[!(oldAffectedEObject instanceof Method) || !(oldValue instanceof Parameter)]) {
			return false
		}
		
		if (addChanges.exists[!(newAffectedEObject instanceof Method) || !(newValue instanceof Parameter)]) {
			return false
		}
		
		return true
	}
	
	override refine(CompositeChange change) {
		val CompositeChangeRefinerBase.AddDeleteContainer addAndDeleteChanges = getAddAndDeleteChanges(change)
		
		var JavaFeatureEChange<?,?> refinedChange = null
		if (addAndDeleteChanges.addChanges.size > addAndDeleteChanges.deleteChanges.size) {
			refinedChange = addAndDeleteChanges.addChanges.findFirst[addChange | !addAndDeleteChanges.deleteChanges.exists[(oldValue as Parameter).name.equals((addChange.newValue as Parameter).name)]]
		} else {
			refinedChange = addAndDeleteChanges.deleteChanges.findFirst[deleteChange | !addAndDeleteChanges.addChanges.exists[(newValue as Parameter).name.equals((deleteChange.oldValue as Parameter).name)]]
		}
		
		return new CompositeChangeRefinerResultAtomicTransformations(#[VitruviusChangeFactory.instance.createConcreteChange(refinedChange, VURI.getInstance(refinedChange.oldAffectedEObject.eResource))]);
	}
	
}