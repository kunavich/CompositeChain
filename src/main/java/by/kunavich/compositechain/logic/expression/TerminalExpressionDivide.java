package by.kunavich.compositechain.logic.expression;

public class TerminalExpressionDivide extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        int firstNumber=c.popValue();
        int secondNumber=c.popValue();
        c.pushValue(( secondNumber/firstNumber));
    }
}