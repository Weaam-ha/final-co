package SymboleTable;

public class Symbol {
    public String name;
    public String type;
    public int line;
    public int column;

    public Symbol(String name, String type, int line, int column) {
        this.name = name;
        this.type = type;
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Symbol{name='" + name + "', type='" + type +
                "', line=" + line + ", col=" + column + "}";
    }
}