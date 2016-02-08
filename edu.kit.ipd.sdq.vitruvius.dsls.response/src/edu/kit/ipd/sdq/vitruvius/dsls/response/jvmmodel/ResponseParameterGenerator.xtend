package edu.kit.ipd.sdq.vitruvius.dsls.response.jvmmodel

import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeReferenceBuilder
import org.eclipse.emf.ecore.EObject
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.Blackboard
import org.eclipse.xtext.common.types.JvmTypeReference
import java.util.ArrayList
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteTargetModelRootChange
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Response
import java.util.List
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ConcreteModelElementChange
import static extension edu.kit.ipd.sdq.vitruvius.dsls.response.helper.EChangeHelper.*;
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.ModelChange
import edu.kit.ipd.sdq.vitruvius.dsls.response.responseLanguage.Trigger

package class ResponseParameterGenerator {
	private static val CHANGE_PARAMETER_NAME = "change";
	private static val TARGET_MODEL_PARAMETER_NAME = "targetElement";
	private static val BLACKBOARD_PARAMETER_NAME = "blackboard";
	
	protected extension static JvmTypeReferenceBuilder _typeReferenceBuilder;
	protected extension JvmTypesBuilderWithoutAssociations _typesBuilder;	
	private final Response response;
	private final Class<? extends EChange> change;
	
	new (Response response, JvmTypeReferenceBuilder typeReferenceBuilder, JvmTypesBuilderWithoutAssociations typesBuilder) {
		_typeReferenceBuilder = typeReferenceBuilder;
		_typesBuilder = typesBuilder;
		this.response = response;
		this.change = response.trigger.generateEChangeInstanceClass();
	}
	
	def dispatch calculateEChange(ModelChange change) {
		return change.generateEChange();
	}
	
	def dispatch calculateEChange(Trigger trigger) {
		throw new UnsupportedOperationException();
	}
	
	protected def JvmFormalParameter generateUntypedChangeParameter(EObject parameterContext) {
		return parameterContext.generateParameter(CHANGE_PARAMETER_NAME, EChange);
	}

	protected def JvmFormalParameter generateChangeParameter(EObject parameterContext) {
		var List<String> changeTypeParameters = <String>newArrayList;
		val event = response.trigger
		if (event instanceof ConcreteModelElementChange) {
			changeTypeParameters = #[getGenericTypeParameterFQNOfChange(event)]			
		}
		val changeParameter = parameterContext.generateParameter(CHANGE_PARAMETER_NAME, change, changeTypeParameters);
		if (changeParameter != null) {
			return changeParameter;
		}
	}
	
	protected def JvmFormalParameter generateTargetModelParameter(EObject parameterContext) {
		if (response.effects.targetChange != null) {
			val rootChange = response.effects.targetChange as ConcreteTargetModelRootChange;
			if (rootChange?.rootModelElement?.element != null) {
				return parameterContext.generateParameter(TARGET_MODEL_PARAMETER_NAME, rootChange.rootModelElement.element.instanceClass);
			}	
		}
		return null;
	}
	
	protected def JvmFormalParameter generateBlackboardParameter(EObject parameterContext) {
		return generateParameter(parameterContext, BLACKBOARD_PARAMETER_NAME, Blackboard);
	}
	
	private def generateParameter(EObject context, String parameterName, Class<?> parameterClass, String... typeParameterClassNames) {
		if (parameterClass == null) {
			return null;
		}
		val typeParameters = new ArrayList<JvmTypeReference>(typeParameterClassNames.size);
		for (typeParameterClassName : typeParameterClassNames) {
			typeParameters.add(typeRef(typeParameterClassName));	
		}		
		val changeType = typeRef(parameterClass, typeParameters)
		return context.toParameter(parameterName, changeType);
	}
}