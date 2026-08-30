package AST;

import AST.CSS.*;
import AST.HTML.*;
import AST.Jinja.*;
import SymboleTable.SymbolTable;
import antlr.JinjaHtmlCssParser;
import antlr.JinjaHtmlCssParserBaseVisitor;

public class Visitor extends JinjaHtmlCssParserBaseVisitor<Node> {

    private final SymbolTable symbolTable;

    public Visitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    @Override
    public Node visitDocumentNode(JinjaHtmlCssParser.DocumentNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        DocumentNode doc = new DocumentNode(line, col, ctx.DOCTYPE() != null);
        for (JinjaHtmlCssParser.NodeContext nCtx : ctx.node()) {
            Node child = visit(nCtx);
            if (child != null) doc.getChildren().add(child);
        }
        return doc;
    }

    @Override
    public Node visitNodeElement(JinjaHtmlCssParser.NodeElementContext ctx) {
        return visit(ctx.element());
    }

    @Override
    public Node visitNodeJinjaBlock(JinjaHtmlCssParser.NodeJinjaBlockContext ctx) {
        return visit(ctx.jinjaBlock());
    }

    @Override
    public Node visitNodeJinjaVar(JinjaHtmlCssParser.NodeJinjaVarContext ctx) {
        return visit(ctx.jinjaVar());
    }

    @Override
    public Node visitNodeStyleBlock(JinjaHtmlCssParser.NodeStyleBlockContext ctx) {
        return visit(ctx.styleBlock());
    }

    @Override
    public Node visitNodeHtmlText(JinjaHtmlCssParser.NodeHtmlTextContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        return new HtmlTextNode(line, col, ctx.HTML_TEXT().getText());
    }

    @Override
    public Node visitStyleBlockNode(JinjaHtmlCssParser.StyleBlockNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        CssContentNode content = (CssContentNode) visit(ctx.cssContent());
        return new StyleBlockNode(line, col, content);
    }

    @Override
    public Node visitCssContentNode(JinjaHtmlCssParser.CssContentNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        CssContentNode content = new CssContentNode(line, col);
        for (int i = 0; i < ctx.getChildCount(); i++) {
            Node tokenNode = visit(ctx.getChild(i));
            if (tokenNode != null) content.getTokens().add(tokenNode);
        }
        return content;
    }

    @Override
    public Node visitCssLBrace(JinjaHtmlCssParser.CssLBraceContext ctx) {
        return new CssLBraceNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "{");
    }

    @Override
    public Node visitCssRBrace(JinjaHtmlCssParser.CssRBraceContext ctx) {
        return new CssRBraceNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "}");
    }

    @Override
    public Node visitCssLBracket(JinjaHtmlCssParser.CssLBracketContext ctx) {
        return new CssLBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "[");
    }

    @Override
    public Node visitCssRBracket(JinjaHtmlCssParser.CssRBracketContext ctx) {
        return new CssRBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "]");
    }

    @Override
    public Node visitCssLParen(JinjaHtmlCssParser.CssLParenContext ctx) {
        return new CssLParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "(");
    }

    @Override
    public Node visitCssRParen(JinjaHtmlCssParser.CssRParenContext ctx) {
        return new CssRParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ")");
    }

    @Override
    public Node visitCssColon(JinjaHtmlCssParser.CssColonContext ctx) {
        return new CssColonNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ":");
    }

    @Override
    public Node visitCssDoubleColon(JinjaHtmlCssParser.CssDoubleColonContext ctx) {
        return new CssDoubleColonNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "::");
    }

    @Override
    public Node visitCssSemi(JinjaHtmlCssParser.CssSemiContext ctx) {
        return new CssSemiNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ";");
    }

    @Override
    public Node visitCssComma(JinjaHtmlCssParser.CssCommaContext ctx) {
        return new CssCommaNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ",");
    }

    @Override
    public Node visitCssDot(JinjaHtmlCssParser.CssDotContext ctx) {
        return new CssDotNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ".");
    }

    @Override
    public Node visitCssEqual(JinjaHtmlCssParser.CssEqualContext ctx) {
        return new CssEqualNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "=");
    }

    @Override
    public Node visitCssUnit(JinjaHtmlCssParser.CssUnitContext ctx) {
        return new CssUnitNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.CSS_UNIT().getText());
    }

    @Override
    public Node visitCssNumber(JinjaHtmlCssParser.CssNumberContext ctx) {
        return new CssNumberNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.CSS_NUMBER().getText());
    }

    @Override
    public Node visitCssString(JinjaHtmlCssParser.CssStringContext ctx) {
        String raw = ctx.CSS_STRING().getText();
        String clean = raw.substring(1, raw.length() - 1);
        return new CssStringNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), clean);
    }

    @Override
    public Node visitCssIdentifier(JinjaHtmlCssParser.CssIdentifierContext ctx) {
        return new CssIdentifierNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.CSS_IDENTIFIER().getText());
    }

    @Override
    public Node visitCssOther(JinjaHtmlCssParser.CssOtherContext ctx) {
        return new CssOtherNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getText());
    }

    @Override
    public Node visitHtmlElementNode(JinjaHtmlCssParser.HtmlElementNodeContext ctx) {
        return visit(ctx.htmlElement());
    }

    @Override
    public Node visitSelfClosingElement(JinjaHtmlCssParser.SelfClosingElementContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        String tag = ctx.TAG_IDENTIFIER().getText();
        HtmlElementNode el = new HtmlElementNode(line, col, tag, HtmlElementNode.ElementKind.SELF_CLOSING);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute()) {
            el.getAttributes().add((HtmlAttributeNode) visit(aCtx));
        }
        return el;
    }

    @Override
    public Node visitVoidElement(JinjaHtmlCssParser.VoidElementContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        String tag = ctx.TAG_VOID_NAME().getText();
        HtmlElementNode el = new HtmlElementNode(line, col, tag, HtmlElementNode.ElementKind.VOID);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute()) {
            el.getAttributes().add((HtmlAttributeNode) visit(aCtx));
        }
        return el;
    }

    @Override
    public Node visitVoidSelfClosingElement(JinjaHtmlCssParser.VoidSelfClosingElementContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        String tag = ctx.TAG_VOID_NAME().getText();
        HtmlElementNode el = new HtmlElementNode(line, col, tag, HtmlElementNode.ElementKind.SELF_CLOSING);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute()) {
            el.getAttributes().add((HtmlAttributeNode) visit(aCtx));
        }
        return el;
    }

    @Override
    public Node visitNormalElement(JinjaHtmlCssParser.NormalElementContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        String tag = ctx.openTag.getText();
        HtmlElementNode el = new HtmlElementNode(line, col, tag, HtmlElementNode.ElementKind.NORMAL);
        el.setHasClosingTag(ctx.closeTag != null);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute()) {
            Node attr = visit(aCtx);
            if (attr != null) el.getAttributes().add((HtmlAttributeNode) attr);
        }
        for (JinjaHtmlCssParser.NodeContext nCtx : ctx.node()) {
            Node child = visit(nCtx);
            if (child != null) el.getChildren().add(child);
        }
        return el;
    }

    @Override
    public Node visitAttributeNode(JinjaHtmlCssParser.AttributeNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        String name = ctx.attrName().getText();
        HtmlAttributeNode attr = new HtmlAttributeNode(line, col, name);
        for (JinjaHtmlCssParser.AttributeValueContext vCtx : ctx.attributeValue()) {
            Node v = visit(vCtx);
            if (v != null) attr.getValues().add(v);
        }
        return attr;
    }

    @Override
    public Node visitAttrString(JinjaHtmlCssParser.AttrStringContext ctx) {
        String raw = ctx.TAG_STRING().getText();
        String clean = raw.substring(1, raw.length() - 1);
        return new AttrStringNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), clean);
    }

    @Override
    public Node visitAttrIdentifier(JinjaHtmlCssParser.AttrIdentifierContext ctx) {
        return new AttrIdentifierNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.TAG_IDENTIFIER().getText());
    }

    @Override
    public Node visitAttrVoidName(JinjaHtmlCssParser.AttrVoidNameContext ctx) {
        return new AttrIdentifierNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.TAG_VOID_NAME().getText());
    }

    @Override
    public Node visitAttrJinjaVar(JinjaHtmlCssParser.AttrJinjaVarContext ctx) {
        return visit(ctx.jinjaVar());
    }

    @Override
    public Node visitAttrJinjaBlock(JinjaHtmlCssParser.AttrJinjaBlockContext ctx) {
        return visit(ctx.jinjaBlock());
    }

    @Override
    public Node visitJinjaBlockNode(JinjaHtmlCssParser.JinjaBlockNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        JinjaContentNode content = (JinjaContentNode) visit(ctx.jinjaContent());
        return new JinjaBlockNode(line, col, content);
    }

    @Override
    public Node visitJinjaVarNode(JinjaHtmlCssParser.JinjaVarNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        JinjaContentNode content = (JinjaContentNode) visit(ctx.jinjaContent());
        return new JinjaVarNode(line, col, content);
    }

    @Override
    public Node visitJinjaContentNode(JinjaHtmlCssParser.JinjaContentNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();
        JinjaContentNode content = new JinjaContentNode(line, col);
        for (JinjaHtmlCssParser.JinjaTokenContext tCtx : ctx.jinjaToken()) {
            Node tokenNode = visit(tCtx);
            if (tokenNode != null) content.getTokens().add(tokenNode);
        }
        return content;
    }

    @Override
    public Node visitJinjaKeyword(JinjaHtmlCssParser.JinjaKeywordContext ctx) {
        return new JinjaKeywordNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.JINJA_KEYWORD().getText());
    }

    @Override
    public Node visitJinjaIdentifier(JinjaHtmlCssParser.JinjaIdentifierContext ctx) {
        String name = ctx.JINJA_IDENTIFIER().getText();
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();

        symbolTable.insert(name, "jinja-usage", "Jinja");

        return new JinjaIdentifierNode(line, col, name);
    }

    @Override
    public Node visitJinjaDot(JinjaHtmlCssParser.JinjaDotContext ctx) {
        return new JinjaDotNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ".");
    }

    @Override
    public Node visitJinjaPipe(JinjaHtmlCssParser.JinjaPipeContext ctx) {
        return new JinjaPipeNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "|");
    }

    @Override
    public Node visitJinjaComma(JinjaHtmlCssParser.JinjaCommaContext ctx) {
        return new JinjaCommaNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ",");
    }

    @Override
    public Node visitJinjaLParen(JinjaHtmlCssParser.JinjaLParenContext ctx) {
        return new JinjaLParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "(");
    }

    @Override
    public Node visitJinjaRParen(JinjaHtmlCssParser.JinjaRParenContext ctx) {
        return new JinjaRParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ")");
    }

    @Override
    public Node visitJinjaLBracket(JinjaHtmlCssParser.JinjaLBracketContext ctx) {
        return new JinjaLBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "[");
    }

    @Override
    public Node visitJinjaRBracket(JinjaHtmlCssParser.JinjaRBracketContext ctx) {
        return new JinjaRBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "]");
    }

    @Override
    public Node visitJinjaOp(JinjaHtmlCssParser.JinjaOpContext ctx) {
        return new JinjaOpNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getText());
    }

    @Override
    public Node visitJinjaNumber(JinjaHtmlCssParser.JinjaNumberContext ctx) {
        return new JinjaNumberNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.JINJA_NUMBER().getText());
    }

    @Override
    public Node visitJinjaString(JinjaHtmlCssParser.JinjaStringContext ctx) {
        String raw = ctx.JINJA_STRING().getText();
        String clean = raw.substring(1, raw.length() - 1);
        return new JinjaStringNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), clean);
    }

    @Override
    public Node visitJinjaAny(JinjaHtmlCssParser.JinjaAnyContext ctx) {
        return new JinjaAnyNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getText());
    }
}