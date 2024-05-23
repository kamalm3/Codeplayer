import java.lang.Exception;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            System.err.println("You have input more arguments than allowed, please follow this format: java Main input_file ");
            return;
        }


        // Create a CharStream from the input file
        CharStream charStream = CharStreams.fromFileName(args[0]);

        PlayLexer lexer = new PlayLexer(charStream);
        PlayParser parser = new PlayParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        PlayVisitorImpl visitor = new PlayVisitorImpl();
        visitor.visit(tree);
    }
}

