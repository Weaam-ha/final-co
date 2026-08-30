package AST.Jinja;

public class JinjaNumberNode extends JinjaTokenNode {
    public JinjaNumberNode(int line, int column, String text) {
        super(text, line, column, text);
    }
}

