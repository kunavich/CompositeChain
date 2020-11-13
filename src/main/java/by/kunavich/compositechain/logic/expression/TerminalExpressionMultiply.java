package by.kunavich.compositechain.logic.expression;

public class TerminalExpressionMultiply extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        int firstNumber=c.popValue();
        int secondNumber=c.popValue();
        c.pushValue((firstNumber * secondNumber));
    }
}