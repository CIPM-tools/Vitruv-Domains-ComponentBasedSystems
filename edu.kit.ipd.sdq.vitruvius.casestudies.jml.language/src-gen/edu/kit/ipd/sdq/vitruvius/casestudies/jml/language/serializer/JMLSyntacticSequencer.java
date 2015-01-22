package edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.serializer;

import com.google.inject.Inject;
import edu.kit.ipd.sdq.vitruvius.casestudies.jml.language.services.JMLGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class JMLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected JMLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AnnotationTypeElementRest_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_AnnotationTypeElementRest_SemicolonKeyword_2_1_q;
	protected AbstractElementAlias match_AnnotationTypeElementRest_SemicolonKeyword_3_1_q;
	protected AbstractElementAlias match_AnnotationTypeElementRest_SemicolonKeyword_4_1_q;
	protected AbstractElementAlias match_Annotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q;
	protected AbstractElementAlias match_Assignment___LeftSquareBracketKeyword_0_1_1_0_RightSquareBracketKeyword_0_1_1_1__a;
	protected AbstractElementAlias match_BlockExpression_SemicolonKeyword_2_2_q;
	protected AbstractElementAlias match_ElementValueArrayInitializer_CommaKeyword_3_q;
	protected AbstractElementAlias match_EnumConstant___LeftCurlyBracketKeyword_1_3_0_RightCurlyBracketKeyword_1_3_2__q;
	protected AbstractElementAlias match_EnumDeclaration_CommaKeyword_5_q;
	protected AbstractElementAlias match_ExpressionInClosure_SemicolonKeyword_1_1_q;
	protected AbstractElementAlias match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q;
	protected AbstractElementAlias match_XImportDeclaration_SemicolonKeyword_2_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (JMLGrammarAccess) access;
		match_AnnotationTypeElementRest_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getAnnotationTypeElementRestAccess().getSemicolonKeyword_1_1());
		match_AnnotationTypeElementRest_SemicolonKeyword_2_1_q = new TokenAlias(false, true, grammarAccess.getAnnotationTypeElementRestAccess().getSemicolonKeyword_2_1());
		match_AnnotationTypeElementRest_SemicolonKeyword_3_1_q = new TokenAlias(false, true, grammarAccess.getAnnotationTypeElementRestAccess().getSemicolonKeyword_3_1());
		match_AnnotationTypeElementRest_SemicolonKeyword_4_1_q = new TokenAlias(false, true, grammarAccess.getAnnotationTypeElementRestAccess().getSemicolonKeyword_4_1());
		match_Annotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getAnnotationAccess().getLeftParenthesisKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAnnotationAccess().getRightParenthesisKeyword_3_2()));
		match_Assignment___LeftSquareBracketKeyword_0_1_1_0_RightSquareBracketKeyword_0_1_1_1__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getAssignmentAccess().getLeftSquareBracketKeyword_0_1_1_0()), new TokenAlias(false, false, grammarAccess.getAssignmentAccess().getRightSquareBracketKeyword_0_1_1_1()));
		match_BlockExpression_SemicolonKeyword_2_2_q = new TokenAlias(false, true, grammarAccess.getBlockExpressionAccess().getSemicolonKeyword_2_2());
		match_ElementValueArrayInitializer_CommaKeyword_3_q = new TokenAlias(false, true, grammarAccess.getElementValueArrayInitializerAccess().getCommaKeyword_3());
		match_EnumConstant___LeftCurlyBracketKeyword_1_3_0_RightCurlyBracketKeyword_1_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getEnumConstantAccess().getLeftCurlyBracketKeyword_1_3_0()), new TokenAlias(false, false, grammarAccess.getEnumConstantAccess().getRightCurlyBracketKeyword_1_3_2()));
		match_EnumDeclaration_CommaKeyword_5_q = new TokenAlias(false, true, grammarAccess.getEnumDeclarationAccess().getCommaKeyword_5());
		match_ExpressionInClosure_SemicolonKeyword_1_1_q = new TokenAlias(false, true, grammarAccess.getExpressionInClosureAccess().getSemicolonKeyword_1_1());
		match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()));
		match_XImportDeclaration_SemicolonKeyword_2_q = new TokenAlias(false, true, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getArrayBracketsRule())
			return getArrayBracketsToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getJMLMultilineSpecCommentEndRule())
			return getJMLMultilineSpecCommentEndToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getJMLMultilineSpecCommentStartRule())
			return getJMLMultilineSpecCommentStartToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getOpSingleAssignRule())
			return getOpSingleAssignToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * ArrayBrackets :
	 * 	'[' ']'
	 * ;
	 */
	protected String getArrayBracketsToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	protected String getJMLMultilineSpecCommentEndToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "*/";
	}
	
	/**
	 * JMLMultilineSpecCommentStart:
	 * 	'/*@'
	 * ;
	 */
	protected String getJMLMultilineSpecCommentStartToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "/*@";
	}
	
	/**
	 * OpSingleAssign:
	 * 	'='
	 * ;
	 */
	protected String getOpSingleAssignToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AnnotationTypeElementRest_SemicolonKeyword_1_1_q.equals(syntax))
				emit_AnnotationTypeElementRest_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AnnotationTypeElementRest_SemicolonKeyword_2_1_q.equals(syntax))
				emit_AnnotationTypeElementRest_SemicolonKeyword_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AnnotationTypeElementRest_SemicolonKeyword_3_1_q.equals(syntax))
				emit_AnnotationTypeElementRest_SemicolonKeyword_3_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_AnnotationTypeElementRest_SemicolonKeyword_4_1_q.equals(syntax))
				emit_AnnotationTypeElementRest_SemicolonKeyword_4_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Annotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q.equals(syntax))
				emit_Annotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Assignment___LeftSquareBracketKeyword_0_1_1_0_RightSquareBracketKeyword_0_1_1_1__a.equals(syntax))
				emit_Assignment___LeftSquareBracketKeyword_0_1_1_0_RightSquareBracketKeyword_0_1_1_1__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_BlockExpression_SemicolonKeyword_2_2_q.equals(syntax))
				emit_BlockExpression_SemicolonKeyword_2_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ElementValueArrayInitializer_CommaKeyword_3_q.equals(syntax))
				emit_ElementValueArrayInitializer_CommaKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumConstant___LeftCurlyBracketKeyword_1_3_0_RightCurlyBracketKeyword_1_3_2__q.equals(syntax))
				emit_EnumConstant___LeftCurlyBracketKeyword_1_3_0_RightCurlyBracketKeyword_1_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumDeclaration_CommaKeyword_5_q.equals(syntax))
				emit_EnumDeclaration_CommaKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ExpressionInClosure_SemicolonKeyword_1_1_q.equals(syntax))
				emit_ExpressionInClosure_SemicolonKeyword_1_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q.equals(syntax))
				emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_XImportDeclaration_SemicolonKeyword_2_q.equals(syntax))
				emit_XImportDeclaration_SemicolonKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_AnnotationTypeElementRest_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_AnnotationTypeElementRest_SemicolonKeyword_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_AnnotationTypeElementRest_SemicolonKeyword_3_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_AnnotationTypeElementRest_SemicolonKeyword_4_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_Annotation___LeftParenthesisKeyword_3_0_RightParenthesisKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')*
	 */
	protected void emit_Assignment___LeftSquareBracketKeyword_0_1_1_0_RightSquareBracketKeyword_0_1_1_1__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_BlockExpression_SemicolonKeyword_2_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_ElementValueArrayInitializer_CommaKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_EnumConstant___LeftCurlyBracketKeyword_1_3_0_RightCurlyBracketKeyword_1_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_EnumDeclaration_CommaKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_ExpressionInClosure_SemicolonKeyword_1_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_XFunctionTypeRef___LeftParenthesisKeyword_0_0_RightParenthesisKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ';'?
	 */
	protected void emit_XImportDeclaration_SemicolonKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
