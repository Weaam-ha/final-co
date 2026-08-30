// Generated from E:/S.F.S/compiler002/compiler001/compiler2/src/antlr/JinjaHtmlCssParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JinjaHtmlCssParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JinjaHtmlCssParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code DocumentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocumentNode(JinjaHtmlCssParser.DocumentNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NodeElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeElement(JinjaHtmlCssParser.NodeElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NodeJinjaBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeJinjaBlock(JinjaHtmlCssParser.NodeJinjaBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NodeJinjaVar}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeJinjaVar(JinjaHtmlCssParser.NodeJinjaVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NodeStyleBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeStyleBlock(JinjaHtmlCssParser.NodeStyleBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NodeHtmlText}
	 * labeled alternative in {@link JinjaHtmlCssParser#node}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeHtmlText(JinjaHtmlCssParser.NodeHtmlTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StyleBlockNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#styleBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleBlockNode(JinjaHtmlCssParser.StyleBlockNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssContentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssContentNode(JinjaHtmlCssParser.CssContentNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssLBrace}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssLBrace(JinjaHtmlCssParser.CssLBraceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRBrace}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRBrace(JinjaHtmlCssParser.CssRBraceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssLBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssLBracket(JinjaHtmlCssParser.CssLBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRBracket(JinjaHtmlCssParser.CssRBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssLParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssLParen(JinjaHtmlCssParser.CssLParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRParen(JinjaHtmlCssParser.CssRParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssColon}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssColon(JinjaHtmlCssParser.CssColonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDoubleColon}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDoubleColon(JinjaHtmlCssParser.CssDoubleColonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssSemi}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSemi(JinjaHtmlCssParser.CssSemiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssComma}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssComma(JinjaHtmlCssParser.CssCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssDot}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDot(JinjaHtmlCssParser.CssDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssEqual}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssEqual(JinjaHtmlCssParser.CssEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssUnit}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssUnit(JinjaHtmlCssParser.CssUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssString}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssString(JinjaHtmlCssParser.CssStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssIdentifier(JinjaHtmlCssParser.CssIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssNumber}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssNumber(JinjaHtmlCssParser.CssNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssOther}
	 * labeled alternative in {@link JinjaHtmlCssParser#cssToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssOther(JinjaHtmlCssParser.CssOtherContext ctx);
	/**
	 * Visit a parse tree produced by the {@code HtmlElementNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElementNode(JinjaHtmlCssParser.HtmlElementNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelfClosingElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingElement(JinjaHtmlCssParser.SelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidSelfClosingElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidSelfClosingElement(JinjaHtmlCssParser.VoidSelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElement(JinjaHtmlCssParser.VoidElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalElement}
	 * labeled alternative in {@link JinjaHtmlCssParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalElement(JinjaHtmlCssParser.NormalElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttributeNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeNode(JinjaHtmlCssParser.AttributeNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JinjaHtmlCssParser#attrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(JinjaHtmlCssParser.AttrNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrString}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrString(JinjaHtmlCssParser.AttrStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrIdentifier(JinjaHtmlCssParser.AttrIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrVoidName}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrVoidName(JinjaHtmlCssParser.AttrVoidNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaVar}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaVar(JinjaHtmlCssParser.AttrJinjaVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaBlock}
	 * labeled alternative in {@link JinjaHtmlCssParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaBlock(JinjaHtmlCssParser.AttrJinjaBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaBlockNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockNode(JinjaHtmlCssParser.JinjaBlockNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaVarNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaVarNode(JinjaHtmlCssParser.JinjaVarNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaContentNode}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaContentNode(JinjaHtmlCssParser.JinjaContentNodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaKeyword}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaKeyword(JinjaHtmlCssParser.JinjaKeywordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIdentifier}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIdentifier(JinjaHtmlCssParser.JinjaIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaDot}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaDot(JinjaHtmlCssParser.JinjaDotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaPipe}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaPipe(JinjaHtmlCssParser.JinjaPipeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaComma}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaComma(JinjaHtmlCssParser.JinjaCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaLParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaLParen(JinjaHtmlCssParser.JinjaLParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaRParen}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaRParen(JinjaHtmlCssParser.JinjaRParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaLBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaLBracket(JinjaHtmlCssParser.JinjaLBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaRBracket}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaRBracket(JinjaHtmlCssParser.JinjaRBracketContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaOp}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaOp(JinjaHtmlCssParser.JinjaOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaNumber}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaNumber(JinjaHtmlCssParser.JinjaNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaString}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaString(JinjaHtmlCssParser.JinjaStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaAny}
	 * labeled alternative in {@link JinjaHtmlCssParser#jinjaToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaAny(JinjaHtmlCssParser.JinjaAnyContext ctx);
}