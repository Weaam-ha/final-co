package AST.Jinja;

public class JinjaStringNode extends JinjaTokenNode {
    public JinjaStringNode(int line, int column, String text) {
        super("JinjaStringNode", line, column, text);
    }
}
