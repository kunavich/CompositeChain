package by.kunavich.compositechain.data;

import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.Composite;
import by.kunavich.compositechain.model.Leaf;
import by.kunavich.compositechain.model.TextType;

public class SentenceParser extends AbstractParser {
    public Component parse(String text) {
        Component component = new Composite();
        for (String word : text.split(" ")) {
            if (word.length() == 0) {
                continue;
            }
            Leaf child = new Leaf();

            if (text.startsWith("[")) {
                child.setType(TextType.Expression);
                child.setValue(reformate(word));

            } else {
                child.setType(TextType.Word);
                child.setValue(word);
            }
            component.add(child);
        }
        return component;

    }


    private String reformate(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        int k = 0;
        char temporaryIntger = 0;
        char temporaryExpresion = 0;
        for (char c : line.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (k == 0) {
                    temporaryIntger = c;
                } else {
                    k=0;
                    stringBuilder.append(temporaryIntger);
                    stringBuilder.append(" ");
                    stringBuilder.append(c);
                    stringBuilder.append(" ");
                    stringBuilder.append(temporaryExpresion);
                    stringBuilder.append(" ");
                }
            }else {
                k++;
                temporaryExpresion = c;
            }
        }
        return stringBuilder.toString();
    }
}
