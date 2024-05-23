import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PlayVisitorImpl extends PlayBaseVisitor<Data> {

    // Save variables in memory map
    private Map<String, Data> memory = new HashMap<>();
    // Save functions in memory map
    private Map<String, PlayParser.Function_defContext> functions = new HashMap<>();

    private Data returnData = null;

    @Override
    public Data visitAssignment(PlayParser.AssignmentContext ctx) {
        if (ctx.input() != null) { // Check if assignment involves input() function
            String id = ctx.ID().getText();
            Data data = visitInput(ctx.input()); // Visit input() function to store data
            memory.put(id, data); // Store input data in memory
            return data;
        } else {
            if (ctx.ID() == null) {
                throw new RuntimeException("Oops! It seems like you forgot to specify a variable name for the assignment.");
            }
            String id = ctx.ID().getText();
            Data data = this.visit(ctx.expr());
            if (data == null) {
                throw new RuntimeException("Oops! It looks like the value you're trying to assign is missing or invalid.");
            }
            return memory.put(id, data);
        }
    }

    @Override
    public Data visitIdAtom(PlayParser.IdAtomContext ctx) {
        if (ctx == null || ctx.getText() == null) {
            throw new RuntimeException("Oops! Something went wrong while processing your variable.");
        }
        String id = ctx.getText();
        Data data = memory.get(id);
        if (data == null) {
            throw new RuntimeException("Oops! The variable '" + id + "' hasn't been assigned a value yet.");
        }
        return data;
    }

    @Override
    public Data visitFunction_def(PlayParser.Function_defContext ctx) {
        String functionName = ctx.ID().getText();
        functions.put(functionName, ctx);
        return Data.VOID;
    }

    @Override
    public Data visitFunction_call(PlayParser.Function_callContext ctx) {
        String functionName = ctx.ID().getText();
        PlayParser.Function_defContext functionDef = functions.get(functionName);
        if (functionDef == null) {
            throw new RuntimeException("Function '" + functionName + "' is not defined.");
        }
        // Evaluate function parameters
        Map<String, Data> localMemory = new HashMap<>(memory);
        if (functionDef.params() != null) {
            PlayParser.ParamsContext params = functionDef.params();
            PlayParser.ArgsContext args = ctx.args();
            if (params.ID().size() != args.expr().size()) {
                throw new RuntimeException("Number of arguments does not match the function definition.");
            }
            for (int i = 0; i < params.ID().size(); i++) {
                String param = params.ID(i).getText();
                Data argData = this.visit(args.expr(i));
                localMemory.put(param, argData);
            }
        }
        // Execute function block with local memory
        this.memory = localMemory;
        this.visit(functionDef.block());
        // Clear return value after function call
        Data retData = returnData;
        returnData = null;
        return retData;
    }

    @Override
    public Data visitReturn_stat(PlayParser.Return_statContext ctx) {
        returnData = this.visit(ctx.expr());
        // Returning VOID by default if no return statement found
        return Data.VOID;
    }

    
    @Override
    public Data visitStringAtom(PlayParser.StringAtomContext ctx) {
        if (ctx == null || ctx.getText() == null) {
            throw new RuntimeException("Oops! Something went wrong while processing your string value.");
        }
        String str = ctx.getText();
        // Remove quotes
        str = str.substring(1, str.length() - 1).replace("\"\"", "\"");
        return new Data(str);
    }

    @Override
    public Data visitNumberAtom(PlayParser.NumberAtomContext ctx) {
        if (ctx == null || ctx.getText() == null) {
            throw new RuntimeException("Oops! Something went wrong while processing your number value.");
        }
        try {
            // Attempt to parse the number as an integer
            return new Data(Integer.valueOf(ctx.getText()));
        } catch (NumberFormatException e) {
            try {
                // If parsing as an integer fails, try parsing as a double
                return new Data(Double.valueOf(ctx.getText()));
            } catch (NumberFormatException ex) {
                // If parsing as a double also fails, throw an error
                throw new RuntimeException("Oops! The number value '" + ctx.getText() + "' is not valid.");
            }
        }
    }
    
    @Override
    public Data visitBooleanAtom(PlayParser.BooleanAtomContext ctx) {
        return new Data(Boolean.valueOf(ctx.getText()));
    }

    @Override
    public Data visitNullAtom(PlayParser.NullAtomContext ctx) {
        return new Data(null);
    }

    
    @Override
    public Data visitParExpr(PlayParser.ParExprContext ctx) {
        return this.visit(ctx.expr());
    }


    @Override
    public Data visitNotExpr(PlayParser.NotExprContext ctx) {
        Data data = this.visit(ctx.expr());
        return new Data(!data.asBoolean());
    }
    @Override
    public Data visitUnaryMinusExpr(PlayParser.UnaryMinusExprContext ctx) {
        Data data = this.visit(ctx.expr());
        if (data.isInteger()) {
            return new Data(-data.asInteger()); // Negate integer value
        } else if (data.isDouble()) {
            return new Data(-data.asDouble()); // Negate double value
        } else {
            throw new RuntimeException("unsupported operand type for unary minus: " + data);
        }
    }
    
    @Override
    public Data visitMultiplicationExpr(PlayParser.MultiplicationExprContext ctx) {
        Data left = this.visit(ctx.expr(0));
        Data right = this.visit(ctx.expr(1));
    
        // Check if either operand is a decimal number
        if (left.isDouble() || right.isDouble()) {
            double leftValue = left.isDouble() ? left.asDouble() : left.asInteger();
            double rightValue = right.isDouble() ? right.asDouble() : right.asInteger();
            
            switch (ctx.op.getType()) {
                case PlayParser.MULT:
                    return new Data(leftValue * rightValue);
                case PlayParser.DIV:
                    return new Data(leftValue / rightValue);
                case PlayParser.MOD:
                    throw new RuntimeException("Cannot perform modulus operation with decimal operands.");
                default:
                    throw new RuntimeException("Unknown operator: " + PlayParser.VOCABULARY.getDisplayName(ctx.op.getType()));
            }
        } else {
            // Both operands are integers, perform integer arithmetic
            int leftInt = left.asInteger();
            int rightInt = right.asInteger();
            
            switch (ctx.op.getType()) {
                case PlayParser.MULT:
                    return new Data(leftInt * rightInt);
                case PlayParser.DIV:
                    return new Data(leftInt / rightInt);
                case PlayParser.MOD:
                    return new Data(leftInt % rightInt);
                default:
                    throw new RuntimeException("Unknown operator: " + PlayParser.VOCABULARY.getDisplayName(ctx.op.getType()));
            }
        }
    }
    

    @Override
    public Data visitAdditiveExpr(PlayParser.AdditiveExprContext ctx) {
        Data left = this.visit(ctx.expr(0));
        Data right = this.visit(ctx.expr(1));
    
        // Check if either operand is a string
        if (left.isString() || right.isString()) {
            // If one of the operands is a string, handle concatenation for addition
            // and throw an error for subtraction
            if (ctx.op.getType() == PlayParser.PLUS) {
                String result = left.toString() + right.toString();
                return new Data(result);
            } else {
                throw new RuntimeException("Cannot perform subtraction with string operands.");
            }
        } else if (left.isDouble() || right.isDouble()) {
            // Perform float addition or subtraction
            double result;
            if (ctx.op.getType() == PlayParser.PLUS) {
                result = left.asDouble() + right.asDouble();
            } else {
                result = left.asDouble() - right.asDouble();
            }
            return new Data(result);
        } else {
            // Perform integer addition or subtraction
            int result;
            if (ctx.op.getType() == PlayParser.PLUS) {
                result = left.asInteger() + right.asInteger();
            } else {
                result = left.asInteger() - right.asInteger();
            }
            return new Data(result);
        }
    }
    

    @Override
    public Data visitRelationalExpr(PlayParser.RelationalExprContext ctx) {
        Data left = this.visit(ctx.expr(0));
        Data right = this.visit(ctx.expr(1));
    
        if ((left.isInteger() || left.isDouble()) && (right.isInteger() || right.isDouble())) {
            // If both values are numeric, compare them based on their numeric values
            double leftValue = left.isInteger() ? left.asInteger() : left.asDouble();
            double rightValue = right.isInteger() ? right.asInteger() : right.asDouble();
    
            switch (ctx.op.getType()) {
                case PlayParser.LT:
                    return new Data(leftValue < rightValue);
                case PlayParser.LTEQ:
                    return new Data(leftValue <= rightValue);
                case PlayParser.GT:
                    return new Data(leftValue > rightValue);
                case PlayParser.GTEQ:
                    return new Data(leftValue >= rightValue);
                default:
                    throw new RuntimeException("unknown operator: " + PlayParser.VOCABULARY.getDisplayName(ctx.op.getType()));
            }
        } else {
            throw new RuntimeException("unsupported operand types for relational comparison: " + left + ", " + right);
        }
    }
    

    @Override
    public Data visitEqualityExpr(PlayParser.EqualityExprContext ctx) {
        Data left = this.visit(ctx.expr(0));
        Data right = this.visit(ctx.expr(1));
    
        if ((left.isInteger() || left.isDouble()) && (right.isInteger() || right.isDouble())) {
            // If both values are numeric, compare them based on their numeric values
            switch (ctx.op.getType()) {
                case PlayParser.EQ:
                    return new Data(left.asDouble().equals(right.asDouble()));
                case PlayParser.NEQ:
                    return new Data(!left.asDouble().equals(right.asDouble()));
                default:
                    throw new RuntimeException("unknown operator: " + PlayParser.VOCABULARY.getDisplayName(ctx.op.getType()));
            }
        } else {
            // Otherwise, use default equality comparison
            switch (ctx.op.getType()) {
                case PlayParser.EQ:
                    return new Data(left.equals(right));
                case PlayParser.NEQ:
                    return new Data(!left.equals(right));
                default:
                    throw new RuntimeException("unknown operator: " + PlayParser.VOCABULARY.getDisplayName(ctx.op.getType()));
            }
        }
    }
    
    
    
    @Override
    public Data visitInput(PlayParser.InputContext ctx) {
        String prompt = ""; // Initialize prompt as empty string
        if (ctx.STRING() != null) {
            prompt = ctx.STRING().getText().replaceAll("\"", ""); // Remove quotes from the prompt
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.nextLine();
    
        // Check if input represents an integer or double
        if (input.matches("-?\\d+(\\.\\d+)?")) {
            if (input.contains(".")) {
                return new Data(Double.parseDouble(input)); // Parse input as double
            } else {
                return new Data(Integer.parseInt(input)); // Parse input as integer
            }
        } else {
            return new Data(input); // Treat input as string
        }
    }

    


    @Override
    public Data visitAndExpr(PlayParser.AndExprContext ctx) {
        Data left = this.visit(ctx.expr(0));
        Data right = this.visit(ctx.expr(1));
        return new Data(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Data visitOrExpr(PlayParser.OrExprContext ctx) {
        Data left = this.visit(ctx.expr(0));
        Data right = this.visit(ctx.expr(1));
        return new Data(left.asBoolean() || right.asBoolean());
    }

   
    @Override
    public Data visitDisplay(PlayParser.DisplayContext ctx) {
        Data data = this.visit(ctx.expr());
        System.out.println(data);
        return data;
    }

   
    @Override
    public Data visitIf_stat(PlayParser.If_statContext ctx) {
        if (ctx == null || ctx.condition_block() == null || ctx.condition_block().isEmpty()) {
            throw new RuntimeException("Oops! It seems like your 'if' statement is missing conditions to evaluate.");
        }
    
        for (PlayParser.Condition_blockContext condition : ctx.condition_block()) {
            if (condition == null || condition.expr() == null) {
                throw new RuntimeException("Oops! Something went wrong while processing the condition in your 'if' statement.");
            }
    
            Data evaluated = this.visit(condition.expr());
    
            if (evaluated == null) {
                throw new RuntimeException("Oops! Something went wrong while evaluating the condition in your 'if' statement.");
            }
    
            if (evaluated.asBoolean()) {
                if (condition.stat_block() == null) {
                    throw new RuntimeException("Oops! The code block associated with the true condition in your 'if' statement is missing.");
                }
                this.visit(condition.stat_block());
                return Data.VOID;
            }
        }
    
        if (ctx.stat_block() != null) {
            this.visit(ctx.stat_block());
        }
    
        return Data.VOID;
    }

   
    @Override
    public Data visitWhile_stat(PlayParser.While_statContext ctx) {
        if (ctx == null || ctx.expr() == null) {
            throw new RuntimeException("Oops! Something went wrong while processing the condition in your 'while' loop.");
        }
    
        Data data = this.visit(ctx.expr());
    
        while (data != null && data.asBoolean()) {
            if (ctx.stat_block() == null) {
                throw new RuntimeException("Oops! The code block associated with your 'while' loop is missing.");
            }
            // evaluate the code block
            this.visit(ctx.stat_block());
            // evaluate the expression
            data = this.visit(ctx.expr());
        }
    
        return Data.VOID;
    }


}
