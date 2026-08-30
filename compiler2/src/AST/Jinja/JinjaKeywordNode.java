package AST.Jinja;

public class JinjaKeywordNode extends JinjaTokenNode {
    public JinjaKeywordNode(int line, int column, String text) {
        super(text, line, column, text);
    }
}

