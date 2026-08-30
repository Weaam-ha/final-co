package SymboleTable;

import java.util.*;

/**
 * Symbol Table مشترك للـ Backend (Python/Flask) والـ Frontend (Jinja/HTML/CSS)
 */
public class SymbolTable {

    private final Map<String, Symbol> symbols = new LinkedHashMap<>();
    private final Deque<String> scopeStack = new ArrayDeque<>();

    public SymbolTable() {
        scopeStack.push("global");
    }

    /* ========================= Scope Handling ========================= */

    public void enterScope(String scopeName) {
        scopeStack.push(scopeName);
    }

    public void exitScope() {
        if (scopeStack.size() > 1) {
            scopeStack.pop();
        }
    }

    public String currentScope() {
        return scopeStack.peek();
    }

    /* ========================= Insert ========================= */


    public void insert(String name, String type, String language) {
        String key = name + "@" + currentScope();

        if (symbols.containsKey(key)) {
            return; // لا نكرر المتغير داخل نفس السكوب
        }

        symbols.put(key, new Symbol(name, type, currentScope(), language));
    }

    /* ========================= Lookup ========================= */
    public Symbol lookup(String name) {
        for (String scope : scopeStack) {
            String key = name + "@" + scope;
            if (symbols.containsKey(key)) {
                return symbols.get(key);
            }
        }
        return null;
    }

    public Symbol lookupAnywhere(String name) {
        for (Symbol s : symbols.values()) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    /* ========================= Update ========================= */

    public boolean update(String name, String newType) {
        Symbol s = lookup(name);
        if (s == null) return false;

        s.type = newType;
        return true;
    }

    /* ========================= Delete ========================= */

    public boolean delete(String name) {
        String key = name + "@" + currentScope();
        return symbols.remove(key) != null;
    }

    /* ========================= Helpers ========================= */

    public boolean existsInCurrentScope(String name) {
        String key = name + "@" + currentScope();
        return symbols.containsKey(key);
    }

    public List<Symbol> getAllSymbolsInScope(String scope) {
        List<Symbol> result = new ArrayList<>();
        for (Symbol s : symbols.values()) {
            if (s.scope.equals(scope)) {
                result.add(s);
            }
        }
        return result;
    }

    public void clear() {
        symbols.clear();
        scopeStack.clear();
        scopeStack.push("global");
    }
    /// /****tamplet
    public boolean isTemplateVariable(String name) {
        for (Symbol s : symbols.values()) {
            if (s.getName().equals(name) && s.getType().equals("template-variable")) {
                return true;
            }
        }
        return false;
    }
    /* ========================= Printing ========================= */

    public void printSymbolTable() {
        System.out.println("\u001b[34mUnified Symbol Table:\u001b[0m");
        System.out.println("+----------------------+----------------------+----------------------+----------------+");
        System.out.println("| Name                 | Type                 | Scope                | Language       |");
        System.out.println("+----------------------+----------------------+----------------------+----------------+");

        for (Symbol s : symbols.values()) {
            System.out.printf("| %-20s | %-20s | %-20s | %-14s |\n",
                    s.name, s.type, s.scope, s.language);
        }

        System.out.println("+----------------------+----------------------+----------------------+----------------+");
    }


    /* ========================= Symbol Class ========================= */

    public static class Symbol {
        private final String name;
        private String type;
        private final String scope;
        private final String language;

        Symbol(String name, String type, String scope, String language) {
            this.name = name;
            this.type = type;
            this.scope = scope;
            this.language = language;
        }

        public void setType(String type) { this.type = type; }

        public String getName() { return name; }
        public String getType() { return type; }
        public String getScope() { return scope; }
        public String getLanguage() { return language; }
    }
}