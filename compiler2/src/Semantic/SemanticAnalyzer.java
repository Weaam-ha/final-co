package Semantic;

import AST.Node;
import AST.DocumentNode;
import AST.HTML.HtmlAttributeNode;
import AST.HTML.HtmlElementNode;
import AST.Jinja.*;
import SymboleTable.SymbolTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemanticAnalyzer {

    private final Node root;
    private final SymbolTable symbolTable;
    private final List<SemanticError> errors = new ArrayList<>();
    private final Set<String> definedVars = new HashSet<>();
    private final Set<String> globalUniqueTags = new HashSet<>();

    // مصفوفات لتخزين أسطر البداية والنهاية لكل حلقات الـ for في الملف
    private final List<Integer> forStartLines = new ArrayList<>();
    private final List<Integer> forEndLines = new ArrayList<>();

    public SemanticAnalyzer(Node root, SymbolTable symbolTable) {
        this.root = root;
        this.symbolTable = symbolTable;
    }

    public void analyze() {
        definedVars.clear();
        globalUniqueTags.clear();
        errors.clear();
        forStartLines.clear();
        forEndLines.clear();

        // 1. خريطة أولية لجمع المتغيرات وتحديد أسطر الـ for بدقة
        mapTemplateStructures(root);

        // 2. الفحص السيمانتيكي الفعلي
        performSemanticCheck(root);
    }

    //  دالة تجمع المتغيرات وتحدد بدقة مجال كل FOR بالأسطر
    private void mapTemplateStructures(Node node) {
        if (node == null) return;

        if (node instanceof JinjaBlockNode) {
            JinjaContentNode content = ((JinjaBlockNode) node).getContent();
            List<Node> tokens = content.getTokens();
            if (!tokens.isEmpty() && tokens.get(0) instanceof JinjaKeywordNode) {
                String key = ((JinjaKeywordNode) tokens.get(0)).getText();

                if (key.equals("for")) {
                    forStartLines.add(node.getLine()); // سجل سطر البداية

                    for (int i = 1; i < tokens.size(); i++) {
                        if (tokens.get(i) instanceof JinjaKeywordNode
                                && ((JinjaKeywordNode) tokens.get(i)).getText().equals("in")) {
                            if (i - 1 >= 1 && tokens.get(i - 1) instanceof JinjaIdentifierNode) {
                                definedVars.add(((JinjaIdentifierNode) tokens.get(i - 1)).getName());
                            }
                        }
                    }
                } else if (key.equals("endfor")) {
                    forEndLines.add(node.getLine()); // سجل سطر النهاية
                }
            }
        }

        if (node instanceof DocumentNode) {
            for (Node c : ((DocumentNode) node).getChildren()) mapTemplateStructures(c);
        } else if (node instanceof HtmlElementNode) {
            for (HtmlAttributeNode a : ((HtmlElementNode) node).getAttributes()) mapTemplateStructures(a);
            for (Node c : ((HtmlElementNode) node).getChildren()) mapTemplateStructures(c);
        } else if (node instanceof HtmlAttributeNode) {
            for (Node v : ((HtmlAttributeNode) node).getValues()) mapTemplateStructures(v);
        }
    }

    //  دالة مسابقة تفحص لو السطر الحالي يقع داخل أي حلقة for معلنة
    private boolean isLineInsideAnyFor(int line) {
        // إذا كان هناك عدد غير متوافق من for و endfor، نعتمد على المتاح
        int size = Math.min(forStartLines.size(), forEndLines.size());
        for (int i = 0; i < size; i++) {
            if (line >= forStartLines.get(i) && line <= forEndLines.get(i)) {
                return true; // السطر يقع داخل نطاق الـ for
            }
        }
        return false;
    }

    //  دالة مساعدة إضافية للتحقق من صحة نطاق المتغير المحلي لمنع الـ Scope Error
    private boolean isVariableInValidScope(String name, int line) {
        int size = Math.min(forStartLines.size(), forEndLines.size());
        boolean insideAtLeastOne = false;

        for (int i = 0; i < size; i++) {
            // إذا كان السطر يقع داخل نطاق هذه الحلقة بالذات
            if (line >= forStartLines.get(i) && line <= forEndLines.get(i)) {
                insideAtLeastOne = true;
                break; // وجدنا النطاق الصحيح له، لا داعي لإكمال الفحص
            }
        }

        return insideAtLeastOne; // سيعيد true لو كان داخل النطاق، و false لو كان خارج كل الحلقات
    }

    private void performSemanticCheck(Node node) {
        if (node == null) return;

        if (node instanceof DocumentNode) {
            for (Node c : ((DocumentNode) node).getChildren()) performSemanticCheck(c);

        } else if (node instanceof JinjaBlockNode) {
            handleJinjaBlock((JinjaBlockNode) node);

        } else if (node instanceof JinjaVarNode) {
            inferAndCheckType(((JinjaVarNode) node).getContent());

        } else if (node instanceof HtmlElementNode) {
            HtmlElementNode el = (HtmlElementNode) node;
            String tagName = el.getTagName().toLowerCase();

            if (tagName.equals("html") || tagName.equals("head") || tagName.equals("body")) {
                if (globalUniqueTags.contains(tagName)) {
                    addError("Duplicate Tag",
                            "Duplicate critical HTML tag found: <" + tagName + "> can only appear once.",
                            el.getLine());
                } else {
                    globalUniqueTags.add(tagName);
                }
            }

            Set<String> seenAttributes = new HashSet<>();
            for (HtmlAttributeNode a : el.getAttributes()) {
                String attrName = a.getName();
                if (seenAttributes.contains(attrName)) {
                    addError("Duplicate Attribute",
                            "Attribute '" + attrName + "' is duplicated in element <" + el.getTagName() + ">.",
                            a.getLine());
                } else {
                    seenAttributes.add(attrName);
                }
                performSemanticCheck(a);
            }

            for (Node c : el.getChildren()) performSemanticCheck(c);

        } else if (node instanceof HtmlAttributeNode) {
            for (Node v : ((HtmlAttributeNode) node).getValues()) performSemanticCheck(v);
        }
    }

    private JType inferAndCheckType(JinjaContentNode content) {
        List<Node> tokens = content.getTokens();
        JType lastType = JType.UNKNOWN;

        for (int i = 0; i < tokens.size(); i++) {
            Node t = tokens.get(i);
            JType currentType = JType.UNKNOWN;

            if (t instanceof JinjaNumberNode) {
                currentType = JType.NUMBER;
            } else if (t instanceof JinjaStringNode) {
                currentType = JType.STRING;
            } else if (t instanceof JinjaIdentifierNode) {
                String varName = ((JinjaIdentifierNode) t).getName();

                //  الفحص الصارم القائم على أرقام الأسطر:
                if (varName.equals("loop") || varName.startsWith("loop.")) {
                    if (!isLineInsideAnyFor(t.getLine())) { // لو السطر برات الـ for
                        addError("Loop Outside For",
                                "'loop' variable is used outside a 'for' loop.",
                                t.getLine());
                    }
                } else {
                    boolean isProperty = (i > 0 && tokens.get(i - 1) instanceof JinjaDotNode);
                    if (!isProperty) {
                        checkFlaskVariable(varName, t.getLine());
                    }
                }
                currentType = JType.UNKNOWN;
            }

            if (i > 0) {
                String op = null;
                Node prev = tokens.get(i - 1);
                if (prev instanceof JinjaTokenNode) op = ((JinjaTokenNode) prev).getText();
                else if (prev instanceof JinjaOpNode) op = prev.getName();

                if (op != null && (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))) {
                    if (lastType != JType.UNKNOWN && currentType != JType.UNKNOWN && lastType != currentType) {
                        addError("Type mismatch",
                                "Cannot perform operation '" + op +
                                        "' between " + lastType + " and " + currentType + ".",
                                t.getLine());
                    }
                }
            }

            if (currentType != JType.UNKNOWN) lastType = currentType;
        }

        return lastType;
    }

    private void checkFlaskVariable(String name, int line) {
        //  إضافة فحص الـ Scope Error هنا: إذا كان المتغير محلياً للـ for ولكن تم استدعاؤه خارج النطاق المسموح بالأسطر
        if (definedVars.contains(name)) {
            if (!isVariableInValidScope(name, line)) {
                addError("Scope Error", "Variable '" + name + "' is out of scope (defined inside a loop).", line);
            }
            return;
        }

        if (symbolTable.isTemplateVariable(name)) return;

        SymbolTable.Symbol sym = symbolTable.lookup(name);

        if (sym == null) {
            addError("Undefined variable", "Variable '" + name + "' is not defined.", line);
        } else if (sym.getType().equals("jinja-usage")) {
            addError("Undefined variable", "Variable '" + name + "' is not defined.", line);
        } else {
            addError("Missing Flask Variable", "Variable '" + name + "' is used in template but never passed via render_template.", line);
        }
    }

    private void handleJinjaBlock(JinjaBlockNode jb) {
        List<Node> tokens = jb.getContent().getTokens();
        if (tokens.isEmpty()) return;

        Node first = tokens.get(0);
        if (!(first instanceof JinjaKeywordNode)) return;

        String key = ((JinjaKeywordNode) first).getText();

        switch (key) {
            case "for": {
                symbolTable.enterScope("for");
                if (tokens.size() >= 2 && tokens.get(1) instanceof JinjaIdentifierNode) {
                    symbolTable.insert(((JinjaIdentifierNode) tokens.get(1)).getName(), "loop-variable", "Jinja");
                }

                int inIndex = -1;
                for (int i = 0; i < tokens.size(); i++) {
                    if (tokens.get(i) instanceof JinjaKeywordNode && ((JinjaKeywordNode) tokens.get(i)).getText().equals("in")) {
                        inIndex = i;
                        break;
                    }
                }

                //  تعديل الـ Type Error ليطابق الـ PDF تماماً عند التكرار على قيم غير قابلة للتكرار (مثل int)
                if (inIndex != -1 && inIndex + 1 < tokens.size()) {
                    Node iterableNode = tokens.get(inIndex + 1);

                    if (iterableNode instanceof JinjaNumberNode) {
                        addError("Type Error", "'int' object is not iterable", iterableNode.getLine());
                    } else if (iterableNode instanceof JinjaIdentifierNode) {
                        String iterableName = ((JinjaIdentifierNode) iterableNode).getName();

                        SymbolTable.Symbol sym = symbolTable.lookup(iterableName);
                        if (sym != null && (sym.getType().equalsIgnoreCase("int") || sym.getType().equalsIgnoreCase("NUMBER"))) {
                            addError("Type Error", "'int' object is not iterable", iterableNode.getLine());
                        } else {
                            checkFlaskVariable(iterableName, iterableNode.getLine());
                        }
                    }
                }
                break;
            }
            case "endfor":
                symbolTable.exitScope();
                break;

            case "if": {
                symbolTable.enterScope("if");
                for (Node t : tokens) {
                    if (t instanceof JinjaIdentifierNode) {
                        checkFlaskVariable(((JinjaIdentifierNode) t).getName(), t.getLine());
                    }
                }
                break;
            }
            case "endif":
                symbolTable.exitScope();
                break;
        }
    }

    private void addError(String name, String details, int line) {
        for (SemanticError e : errors) {
            if (e.getName().equals(name) && e.getLine() == line && e.getDetails().equals(details)) return;
        }
        errors.add(new SemanticError(name, details, line));
    }

    public List<SemanticError> getErrors() {
        return errors;
    }

    public void printErrors() {
        if (errors.isEmpty()) {
            System.out.println("\u001b[32mNo Semantic Errors found.\u001b[0m");
            return;
        }
        System.out.println("\u001b[31mSemantic Errors Found:\u001b[0m");
        System.out.println("+------------------------+---------+------------------------------------------------------------+");
        System.out.println("| Error Name             | Line    | Details                                                    |");
        System.out.println("+------------------------+---------+------------------------------------------------------------+");
        for (SemanticError e : errors) {
            System.out.printf("| %-22s | %-7d | %-58s |\n", e.getName(), e.getLine(), e.getDetails());
        }
        System.out.println("+------------------------+---------+------------------------------------------------------------+");
    }
}