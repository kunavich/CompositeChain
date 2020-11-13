package by.kunavich.compositechain.logic;

import by.kunavich.compositechain.data.ChainBuilder;
import by.kunavich.compositechain.data.ParagraphParser;
import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.ComponentBiulder;
import by.kunavich.compositechain.model.Composite;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TextProcessorTest {
    private static final String VALID_TEXT = "Hi user.\n" + "This is Valid path. And Vaild text.\n";

    final Component component = getComponent();

    private Component getComponent() {
        Component component = new Composite();
        ComponentBiulder componentBiulder = new ComponentBiulder();
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("user.");
        Component firstSentence = componentBiulder.biuld(list);
        Component firstPheragraph = new Composite();
        firstPheragraph.add(firstSentence);
        component.add(firstPheragraph);
        list.clear();

        list.add("This");
        list.add("is");
        list.add("Valid");
        list.add("path.");
        Component secondSentence = componentBiulder.biuld(list);
        list.clear();
        list.add("And");
        list.add("Vaild");
        list.add("text.");
        Component thirdSentence = componentBiulder.biuld(list);
        Component secondPheragraph = new Composite();
        secondPheragraph.add(secondSentence);
        secondPheragraph.add(thirdSentence);
        component.add(secondPheragraph);
        return component;
    }

    private Component getSortedSentenceByWordLength() {
        Component component = new Composite();
        ComponentBiulder componentBiulder = new ComponentBiulder();
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("user.");
        Component firstSentence = componentBiulder.biuld(list);
        Component firstPheragraph = new Composite();
        firstPheragraph.add(firstSentence);
        component.add(firstPheragraph);
        list.clear();
        list.add("is");
        list.add("This");
        list.add("Valid");
        list.add("path.");


        Component secondSentence = componentBiulder.biuld(list);
        list.clear();
        list.add("And");
        list.add("Vaild");
        list.add("text.");

        Component thirdSentence = componentBiulder.biuld(list);
        Component secondPheragraph = new Composite();
        secondPheragraph.add(secondSentence);
        secondPheragraph.add(thirdSentence);
        component.add(secondPheragraph);
        return component;
    }

    @Test
    public void testCalculate() {
    }

    @Test
    public void testRestoreReturnRestoredText() {
        TextProcessor processor = new TextProcessor();
        String actualString = processor.restore(component);
        String expectedString = VALID_TEXT;
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testSortParagraphBySentenceCount() {
        TextProcessor processor = new TextProcessor();
        Component actual = processor.sortParagraphBySentenceCount(component);
        Component expected = component;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortSentenceByWordLength() {
        TextProcessor processor = new TextProcessor();
        Component actual = processor.sortSentenceByWordLength(component);
        Component expected = getSortedSentenceByWordLength();
        Assert.assertEquals(expected, actual);
    }
}