package AST.Jinja;

public class JinjaIdentifierNode extends JinjaTokenNode {

    public JinjaIdentifierNode(int line, int column, String text) {
        super("JinjaIdentifierNode", line, column, text);
    }

    public String getName() {
        return getText();   // هون الحل السحري
    }
}
