package tools.vitruv.dsls.commonalities.language.extensions

import edu.kit.ipd.sdq.activextendannotations.Utility
import tools.vitruv.dsls.commonalities.language.AttributeMappingOperand
import tools.vitruv.dsls.commonalities.language.OperatorAttributeMapping

import static extension tools.vitruv.dsls.commonalities.language.extensions.CommonalitiesLanguageElementExtension.*

@Utility
package class AttributeMappingOperandExtension {

	def static boolean isInAttributeMappingContext(AttributeMappingOperand operand) {
		return (operand.attributeMapping !== null)
	}

	// Returns null if not in attribute mapping context:
	def static OperatorAttributeMapping getAttributeMapping(AttributeMappingOperand operand) {
		return operand.getOptionalDirectContainer(OperatorAttributeMapping)
	}
}
