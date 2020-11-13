package by.kunavich.compositechain.data;

import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.ComponentBiulder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SentenceParserTest  {

    private static final String VALID_TEXT = "Hi user.";

    @Test
    public void testSentenceParse() {

        SentenceParser sentenceParser = new SentenceParser();
        Component actual =sentenceParser.parse(VALID_TEXT);
        ComponentBiulder componentBiulder = new ComponentBiulder();
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("user.");
        Component expected = componentBiulder.biuld(list);
        Assert.assertEquals(expected,actual);

    }
}