package AST;

public abstract class Node {
    protected final String name;
    protected final int line;
    protected final int column;

    public Node(String name, int line, int column) {
        this.name = name;
        this.line = line;
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return name + " (line=" + line + ", column=" + column + ")";
    }
}
