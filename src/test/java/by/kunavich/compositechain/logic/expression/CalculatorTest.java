package by.kunavich.compositechain.logic.expression;

import by.kunavich.compositechain.model.Leaf;
import by.kunavich.compositechain.model.TextType;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final String PLUS = "7 2 + ";
    private static final String MULTIPLY = "3 4 * ";

    private static final String MINUS = "5 1 - ";
    private static final String DIVIDE = "6 3 / ";

    @Test
    public void parsePlusTest() {
        Leaf leaf = new Leaf();
        leaf.setValue(PLUS);
        leaf.setType(TextType.Expression);
        Calculator calculator= new Calculator();
        Leaf actual=calculator.calculate(leaf);
        Leaf expected= new Leaf();
        expected.setType(TextType.Word);
        expected.setValue("9");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void parseMultiplyTest() {
        Leaf leaf = new Leaf();
        leaf.setValue(MULTIPLY);
        leaf.setType(TextType.Expression);
        Calculator calculator= new Calculator();
        Leaf actual=calculator.calculate(leaf);
        Leaf expected= new Leaf();
        expected.setType(TextType.Word);
        expected.setValue("12");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void parseMinusTest() {
        Leaf leaf = new Leaf();
        leaf.setValue(MINUS);
        leaf.setType(TextType.Expression);
        Calculator calculator= new Calculator();
        Leaf actual=calculator.calculate(leaf);
        Leaf expected= new Leaf();
        expected.setType(TextType.Word);
        expected.setValue("4");
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void parseDivideTest() {
        Leaf leaf = new Leaf();
        leaf.setValue(DIVIDE);
        leaf.setType(TextType.Expression);
        Calculator calculator= new Calculator();
        Leaf actual=calculator.calculate(leaf);
        Leaf expected= new Leaf();
        expected.setType(TextType.Word);
        expected.setValue("2");
        Assert.assertEquals(expected,actual);
    }
}