package AST;

import AST.CSS.*;
import AST.HTML.*;
import AST.Jinja.*;
import SymboleTable.SymbolTable;
import antlr.JinjaHtmlCssParser;
import antlr.JinjaHtmlCssParserBaseVisitor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Visitor extends JinjaHtmlCssParserBaseVisitor<Node> {

    private final SymbolTable symbolTable;

    // يتتبع نوع البلوكات المفتوحة (for / if / elif)
    private final Deque<String> blockStack = new ArrayDeque<>();

    // flags خاصة بـ for-header لتمييز loop var عن باقي الـ identifiers
    private boolean insideForHeader  = false;
    private boolean loopVarConsumed  = false;
    // لمنع تسجيل الـ properties (اللي بعد dot) كمتغيرات مستقلة في الـ symbol table
    private boolean prevWasDot       = false;

    public Visitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    // ─────────────────────────────────────────────────────────────────────────────
    //  Document / HTML / CSS — لا تغيير عنهم
    // ─────────────────────────────────────────────────────────────────────────────

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

    @Override public Node visitNodeElement(JinjaHtmlCssParser.NodeElementContext ctx)         { return visit(ctx.element()); }
    @Override public Node visitNodeJinjaBlock(JinjaHtmlCssParser.NodeJinjaBlockContext ctx)   { return visit(ctx.jinjaBlock()); }
    @Override public Node visitNodeJinjaVar(JinjaHtmlCssParser.NodeJinjaVarContext ctx)       { return visit(ctx.jinjaVar()); }
    @Override public Node visitNodeStyleBlock(JinjaHtmlCssParser.NodeStyleBlockContext ctx)   { return visit(ctx.styleBlock()); }

    @Override
    public Node visitNodeHtmlText(JinjaHtmlCssParser.NodeHtmlTextContext ctx) {
        return new HtmlTextNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.HTML_TEXT().getText());
    }

    @Override
    public Node visitStyleBlockNode(JinjaHtmlCssParser.StyleBlockNodeContext ctx) {
        CssContentNode content = (CssContentNode) visit(ctx.cssContent());
        return new StyleBlockNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), content);
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

    @Override public Node visitCssLBrace(JinjaHtmlCssParser.CssLBraceContext ctx)           { return new CssLBraceNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "{"); }
    @Override public Node visitCssRBrace(JinjaHtmlCssParser.CssRBraceContext ctx)           { return new CssRBraceNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "}"); }
    @Override public Node visitCssLBracket(JinjaHtmlCssParser.CssLBracketContext ctx)       { return new CssLBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "["); }
    @Override public Node visitCssRBracket(JinjaHtmlCssParser.CssRBracketContext ctx)       { return new CssRBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "]"); }
    @Override public Node visitCssLParen(JinjaHtmlCssParser.CssLParenContext ctx)           { return new CssLParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "("); }
    @Override public Node visitCssRParen(JinjaHtmlCssParser.CssRParenContext ctx)           { return new CssRParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ")"); }
    @Override public Node visitCssColon(JinjaHtmlCssParser.CssColonContext ctx)             { return new CssColonNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ":"); }
    @Override public Node visitCssDoubleColon(JinjaHtmlCssParser.CssDoubleColonContext ctx) { return new CssDoubleColonNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "::"); }
    @Override public Node visitCssSemi(JinjaHtmlCssParser.CssSemiContext ctx)               { return new CssSemiNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ";"); }
    @Override public Node visitCssComma(JinjaHtmlCssParser.CssCommaContext ctx)             { return new CssCommaNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ","); }
    @Override public Node visitCssDot(JinjaHtmlCssParser.CssDotContext ctx)                 { return new CssDotNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "."); }
    @Override public Node visitCssEqual(JinjaHtmlCssParser.CssEqualContext ctx)             { return new CssEqualNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "="); }
    @Override public Node visitCssUnit(JinjaHtmlCssParser.CssUnitContext ctx)               { return new CssUnitNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.CSS_UNIT().getText()); }
    @Override public Node visitCssNumber(JinjaHtmlCssParser.CssNumberContext ctx)           { return new CssNumberNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.CSS_NUMBER().getText()); }
    @Override public Node visitCssIdentifier(JinjaHtmlCssParser.CssIdentifierContext ctx)   { return new CssIdentifierNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.CSS_IDENTIFIER().getText()); }
    @Override public Node visitCssOther(JinjaHtmlCssParser.CssOtherContext ctx)             { return new CssOtherNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getText()); }

    @Override
    public Node visitCssString(JinjaHtmlCssParser.CssStringContext ctx) {
        String raw = ctx.CSS_STRING().getText();
        return new CssStringNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), raw.substring(1, raw.length() - 1));
    }

    @Override public Node visitHtmlElementNode(JinjaHtmlCssParser.HtmlElementNodeContext ctx) { return visit(ctx.htmlElement()); }

    @Override
    public Node visitSelfClosingElement(JinjaHtmlCssParser.SelfClosingElementContext ctx) {
        HtmlElementNode el = new HtmlElementNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.TAG_IDENTIFIER().getText(), HtmlElementNode.ElementKind.SELF_CLOSING);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute())
            el.getAttributes().add((HtmlAttributeNode) visit(aCtx));
        return el;
    }

    @Override
    public Node visitVoidElement(JinjaHtmlCssParser.VoidElementContext ctx) {
        HtmlElementNode el = new HtmlElementNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.TAG_VOID_NAME().getText(), HtmlElementNode.ElementKind.VOID);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute())
            el.getAttributes().add((HtmlAttributeNode) visit(aCtx));
        return el;
    }

    @Override
    public Node visitVoidSelfClosingElement(JinjaHtmlCssParser.VoidSelfClosingElementContext ctx) {
        HtmlElementNode el = new HtmlElementNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.TAG_VOID_NAME().getText(), HtmlElementNode.ElementKind.SELF_CLOSING);
        for (JinjaHtmlCssParser.AttributeContext aCtx : ctx.attribute())
            el.getAttributes().add((HtmlAttributeNode) visit(aCtx));
        return el;
    }

    @Override
    public Node visitNormalElement(JinjaHtmlCssParser.NormalElementContext ctx) {
        HtmlElementNode el = new HtmlElementNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.openTag.getText(), HtmlElementNode.ElementKind.NORMAL);
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
        HtmlAttributeNode attr = new HtmlAttributeNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(),
                ctx.attrName().getText());
        for (JinjaHtmlCssParser.AttributeValueContext vCtx : ctx.attributeValue()) {
            Node v = visit(vCtx);
            if (v != null) attr.getValues().add(v);
        }
        return attr;
    }

    @Override
    public Node visitAttrString(JinjaHtmlCssParser.AttrStringContext ctx) {
        String raw = ctx.TAG_STRING().getText();
        return new AttrStringNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), raw.substring(1, raw.length() - 1));
    }

    @Override public Node visitAttrIdentifier(JinjaHtmlCssParser.AttrIdentifierContext ctx) { return new AttrIdentifierNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.TAG_IDENTIFIER().getText()); }
    @Override public Node visitAttrVoidName(JinjaHtmlCssParser.AttrVoidNameContext ctx)     { return new AttrIdentifierNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.TAG_VOID_NAME().getText()); }
    @Override public Node visitAttrJinjaVar(JinjaHtmlCssParser.AttrJinjaVarContext ctx)     { return visit(ctx.jinjaVar()); }
    @Override public Node visitAttrJinjaBlock(JinjaHtmlCssParser.AttrJinjaBlockContext ctx) { return visit(ctx.jinjaBlock()); }

    // ─────────────────────────────────────────────────────────────────────────────
    //  Jinja Blocks — هنا التعديل الجوهري
    // ─────────────────────────────────────────────────────────────────────────────

    @Override
    public Node visitJinjaBlockNode(JinjaHtmlCssParser.JinjaBlockNodeContext ctx) {
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();

        // نقرأ أول keyword من الـ context مباشرة (قبل الزيارة) عبر الكاست الصح
        String firstKeyword = peekFirstKeyword(ctx.jinjaContent());

        // نصفر الـ dot flag عند بداية كل block جديد
        prevWasDot = false;

        // ─ ندير الـ scope قبل الزيارة ─
        if ("for".equals(firstKeyword)) {
            symbolTable.enterScope("for");
            blockStack.push("for");
            insideForHeader = true;
            loopVarConsumed = false;
        } else if ("endfor".equals(firstKeyword)) {
            if (!blockStack.isEmpty() && "for".equals(blockStack.peek())) {
                blockStack.pop();
                symbolTable.exitScope();
            }
        } else if ("if".equals(firstKeyword) || "elif".equals(firstKeyword)) {
            symbolTable.enterScope(firstKeyword);
            blockStack.push(firstKeyword);
        } else if ("endif".equals(firstKeyword)) {
            if (!blockStack.isEmpty()) {
                blockStack.pop();
                symbolTable.exitScope();
            }
        }

        // ─ نزور المحتوى (هنا visitJinjaIdentifier سيُستدعى) ─
        JinjaContentNode content = (JinjaContentNode) visit(ctx.jinjaContent());

        // ─ بعد انتهاء الـ for header نوقف الـ flag ─
        if ("for".equals(firstKeyword)) {
            insideForHeader = false;
            loopVarConsumed = false;
        }

        return new JinjaBlockNode(line, col, content);
    }

    @Override
    public Node visitJinjaVarNode(JinjaHtmlCssParser.JinjaVarNodeContext ctx) {
        prevWasDot = false; // نصفر عند بداية كل {{ expression }}
        JinjaContentNode content = (JinjaContentNode) visit(ctx.jinjaContent());
        return new JinjaVarNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), content);
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
        String kw = ctx.JINJA_KEYWORD().getText();
        // لما نشوف "in" داخل for-header نعرف إن loop var اتسجل وما في داعي لمتغير ثاني
        if ("in".equals(kw) && insideForHeader) {
            loopVarConsumed = true;
        }
        return new JinjaKeywordNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), kw);
    }

    @Override
    public Node visitJinjaIdentifier(JinjaHtmlCssParser.JinjaIdentifierContext ctx) {
        String name = ctx.JINJA_IDENTIFIER().getText();
        int line = ctx.getStart().getLine();
        int col  = ctx.getStart().getCharPositionInLine();

        if (prevWasDot) {
            // هذا property (مثل .name / .price / .details) — ما نسجله في الـ symbol table
            prevWasDot = false;
        } else if (insideForHeader && !loopVarConsumed) {
            // أول identifier في for-header (قبل "in") هو متغير الحلقة
            symbolTable.insert(name, "loop-variable", "Jinja");
            loopVarConsumed = true;
            prevWasDot = false;
        } else {
            // كل الـ identifiers الأخرى (iterable، expressions، خارج for header)
            symbolTable.insert(name, "jinja-usage", "Jinja");
            prevWasDot = false;
        }

        return new JinjaIdentifierNode(line, col, name);
    }

    @Override
    public Node visitJinjaDot(JinjaHtmlCssParser.JinjaDotContext ctx) {
        prevWasDot = true;  // الـ identifier الجاي بعده هو property — ما نسجله
        return new JinjaDotNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ".");
    }
    @Override public Node visitJinjaPipe(JinjaHtmlCssParser.JinjaPipeContext ctx)       { return new JinjaPipeNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "|"); }
    @Override public Node visitJinjaComma(JinjaHtmlCssParser.JinjaCommaContext ctx)     { return new JinjaCommaNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ","); }
    @Override public Node visitJinjaLParen(JinjaHtmlCssParser.JinjaLParenContext ctx)   { return new JinjaLParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "("); }
    @Override public Node visitJinjaRParen(JinjaHtmlCssParser.JinjaRParenContext ctx)   { return new JinjaRParenNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ")"); }
    @Override public Node visitJinjaLBracket(JinjaHtmlCssParser.JinjaLBracketContext ctx) { return new JinjaLBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "["); }
    @Override public Node visitJinjaRBracket(JinjaHtmlCssParser.JinjaRBracketContext ctx) { return new JinjaRBracketNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), "]"); }
    @Override public Node visitJinjaOp(JinjaHtmlCssParser.JinjaOpContext ctx)           { return new JinjaOpNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getText()); }
    @Override public Node visitJinjaNumber(JinjaHtmlCssParser.JinjaNumberContext ctx)   { return new JinjaNumberNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.JINJA_NUMBER().getText()); }

    @Override
    public Node visitJinjaString(JinjaHtmlCssParser.JinjaStringContext ctx) {
        String raw = ctx.JINJA_STRING().getText();
        return new JinjaStringNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), raw.substring(1, raw.length() - 1));
    }

    @Override public Node visitJinjaAny(JinjaHtmlCssParser.JinjaAnyContext ctx) { return new JinjaAnyNode(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), ctx.getText()); }

    // ─────────────────────────────────────────────────────────────────────────────
    //  Helper: يقرأ أول JINJA_KEYWORD من الـ content بدون زيارة كاملة
    // ─────────────────────────────────────────────────────────────────────────────

    private String peekFirstKeyword(JinjaHtmlCssParser.JinjaContentContext contentCtx) {
        if (!(contentCtx instanceof JinjaHtmlCssParser.JinjaContentNodeContext nodeCtx)) return null;
        List<JinjaHtmlCssParser.JinjaTokenContext> tokens = nodeCtx.jinjaToken();
        if (tokens == null || tokens.isEmpty()) return null;
        JinjaHtmlCssParser.JinjaTokenContext first = tokens.get(0);
        if (first instanceof JinjaHtmlCssParser.JinjaKeywordContext kw) {
            return kw.JINJA_KEYWORD().getText();
        }
        return null;
    }
}
