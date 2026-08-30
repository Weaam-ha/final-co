package Semantic;

public class SemanticError {
    private final String name;
    private final String details;
    private final int line;

    public SemanticError(String name, String details, int line) {
        this.name = name;
        this.details = details;
        this.line = line;
    }

    public String getName()   { return name; }
    public String getDetails(){ return details; }
    public int getLine()      { return line; }
}
