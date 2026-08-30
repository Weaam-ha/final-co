package AST;

import AST.CSS.*;
import AST.HTML.*;
import AST.Jinja.*;

public class ASTPrinter {

    public static void printTree(Node node) {
        printTree(node, 0);
    }

    private static void printTree(Node node, int indent) {
        if (node == null) return;

        String pad = buildPad(indent);

        // ========== DocumentNode ==========
        if (node instanceof DocumentNode) {
            DocumentNode doc = (DocumentNode) node;
            System.out.println(pad + "- DocumentNode (line=" + doc.getLine() + ", col=" + doc.getColumn() + ")");
            for (Node child : doc.getChildren()) {
                printTree(child, indent + 1);
            }
        }

        // ========== HtmlElementNode ==========
        else if (node instanceof HtmlElementNode) {
            HtmlElementNode el = (HtmlElementNode) node;
            System.out.println(pad + "- HtmlElementNode (line=" + el.getLine() + ", col=" + el.getColumn() + "): <" + el.getTagName() + ">");

            // طباعة الاتربيوت
            for (HtmlAttributeNode attr : el.getAttributes()) {
                printTree(attr, indent + 1);
            }

            // طباعة الأبناء
            for (Node child : el.getChildren()) {
                printTree(child, indent + 1);
            }

            // طباعة closing tag للـ NormalElement
            if (el.getKind() == HtmlElementNode.ElementKind.NORMAL && el.hasClosingTag()) {
                System.out.println(pad + "- </" + el.getTagName() + ">");
            }
        }

        // ========== HtmlTextNode ==========
        else if (node instanceof HtmlTextNode) {
            HtmlTextNode text = (HtmlTextNode) node;
            String t = text.getText().trim();
            if (!t.isEmpty()) {
                System.out.println(pad + "- HtmlTextNode (line=" + text.getLine() + ", col=" + text.getColumn() + "): \"" + t + "\"");
            }
        }

        // ========== HtmlAttributeNode ==========
        else if (node instanceof HtmlAttributeNode) {
            HtmlAttributeNode attr = (HtmlAttributeNode) node;
            System.out.println(pad + "- AttributeNode (line=" + attr.getLine() + ", col=" + attr.getColumn() + "): " + attr.getName());
            for (Node v : attr.getValues()) {
                printTree(v, indent + 1);
            }
        }

        // ========== AttrStringNode ==========
        else if (node instanceof AttrStringNode) {
            AttrStringNode str = (AttrStringNode) node;
            String v = stripQuotes(str.getValue());
            System.out.println(pad + "- AttrString (line=" + str.getLine() + ", col=" + str.getColumn() + "): \"" + v + "\"");
        }

        // ========== AttrIdentifierNode ==========
        else if (node instanceof AttrIdentifierNode) {
            AttrIdentifierNode id = (AttrIdentifierNode) node;
            System.out.println(pad + "- AttrIdentifier (line=" + id.getLine() + ", col=" + id.getColumn() + "): " + id.getValue());
        }

        // ========== StyleBlockNode ==========
        else if (node instanceof StyleBlockNode) {
            StyleBlockNode sb = (StyleBlockNode) node;
            System.out.println(pad + "- StyleBlockNode (line=" + sb.getLine() + ", col=" + sb.getColumn() + "): <style>");
            if (sb.getCssContent() != null) {
                printTree(sb.getCssContent(), indent + 1);
            }
            System.out.println(pad + "- </style>");
        }





        // ========== CssContentNode ==========
        else if (node instanceof CssContentNode) {
            CssContentNode css = (CssContentNode) node;
            System.out.println(pad + "- CssContentNode (line=" + css.getLine() + ", col=" + css.getColumn() + ")");
            for (Node t : css.getTokens()) {
                printTree(t, indent + 1);
            }
        }

        // ========== CSS Tokens ==========
        else if (node instanceof CssLBraceNode) {
            System.out.println(pad + "- CssLBrace (line=" + node.getLine() + ", col=" + node.getColumn() + "): {");
        }
        else if (node instanceof CssRBraceNode) {
            System.out.println(pad + "- CssRBrace (line=" + node.getLine() + ", col=" + node.getColumn() + "): }");
        }
        else if (node instanceof CssColonNode) {
            System.out.println(pad + "- CssColon (line=" + node.getLine() + ", col=" + node.getColumn() + "): :");
        }
        else if (node instanceof CssSemiNode) {
            System.out.println(pad + "- CssSemi (line=" + node.getLine() + ", col=" + node.getColumn() + "): ;");
        }
        else if (node instanceof CssUnitNode) {
            System.out.println(pad + "- CssUnit (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + ((CssUnitNode) node).getText());
        }
        else if (node instanceof CssStringNode) {
            System.out.println(pad + "- CssString (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + ((CssStringNode) node).getText());
        }
        else if (node instanceof CssIdentifierNode) {
            System.out.println(pad + "- CssIdentifier (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + ((CssIdentifierNode) node).getText());
        }
        else if (node instanceof CssNumberNode) {
            System.out.println(pad + "- CssNumber (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + ((CssNumberNode) node).getText());
        }

        // ========== JinjaVarNode ==========
        else if (node instanceof JinjaVarNode) {
            JinjaVarNode var = (JinjaVarNode) node;
            System.out.println(pad + "- JinjaVarNode (line=" + var.getLine() + ", col=" + var.getColumn() + "): {{ ... }}");
            if (var.getContent() != null) {
                printTree(var.getContent(), indent + 1);
            }
        }

        // ========== JinjaBlockNode ==========
        else if (node instanceof JinjaBlockNode) {
            JinjaBlockNode blk = (JinjaBlockNode) node;
            System.out.println(pad + "- JinjaBlockNode (line=" + blk.getLine() + ", col=" + blk.getColumn() + "): {% ... %}");
            if (blk.getContent() != null) {
                printTree(blk.getContent(), indent + 1);
            }
        }

        // ========== JinjaContentNode ==========
        else if (node instanceof JinjaContentNode) {
            JinjaContentNode j = (JinjaContentNode) node;
            System.out.println(pad + "- JinjaContentNode (line=" + j.getLine() + ", col=" + j.getColumn() + ")");
            for (Node t : j.getTokens()) {
                printTree(t, indent + 1);
            }
        }

        // ========== Jinja Tokens ==========
        else if (node instanceof JinjaKeywordNode) {
            System.out.println(pad + "- JinjaKeyword (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }
        else if (node instanceof JinjaIdentifierNode) {
            System.out.println(pad + "- JinjaIdentifier (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }
        else if (node instanceof JinjaDotNode) {
            System.out.println(pad + "- JinjaDot (line=" + node.getLine() + ", col=" + node.getColumn() + "): .");
        }
        else if (node instanceof JinjaPipeNode) {
            System.out.println(pad + "- JinjaPipe (line=" + node.getLine() + ", col=" + node.getColumn() + "): |");
        }
        else if (node instanceof JinjaCommaNode) {
            System.out.println(pad + "- JinjaComma (line=" + node.getLine() + ", col=" + node.getColumn() + "): ,");
        }
        else if (node instanceof JinjaLParenNode) {
            System.out.println(pad + "- JinjaLParen (line=" + node.getLine() + ", col=" + node.getColumn() + "): (");
        }
        else if (node instanceof JinjaRParenNode) {
            System.out.println(pad + "- JinjaRParen (line=" + node.getLine() + ", col=" + node.getColumn() + "): )");
        }
        else if (node instanceof JinjaLBracketNode) {
            System.out.println(pad + "- JinjaLBracket (line=" + node.getLine() + ", col=" + node.getColumn() + "): [");
        }
        else if (node instanceof JinjaRBracketNode) {
            System.out.println(pad + "- JinjaRBracket (line=" + node.getLine() + ", col=" + node.getColumn() + "): ]");
        }
        else if (node instanceof JinjaOpNode) {
            System.out.println(pad + "- JinjaOp (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }
        else if (node instanceof JinjaNumberNode) {
            System.out.println(pad + "- JinjaNumber (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }
        else if (node instanceof JinjaStringNode) {
            System.out.println(pad + "- JinjaString (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }
        else if (node instanceof JinjaAnyNode) {
            System.out.println(pad + "- JinjaAny (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }

        // ========== Fallback ==========
        else {
            System.out.println(pad + "- " + node.getClass().getSimpleName() + " (line=" + node.getLine() + ", col=" + node.getColumn() + "): " + node.getName());
        }
    }

    private static String buildPad(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) sb.append("  ");
        return sb.toString();
    }

    private static String stripQuotes(String v) {
        if (v == null || v.length() < 2) return v;
        if ((v.startsWith("\"") && v.endsWith("\"")) ||
                (v.startsWith("'") && v.endsWith("'"))) {
            return v.substring(1, v.length() - 1);
        }
        return v;
    }
}