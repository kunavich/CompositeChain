package by.kunavich.compositechain.data;

import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.Composite;
import by.kunavich.compositechain.model.Leaf;

public class TextParser extends AbstractParser {
    public Component parse(String text) {
        Component component = new Composite();
        for (String paragraph : text.split("\n")) {
            if (successor == null) {
                Leaf child = new Leaf();
                child.setValue(paragraph);
                component.add(child);
            } else {
                Component child = successor.parse(paragraph);
                component.add(child);
            }
        }
        return component;

    }


}
