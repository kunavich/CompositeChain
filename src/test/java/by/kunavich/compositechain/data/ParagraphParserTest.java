package by.kunavich.compositechain.data;

import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.ComponentBiulder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParserTest {

    private static final String VALID_TEXT = "Hi user. This is Valid path.";

    @Test
    public void testParagraphParse() {
        ParagraphParser paragraphParser = new ParagraphParser();
        Component actual =paragraphParser.parse(VALID_TEXT);
        ComponentBiulder componentBiulder = new ComponentBiulder();
        List<String> list = new ArrayList<>();
        list.add("Hi user.");
        list.add(" This is Valid path.");
        Component expected = componentBiulder.biuld(list);
        Assert.assertEquals(expected,actual);
    }
}