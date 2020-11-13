package by.kunavich.compositechain.data;

import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.Composite;
import by.kunavich.compositechain.model.Leaf;

public class ParagraphParser extends AbstractParser {
    public Component parse(String text) {
        Component component = new Composite();
        for (String sentence : text.split("[\\!|\\?|.]")) {
            sentence += ".";
            if (successor == null) {
                Leaf child = new Leaf();
                child.setValue(sentence);
                component.add(child);
            } else {
                Component child = successor.parse(sentence);
                component.add(child);
            }
        }
        return component;

    }
}
