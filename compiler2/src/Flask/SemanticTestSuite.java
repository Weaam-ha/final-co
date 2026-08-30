package Flask;

import Semantic.FlaskSemanticAnalyzer;
import Semantic.SemanticError;
import SymboleTable.SymbolTable;
import Visitor_Flask.AstBuilder;
import ast_py.ProgramNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class SemanticTestSuite {

    private record Expected(String caseName, String errorType, String messageContains) {}

    private static final Expected[] EXPECTED = {
            new Expected("tc1  string + number",        "Type Mismatch",     "+: 'str' and 'number'"),
            new Expected("tc2  list * list",             "Type Mismatch",     "*: 'list' and 'list'"),
            new Expected("tc3  string < number",         "Type Mismatch",     "not supported between instances of 'str' and 'number'"),
            new Expected("tc4  for over number",         "Type Error",        "'number' object is not iterable"),
            new Expected("tc5  index into number",       "Type Error",        "'number' object is not subscriptable"),
            new Expected("tc6  call a number",           "Type Error",        "'number' object is not callable"),
            new Expected("tc7  len(number)",             "Type Error",        "object of type 'number' has no len()"),
            new Expected("tc8  int(list)",                "Type Error",        "int() argument must be a string or a number, not 'list'"),
            new Expected("tc9  list(number)",             "Type Error",        "'number' object is not iterable"),
            new Expected("tc10 dict(number)",             "Type Error",        "dict() argument must be a sequence of key-value pairs, not 'number'"),
            new Expected("tc11 abs(string)",              "Type Error",        "bad operand type for abs(): 'string'"),
            new Expected("tc17 x += \"hello\" (x=number)","Type Mismatch",     "+: 'number' and 'str'"),
            new Expected("tc19 lst *= \"oops\" (list)",   "Type Mismatch",     "*: 'list' and 'string'"),
            new Expected("scope: scoped_only_var",        "Scope Error",       "scoped_only_var"),
            new Expected("undefined: never_defined_anywhere", "Undefined Variable", "never_defined_anywhere"),
    };

    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromFileName("compiler2/semantic_test.txt");
        FlaskPythonLexer lexer = new FlaskPythonLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(new IndentAwareTokenSource(lexer));
        FlaskPythonParser parser = new FlaskPythonParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> r, Object o, int line, int col, String msg, RecognitionException e) {
                throw new RuntimeException("Syntax error at " + line + ":" + col + " — " + msg);
            }
        });

        ParseTree tree = parser.program();

        SymbolTable table = new SymbolTable();
        AstBuilder builder = new AstBuilder(table);
        ProgramNode ast = (ProgramNode) builder.visit(tree);

        FlaskSemanticAnalyzer analyzer = new FlaskSemanticAnalyzer(ast, table);
        analyzer.analyze();
        List<SemanticError> actual = analyzer.getErrors();

        System.out.println("=== Full error list from analyzer ===");
        analyzer.printErrors();

        System.out.println();
        System.out.println("=== Expected vs Actual (ordered) ===");
        System.out.printf("%-40s %-22s %-10s%n", "CASE", "EXPECTED TYPE", "RESULT");
        System.out.println("-".repeat(80));

        int passCount = 0;
        for (int i = 0; i < EXPECTED.length; i++) {
            Expected exp = EXPECTED[i];
            boolean pass;
            String actualDesc;

            if (i >= actual.size()) {
                pass = false;
                actualDesc = "MISSING (no error produced)";
            } else {
                SemanticError got = actual.get(i);
                boolean typeMatch = got.getName().equals(exp.errorType());
                boolean msgMatch = got.getDetails().contains(exp.messageContains());
                pass = typeMatch && msgMatch;
                actualDesc = got.getName() + " — " + got.getDetails();
            }

            System.out.printf("%-40s %-22s %-10s%n", exp.caseName(), exp.errorType(), pass ? "PASS" : "FAIL");
            if (!pass) {
                System.out.println("    expected: " + exp.errorType() + " containing \"" + exp.messageContains() + "\"");
                System.out.println("    actual:   " + actualDesc);
            }
            if (pass) passCount++;
        }

        System.out.println();
        System.out.println("Expected error count: " + EXPECTED.length);
        System.out.println("Actual error count:   " + actual.size());
        if (actual.size() > EXPECTED.length) {
            System.out.println("EXTRA ERRORS DETECTED beyond what was expected:");
            for (int i = EXPECTED.length; i < actual.size(); i++) {
                SemanticError extra = actual.get(i);
                System.out.println("    " + extra.getName() + " — " + extra.getDetails() + " (line " + extra.getLine() + ")");
            }
        }

        System.out.println();
        System.out.println(passCount == EXPECTED.length && actual.size() == EXPECTED.length
                ? "✔ ALL " + EXPECTED.length + " CASES PASSED, no extra/missing errors."
                : "✘ " + (EXPECTED.length - passCount) + " case(s) failed — see above.");
    }
}