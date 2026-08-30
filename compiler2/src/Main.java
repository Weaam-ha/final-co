import AST.ASTPrinter;
import AST.Node;
import AST.Visitor;

import Flask.FlaskPythonLexer;
import Flask.FlaskPythonParser;
import Flask.IndentAwareTokenSource;
import Visitor_Flask.AstBuilder;

import ast_py.ProgramNode;

import generator.FrontendCodeGenerator;
import generator.PythonCodeGenerator;
import generator.StaticTemplateRenderer;
import generator.StaticFrontendBehavior;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import printer.ASTPrinterr;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import antlr.JinjaHtmlCssLexer;
import antlr.JinjaHtmlCssParser;

import SymboleTable.SymbolTable;
import Semantic.SemanticAnalyzer;
import Semantic.FlaskSemanticAnalyzer;
import Semantic.SemanticError;

public class Main {

    /** Collects syntax errors instead of only logging them, so Main can
     *  display a clear section and decide whether it's safe to proceed
     *  to AST building for that side. */
    private static class CollectingErrorListener extends BaseErrorListener {
        private final List<String> messages = new ArrayList<>();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine, String msg, RecognitionException e) {
            messages.add("line " + line + ":" + charPositionInLine + " " + msg);
        }

        boolean hasErrors() { return !messages.isEmpty(); }
        List<String> getMessages() { return messages; }
    }

    public static void compileOnce() throws IOException {

        // ==========================================================
        // 1) إنشاء SymbolTable واحد مشترك ونظيف
        // ==========================================================
        SymbolTable table = new SymbolTable();

        boolean flaskParsedOk = false;
        ProgramNode pyAst = null;
        FlaskSemanticAnalyzer flaskSA = null;

        // ==========================================================
        // 2) BACKEND FIRST (Python/Flask) لكي يشحن الجدول بالمتغيرات
        // ==========================================================
        String pythonFile = "compiler2/flask_app.txt";
        File pyFile = new File(pythonFile);
        if (!pyFile.exists()) {
            System.out.println("File not found: " + pythonFile);
            return;
        }

        CharStream pyInput = CharStreams.fromFileName(pythonFile);
        FlaskPythonLexer pyLexer = new FlaskPythonLexer(pyInput);


        CommonTokenStream pyTokens = new CommonTokenStream(new IndentAwareTokenSource(pyLexer));
        FlaskPythonParser pyParser = new FlaskPythonParser(pyTokens);

        CollectingErrorListener pyErrors = new CollectingErrorListener();
        pyParser.removeErrorListeners();
        pyParser.addErrorListener(pyErrors);

        ParseTree pyTree = pyParser.program();

        System.out.println("\n=================================");
        System.out.println("        PARSE TREE (Pretty)       ");
        System.out.println("=================================");
        printTree(pyTree, pyParser, 0);

        System.out.println("\n=================================");
        System.out.println("   FLASK/PYTHON SYNTAX ERRORS     ");
        System.out.println("=================================");
        if (pyErrors.hasErrors()) {
            for (String m : pyErrors.getMessages()) System.out.println("  " + m);
        } else {
            System.out.println("\u001b[32m✓ No syntax/indentation errors.\u001b[0m");
        }

        if (!pyErrors.hasErrors()) {
            // تمرير الـ SymbolTable للـ AstBuilder تبع الباك
            AstBuilder builder = new AstBuilder(table);
            pyAst = (ProgramNode) builder.visit(pyTree);
            flaskParsedOk = true;

            System.out.println("\n=================================");
            System.out.println("               AST (Backend)     ");
            System.out.println("=================================");
            ASTPrinterr.print(pyAst);

            // ==========================================================
            // 2.1) FLASK SEMANTIC ANALYSIS
            // ==========================================================
            System.out.println("\n=================================");
            System.out.println("       FLASK SEMANTIC ANALYSIS     ");
            System.out.println("=================================");

            flaskSA = new FlaskSemanticAnalyzer(pyAst, table);
            flaskSA.analyze();
            flaskSA.printErrors();

            // ==========================================================
            // 2.5) PYTHON CODE GENERATION (Backend)
            // ==========================================================
            System.out.println("\n=================================");
            System.out.println("     PYTHON CODE GENERATION     ");
            System.out.println("=================================");

            try {
                PythonCodeGenerator pyGen = new PythonCodeGenerator();
                pyGen.generate(pyAst);

                String pythonOutput = pyGen.getGeneratedCode();

                java.nio.file.Files.createDirectories(java.nio.file.Path.of("output"));
                java.nio.file.Files.writeString(
                        java.nio.file.Path.of("output/app.py"),
                        pythonOutput
                );

                System.out.println("✔ Python code generated: output/app.py");
                System.out.println("✔ الملف موجود داخل مجلد: output/");

            } catch (java.io.IOException e) {
                System.err.println("Error writing Python file: " + e.getMessage());
            }
        } else {
            System.out.println("\n\u001b[31mSkipping AST building and Semantic Analysis for Flask/Python side due to syntax errors above.\u001b[0m");
        }

        // ==========================================================
        // 3) FRONTEND SECOND (Jinja) يضيف بياناته فوق بيانات الباك
        // ==========================================================
        //تيست الاخطاء
       // String frontFile = "compiler2/front-semantic.txt";
       String frontFile = "compiler2/front_test.txt";
        File file = new File(frontFile);
        if (!file.exists()) {
            System.out.println("File not found: " + frontFile);
            return;
        }

        CharStream frontInput = CharStreams.fromFileName(frontFile);
        JinjaHtmlCssLexer frontLexer = new JinjaHtmlCssLexer(frontInput);
        CommonTokenStream frontTokens = new CommonTokenStream(frontLexer);
        JinjaHtmlCssParser frontParser = new JinjaHtmlCssParser(frontTokens);

        CollectingErrorListener frontErrors = new CollectingErrorListener();
        frontParser.removeErrorListeners();
        frontParser.addErrorListener(frontErrors);

        ParseTree frontTree = frontParser.document();

        System.out.println("\n=================================");
        System.out.println("       JINJA/HTML SYNTAX ERRORS   ");
        System.out.println("=================================");
        if (frontErrors.hasErrors()) {
            for (String m : frontErrors.getMessages()) System.out.println("  " + m);
        } else {
            System.out.println("\u001b[32m✓ No syntax errors.\u001b[0m");
        }

        Node frontAst = null;
        SemanticAnalyzer sa = null;

        if (!frontErrors.hasErrors()) {
            Visitor visitor = new Visitor(table);
            frontAst = visitor.visit(frontTree);

            System.out.println("\n=== AST Tree (Front) ===");
            ASTPrinter.printTree(frontAst);

            // ==========================================================
            // 4) طباعة الـ SymbolTable الموحد النهائي والتحليل الدلالي
            // ==========================================================
            System.out.println("\n=================================");
            System.out.println("     SYMBOL TABLE (Final)        ");
            System.out.println("=================================");
            table.printSymbolTable();

            System.out.println("\n=================================");
            System.out.println("      FRONT SEMANTIC ANALYSIS         ");
            System.out.println("=================================");

            sa = new SemanticAnalyzer(frontAst, table);
            sa.analyze();
            sa.printErrors();

            // ==========================================================
            // 5) FRONTEND CODE GENERATION (HTML + CSS)
            // ==========================================================
            System.out.println("\n=================================");
            System.out.println("     FRONTEND CODE GENERATION    ");
            System.out.println("=================================");

            FrontendCodeGenerator gen = new FrontendCodeGenerator();



            List<Node> frontList = new ArrayList<>();
            frontList.add(frontAst);
            gen.generate(frontList);

            String jinjaTemplate = gen.getHTML();
            String cssOutput = gen.getCSS();

            Map<String, Object> context = StaticTemplateRenderer.extractContext(
                    Path.of(pythonFile)
            );
            String htmlOutput = StaticTemplateRenderer.render(jinjaTemplate, context);
            htmlOutput = prepareInteractiveStaticHtml(htmlOutput);
            htmlOutput = addStaticStylesheetLink(htmlOutput, !cssOutput.isBlank());
            htmlOutput = addStaticScriptLink(htmlOutput);
            String scriptOutput = StaticFrontendBehavior.generate(context);
            cssOutput += "\n/* Browser-only interaction for static output */\n"
                    + ".product-item { cursor: pointer; }\n"
                    + ".product-item:focus { outline: 2px solid var(--leaf); outline-offset: 3px; }\n";

            //Files.createDirectories(Path.of("output/templates"));
           // Files.createDirectories(Path.of("output/static"));
            Files.writeString(Path.of("output/index.html"), htmlOutput);
           // Files.writeString(Path.of("output/templates/products.html"), htmlOutput);
            Files.writeString(Path.of("output/style.css"), cssOutput);
           // Files.writeString(Path.of("output/static/style.css"), cssOutput);
            Files.writeString(Path.of("output/script.js"), scriptOutput);
            Files.copy(Path.of(pythonFile), Path.of("output/app.py"),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            writeGenerationArtifacts(pyTree, frontTree, context, htmlOutput, cssOutput);

            System.out.println("\n✔✔ تم توليد HTML ثابت + CSS بنجاح!");
            System.out.println("✔ الملفات موجودة داخل مجلد: output/");
        } else {
            System.out.println("\n\u001b[31mSkipping AST building and Semantic Analysis for Jinja/Frontend side due to syntax errors above.\u001b[0m");
            System.out.println("\n=================================");
            System.out.println("     SYMBOL TABLE (Flask-only)   ");
            System.out.println("=================================");
            table.printSymbolTable();
        }

        // ==========================================================
        // 6) compiler_output/semantic_report.txt
        // ==========================================================
        writeSemanticReport(pyErrors, flaskParsedOk ? flaskSA : null, frontErrors, sa);

        System.out.println("=================================\n");
    }

    private static void writeSemanticReport(CollectingErrorListener pyErrors,
                                            FlaskSemanticAnalyzer flaskSA,
                                            CollectingErrorListener frontErrors,
                                            SemanticAnalyzer sa) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Flask/Python Syntax Errors ===\n");
        if (pyErrors.hasErrors()) {
            for (String m : pyErrors.getMessages()) sb.append("  ").append(m).append("\n");
        } else {
            sb.append("  (none)\n");
        }

        sb.append("\n=== Flask/Python Semantic Errors ===\n");
        if (flaskSA == null) {
            sb.append("  (skipped due to syntax errors)\n");
        } else if (flaskSA.getErrors().isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (SemanticError e : flaskSA.getErrors()) {
                sb.append("  ").append(e.getName())
                        .append(" | line ").append(e.getLine())
                        .append(" | ").append(e.getDetails()).append("\n");
            }
        }

        sb.append("\n=== Jinja/Frontend Syntax Errors ===\n");
        if (frontErrors.hasErrors()) {
            for (String m : frontErrors.getMessages()) sb.append("  ").append(m).append("\n");
        } else {
            sb.append("  (none)\n");
        }

        sb.append("\n=== Jinja/Frontend Semantic Errors ===\n");
        if (sa == null) {
            sb.append("  (skipped due to syntax errors)\n");
        } else if (sa.getErrors().isEmpty()) {
            sb.append("  (none)\n");
        } else {
            for (Semantic.SemanticError e : sa.getErrors()) {
                sb.append("  ").append(e.getName())
                        .append(" | line ").append(e.getLine())
                        .append(" | ").append(e.getDetails()).append("\n");
            }
        }

        java.nio.file.Files.createDirectories(java.nio.file.Path.of("compiler_output"));
        java.nio.file.Files.writeString(java.nio.file.Path.of("compiler_output/semantic_report.txt"), sb.toString());

        System.out.println("\n✔ Semantic report written: compiler_output/semantic_report.txt");
    }


    public static void main(String[] args) throws IOException {
        compileOnce();
        WatchService.start();
    }

    private static String prepareInteractiveStaticHtml(String html) {
        String prepared = html.replace("<form action=\"/add\" method=\"POST\">",
                "<form id=\"add-product-form\">");
        prepared = prepared.replaceAll("\\s+onclick=\"window\\.location\\.href='/product/[^']+'\"", "");
        prepared = prepared.replaceAll("<form action=\"/delete\" method=\"POST\">", "<form>");
        return prepared;
    }

    private static String addStaticScriptLink(String html) {
        if (html.contains("src=\"script.js\"")) return html;
        String script = "<script src=\"script.js\" defer></script>";
        if (html.contains("</body>")) return html.replace("</body>", "    " + script + "\n</body>");
        return html + "\n" + script;
    }

    private static String addStaticStylesheetLink(String html, boolean hasCss) {
        if (!hasCss || html.contains("href=\"style.css\"")) {
            return html;
        }
        String link = "<link rel=\"stylesheet\" href=\"style.css\">";
        if (html.contains("<head>")) {
            return html.replace("<head>", "<head>\n    " + link);
        }
        if (html.contains("<html>")) {
            return html.replace("<html>", "<html>\n<head>\n    " + link + "\n</head>");
        }
        return "<!DOCTYPE html>\n<html>\n<head>\n    " + link + "\n</head>\n<body>\n"
                + html + "\n</body>\n</html>";
    }

    private static void writeGenerationArtifacts(ParseTree pyTree, ParseTree frontTree,
                                                 Map<String, Object> context,
                                                 String html, String css) throws IOException {
        Path artifactDirectory = Path.of("compiler_output");
        Files.createDirectories(artifactDirectory);
        Files.writeString(artifactDirectory.resolve("ast_python.json"),
                "{\n  \"parse_tree\": " + toJson(pyTree.toStringTree()) + "\n}\n");
        Files.writeString(artifactDirectory.resolve("ast_jinja.json"),
                "{\n  \"parse_tree\": " + toJson(frontTree.toStringTree()) + "\n}\n");
        String log = "Generated at: " + Instant.now() + "\n"
                + "Mode: static (no Flask server started)\n"
                + "Literal context keys: " + context.keySet() + "\n"
                + "output/index.html characters: " + html.length() + "\n"
                + "output/style.css characters: " + css.length() + "\n";
        Files.writeString(artifactDirectory.resolve("generation_log.txt"), log);
    }

    private static String toJson(String value) {
        return "\"" + value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r") + "\"";
    }

    private static void printTree(ParseTree tree, Parser parser, int indent) {
        String indentation = "  ".repeat(indent);
        String nodeText = Trees.getNodeText(tree, parser);
        System.out.println(indentation + nodeText);

        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(tree.getChild(i), parser, indent + 1);
        }
    }
}