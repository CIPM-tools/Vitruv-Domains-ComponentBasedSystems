/*
 * generated by Xtext
 */
package tools.vitruvius.domains.jml.language.formatting

import tools.vitruvius.domains.jml.language.services.JMLGrammarAccess
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class JMLFormatter extends AbstractDeclarativeFormatter {

	//@Inject extension JMLGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		val JMLGrammarAccess f = getGrammarAccess() as JMLGrammarAccess;

		c.autoLinewrap = 9999

		// blank line after various elements
		c.setLinewrap(2).after(f.packageDeclarationRule)
		c.setLinewrap(2).after(f.compilationUnitAccess.importdeclarationAssignment_2)
		c.setLinewrap(2).after(f.normalClassDeclarationAccess.leftCurlyBracketKeyword_5)
		c.setLinewrap(2).after(f.normalInterfaceDeclarationAccess.leftCurlyBracketKeyword_4)
		
		// new line after various elements
		c.setLinewrap(1).after(f.JMLMultilineSpecAccess.JMLMultilineSpecCommentStartParserRuleCall_0)
		c.setLinewrap(1).after(f.JMLMultilineSpecAccess.JMLMultilineSpecCommentEndParserRuleCall_1_0_1)
		c.setLinewrap(1).after(f.JMLMultilineSpecAccess.JMLMultilineSpecCommentEndParserRuleCall_1_1_1_0_1)
		c.setLinewrap(1).after(f.JMLMultilineSpecAccess.JMLMultilineSpecCommentEndParserRuleCall_1_1_1_1_0)
		c.setLinewrap(1).after(f.JMLNormalBehaviorBlockAccess.normal_behaviorKeyword_0)
		
		// no newline after specific keywords
		c.setNoLinewrap().after(f.importDeclarationAccess.importKeyword_0)
		c.setNoLinewrap().after(f.packageDeclarationAccess.packageKeyword_0)
		
		// new line after semicolon and no space before
		val semikolonKeywords = f.findKeywords(";")
		semikolonKeywords.forEach[c.setLinewrap(1).after(it)]
		semikolonKeywords.forEach[c.setNoSpace.before(it)]
		
		// indentation inside blocks with curly brackets
		val blocksKeywords = f.findKeywordPairs("{", "}")
		blocksKeywords.forEach[c.setIndentationIncrement.after(first)]
		blocksKeywords.forEach[c.setIndentationDecrement.before(second)]
		blocksKeywords.forEach[c.setLinewrap(1).after(first)]
		
		// no space after opening and before closing parenthesis
		val parenthesisKeywords = f.findKeywordPairs("(", ")")
		parenthesisKeywords.forEach[c.setNoSpace.after(first)]
		parenthesisKeywords.forEach[c.setNoSpace.before(second)]
		
		// no space before but one whitespace after comma
		val commaKeywords = f.findKeywords(",")
		commaKeywords.forEach[c.setNoSpace().before(it)]
		commaKeywords.forEach[c.setSpace(" ").after(it)]
		
		//no space before and after .
		val dotKeywords = f.findKeywords(".")
		dotKeywords.forEach[c.setNoSpace().around(it)]
		
		// no space before arguments of feature call
		c.setNoSpace().before(f.featureCallAccess.explicitOperationCallLeftParenthesisKeyword_3_0_0)
		c.setNoSpace().before(f.memberFeatureCallAccess.explicitOperationCallLeftParenthesisKeyword_1_1_3_0_0)
		c.setNoSpace().after(f.JMLOldExpressionAccess.oldKeyword_1)
		val memberFeatureCallParenthesis = f.memberFeatureCallAccess.findKeywords("(", ")")
		memberFeatureCallParenthesis.forEach[c.setNoSpace.around(it)]
		
		// class extends
		c.setNoLinewrap.after(f.normalClassDeclarationAccess.extendsKeyword_3_0)
		
		// type parameters
		val typeParametersOpening =  f.typeParametersAccess.findKeywords("<")
		typeParametersOpening.forEach[c.setNoSpace.after(it)]
		
		// annotations
		c.setNoSpace.after(f.annotationAccess.commercialAtKeyword_1)
		c.setLinewrap.after(f.annotationRule)
		
		// no spaces for brackets used in types		
		c.setNoSpace.before(f.bracketsAccess.leftSquareBracketKeyword_1)
		c.setNoSpace.after(f.bracketsAccess.leftSquareBracketKeyword_1)
		c.setNoSpace.after(f.primitiveTypeWithBracketsAccess.bracketsAssignment_1)
		c.setSpace(" ").after(f.primitiveTypeWithBracketsRule)
		
		// no new line after semicolon in forall
		c.setNoLinewrap.after(f.JMLForAllExpressionAccess.semicolonKeyword_3)
		c.setNoLinewrap.after(f.JMLForAllExpressionAccess.semicolonKeyword_5)
		
		// no spaces around closure
		c.setNoSpace.after(f.closureAccess.leftSquareBracketKeyword_0_0_1)
		c.setNoSpace.before(f.closureAccess.rightSquareBracketKeyword_3)
		c.setNoSpace.before(f.closureRule)
		
		// new line between JML statements
		c.setLinewrap(2).after(f.JMLSpecifiedElementRule)
		c.setLinewrap(2).before(f.JMLMultilineSpecAccess.JMLMultilineSpecCommentStartParserRuleCall_0)
		
		
// It's usually a good idea to activate the following three statements.
// They will add and preserve newlines around comments
		c.setLinewrap(0, 1, 2).before(f.SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(f.ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(f.ML_COMMENTRule)


	}
}
