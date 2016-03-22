/*
 * generated by Xtext 2.9.0
 */
package edu.kit.ipd.sdq.vitruvius.dsls.response.validation

import org.eclipse.xtext.validation.Check
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ResponseFile
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.generator.ResponseLanguageGeneratorUtils.*;
import java.util.HashMap
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Response
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.CorrespondingModelElementSpecification
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Effect

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class ResponseLanguageValidator extends AbstractResponseLanguageValidator {
	
	@Check
	def checkResponseFile(ResponseFile file) {
		val alreadyCheckedResponses = new HashMap<String, Response>();
		for (response : file.responses) {
			if (alreadyCheckedResponses.containsKey(response.responseName)) {
				warning("Duplicate response name.",
					response, ResponseLanguagePackage.Literals.RESPONSE__NAME);
				warning("Duplicate response name.",
					alreadyCheckedResponses.get(response.responseName), ResponseLanguagePackage.Literals.RESPONSE__NAME);
			}
			alreadyCheckedResponses.put(response.responseName, response);
		}
	}

	@Check
	def checkCorrespondingElementSpecification(CorrespondingModelElementSpecification element) {
		if (!element.name.nullOrEmpty && element.name.startsWith("_")) {
			error("Element names must not start with an underscore.", ResponseLanguagePackage.Literals.CORRESPONDING_MODEL_ELEMENT_SPECIFICATION__NAME);
		}
	}

	@Check
	def checkEffects(Effect effect) {
		if (effect.codeBlock == null && !effect.createElements.nullOrEmpty) {
			warning("Created elements must be initialized and inserted into the target model in the execute block.",
				ResponseLanguagePackage.Literals.EFFECT__CODE_BLOCK);			
		}
	}
	
}
