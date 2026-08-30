// Generated from E:/S.F.S/compiler002/compiler001/compiler2/src/antlr/JinjaHtmlCssParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JinjaHtmlCssParser}.
 */
public interface JinjaHtmlCssParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code DocumentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocumentNode(JinjaHtmlCssParser.DocumentNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DocumentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocumentNode(JinjaHtmlCssParser.DocumentNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NodeElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNodeElement(JinjaHtmlCssParser.NodeElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NodeElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNodeElement(JinjaHtmlCssParser.NodeElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NodeJinjaBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNodeJinjaBlock(JinjaHtmlCssParser.NodeJinjaBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NodeJinjaBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNodeJinjaBlock(JinjaHtmlCssParser.NodeJinjaBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NodeJinjaVar}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNodeJinjaVar(JinjaHtmlCssParser.NodeJinjaVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NodeJinjaVar}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNodeJinjaVar(JinjaHtmlCssParser.NodeJinjaVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NodeStyleBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNodeStyleBlock(JinjaHtmlCssParser.NodeStyleBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NodeStyleBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNodeStyleBlock(JinjaHtmlCssParser.NodeStyleBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NodeHtmlText}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void enterNodeHtmlText(JinjaHtmlCssParser.NodeHtmlTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NodeHtmlText}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 */
	void exitNodeHtmlText(JinjaHtmlCssParser.NodeHtmlTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StyleBlockNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#styleBlock}.
	 * @param ctx the parse tree
	 */
	void enterStyleBlockNode(JinjaHtmlCssParser.StyleBlockNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StyleBlockNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#styleBlock}.
	 * @param ctx the parse tree
	 */
	void exitStyleBlockNode(JinjaHtmlCssParser.StyleBlockNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssContentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssContentNode(JinjaHtmlCssParser.CssContentNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssContentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssContentNode(JinjaHtmlCssParser.CssContentNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssLBrace}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssLBrace(JinjaHtmlCssParser.CssLBraceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssLBrace}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssLBrace(JinjaHtmlCssParser.CssLBraceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRBrace}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssRBrace(JinjaHtmlCssParser.CssRBraceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRBrace}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssRBrace(JinjaHtmlCssParser.CssRBraceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssLBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssLBracket(JinjaHtmlCssParser.CssLBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssLBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssLBracket(JinjaHtmlCssParser.CssLBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssRBracket(JinjaHtmlCssParser.CssRBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssRBracket(JinjaHtmlCssParser.CssRBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssLParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssLParen(JinjaHtmlCssParser.CssLParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssLParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssLParen(JinjaHtmlCssParser.CssLParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssRParen(JinjaHtmlCssParser.CssRParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssRParen(JinjaHtmlCssParser.CssRParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssColon}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssColon(JinjaHtmlCssParser.CssColonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssColon}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssColon(JinjaHtmlCssParser.CssColonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDoubleColon}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssDoubleColon(JinjaHtmlCssParser.CssDoubleColonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDoubleColon}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssDoubleColon(JinjaHtmlCssParser.CssDoubleColonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssSemi}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssSemi(JinjaHtmlCssParser.CssSemiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssSemi}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssSemi(JinjaHtmlCssParser.CssSemiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssComma}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssComma(JinjaHtmlCssParser.CssCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssComma}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssComma(JinjaHtmlCssParser.CssCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssDot}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssDot(JinjaHtmlCssParser.CssDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssDot}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssDot(JinjaHtmlCssParser.CssDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssEqual}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssEqual(JinjaHtmlCssParser.CssEqualContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssEqual}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssEqual(JinjaHtmlCssParser.CssEqualContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssUnit}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssUnit(JinjaHtmlCssParser.CssUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssUnit}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssUnit(JinjaHtmlCssParser.CssUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssString}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssString(JinjaHtmlCssParser.CssStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssString}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssString(JinjaHtmlCssParser.CssStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssIdentifier(JinjaHtmlCssParser.CssIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssIdentifier(JinjaHtmlCssParser.CssIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssNumber}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssNumber(JinjaHtmlCssParser.CssNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssNumber}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssNumber(JinjaHtmlCssParser.CssNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssOther}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void enterCssOther(JinjaHtmlCssParser.CssOtherContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssOther}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 */
	void exitCssOther(JinjaHtmlCssParser.CssOtherContext ctx);
	/**
	 * Enter a parse tree produced by the {@code HtmlElementNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#element}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElementNode(JinjaHtmlCssParser.HtmlElementNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code HtmlElementNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#element}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElementNode(JinjaHtmlCssParser.HtmlElementNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingElement(JinjaHtmlCssParser.SelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingElement(JinjaHtmlCssParser.SelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidSelfClosingElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidSelfClosingElement(JinjaHtmlCssParser.VoidSelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidSelfClosingElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidSelfClosingElement(JinjaHtmlCssParser.VoidSelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElement(JinjaHtmlCssParser.VoidElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElement(JinjaHtmlCssParser.VoidElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterNormalElement(JinjaHtmlCssParser.NormalElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitNormalElement(JinjaHtmlCssParser.NormalElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttributeNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttributeNode(JinjaHtmlCssParser.AttributeNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttributeNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttributeNode(JinjaHtmlCssParser.AttributeNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JinjaHtmlCssParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(JinjaHtmlCssParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JinjaHtmlCssParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(JinjaHtmlCssParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrString}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrString(JinjaHtmlCssParser.AttrStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrString}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrString(JinjaHtmlCssParser.AttrStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrIdentifier(JinjaHtmlCssParser.AttrIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrIdentifier(JinjaHtmlCssParser.AttrIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrVoidName}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrVoidName(JinjaHtmlCssParser.AttrVoidNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrVoidName}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrVoidName(JinjaHtmlCssParser.AttrVoidNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaVar}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaVar(JinjaHtmlCssParser.AttrJinjaVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaVar}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaVar(JinjaHtmlCssParser.AttrJinjaVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaBlock(JinjaHtmlCssParser.AttrJinjaBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaBlock(JinjaHtmlCssParser.AttrJinjaBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaBlockNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockNode(JinjaHtmlCssParser.JinjaBlockNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaBlockNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockNode(JinjaHtmlCssParser.JinjaBlockNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaVarNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaVar}.
	 * @param ctx the parse tree
	 */
	void enterJinjaVarNode(JinjaHtmlCssParser.JinjaVarNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaVarNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaVar}.
	 * @param ctx the parse tree
	 */
	void exitJinjaVarNode(JinjaHtmlCssParser.JinjaVarNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaContentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaContentNode(JinjaHtmlCssParser.JinjaContentNodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaContentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaContentNode(JinjaHtmlCssParser.JinjaContentNodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaKeyword}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaKeyword(JinjaHtmlCssParser.JinjaKeywordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaKeyword}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaKeyword(JinjaHtmlCssParser.JinjaKeywordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIdentifier(JinjaHtmlCssParser.JinjaIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIdentifier(JinjaHtmlCssParser.JinjaIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaDot}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaDot(JinjaHtmlCssParser.JinjaDotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaDot}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaDot(JinjaHtmlCssParser.JinjaDotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaPipe}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaPipe(JinjaHtmlCssParser.JinjaPipeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaPipe}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaPipe(JinjaHtmlCssParser.JinjaPipeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaComma}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaComma(JinjaHtmlCssParser.JinjaCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaComma}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaComma(JinjaHtmlCssParser.JinjaCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaLParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaLParen(JinjaHtmlCssParser.JinjaLParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaLParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaLParen(JinjaHtmlCssParser.JinjaLParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaRParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaRParen(JinjaHtmlCssParser.JinjaRParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaRParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaRParen(JinjaHtmlCssParser.JinjaRParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaLBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaLBracket(JinjaHtmlCssParser.JinjaLBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaLBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaLBracket(JinjaHtmlCssParser.JinjaLBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaRBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaRBracket(JinjaHtmlCssParser.JinjaRBracketContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaRBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaRBracket(JinjaHtmlCssParser.JinjaRBracketContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaOp}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaOp(JinjaHtmlCssParser.JinjaOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaOp}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaOp(JinjaHtmlCssParser.JinjaOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaNumber}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaNumber(JinjaHtmlCssParser.JinjaNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaNumber}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaNumber(JinjaHtmlCssParser.JinjaNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaString}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaString(JinjaHtmlCssParser.JinjaStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaString}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaString(JinjaHtmlCssParser.JinjaStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaAny}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void enterJinjaAny(JinjaHtmlCssParser.JinjaAnyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaAny}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 */
	void exitJinjaAny(JinjaHtmlCssParser.JinjaAnyContext ctx);
}