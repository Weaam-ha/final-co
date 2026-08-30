package ast_py;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class AST_Node {

    protected int line;
    protected int column;


    protected List<AST_Node> children;

    public AST_Node(int line, int column) {
        this.line = line;
        this.column = column;
        this.children = new ArrayList<>();
    }


    public void addChild(AST_Node child) {
        if (child != null) {
            children.add(child);
        }
    }


    public void addChildren(List<? extends AST_Node> nodes) {
        if (nodes == null) return;
        for (AST_Node n : nodes) {
            addChild(n);
        }
    }


    public List<AST_Node> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}