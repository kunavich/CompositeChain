package by.kunavich.compositechain.logic.expression;

import by.kunavich.compositechain.model.Leaf;
import by.kunavich.compositechain.model.TextType;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<AbstractMathExpression> listExpression;
    public Leaf calculate(Leaf expression) {
        listExpression = new ArrayList<>();
        if( expression.getType()== TextType.Word){
            return expression;
        }
        parse(expression.getValue());

        Context context = new Context();
        // выполнение простых задач и сборка результата
        for(AbstractMathExpression terminal : listExpression) {
            terminal.interpret(context);
        }

        Leaf newLeaf= new Leaf();
        newLeaf.setType(TextType.Word);
        newLeaf.setValue(context.popValue().toString());
        return newLeaf;
    }

    private void parse(String expression) { // синтаксический анализ
        for(String lexeme : expression.split("\\p{Blank}+")) {
            if(lexeme.isEmpty()) {
                continue;
            }
            char temp = lexeme.charAt(0);
            switch(temp) {
                case'+':
                    listExpression.add(new TerminalExpressionPlus());
                    break;
                case'-':
                    listExpression.add(new TerminalExpressionMinus());
                    break;
                case'*':
                    listExpression.add(new TerminalExpressionMultiply());
                    break;
                case'/':
                    listExpression.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scan = new Scanner(lexeme);
                    if(scan.hasNextInt()) {
                        listExpression.add(
                                new NonterminalExpressionNumber(scan.nextInt()));
                    }
            }
        }
    }

}