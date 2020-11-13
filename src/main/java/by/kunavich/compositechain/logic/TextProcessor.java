package by.kunavich.compositechain.logic;

import by.kunavich.compositechain.logic.expression.Calculator;
import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.Composite;
import by.kunavich.compositechain.model.Leaf;

import java.util.ArrayList;
import java.util.List;

public class TextProcessor implements Processor {
    public Component calculate(Component component) {
        List<Component> children = component.getComponents();
        if (children.isEmpty()) {
            Calculator calculator = new Calculator();
            return calculator.calculate((Leaf) component);
        }

        List<Component> resolved = new ArrayList<>();
        for (Component child : children) {
            Component resolvedChild = calculate(child);
            resolved.add((Composite) resolvedChild);
        }

        Composite resolvdComponent = new Composite();
        resolvdComponent.addAll(resolved);
        return resolvdComponent;
    }

    @Override
    public String restore(Component component) {
        StringBuilder text = new StringBuilder();
        for (Component paragraph : component.getComponents()) {
            for (Component sentence : paragraph.getComponents()) {
                for (Component word : sentence.getComponents()) {
                    String lexemeValue = ((Leaf) word).getValue();
                    text.append(lexemeValue);
                    text.append(" ");
                }
            }
            text.deleteCharAt(text.length() - 1);
            text.append("\n");
        }
        return text.toString();
    }

    public Component sortParagraphBySentenceCount(Component component) {
        Component sortedComponent = new Composite();
        List<Component> paragraphs = component.getComponents();
        paragraphs.sort((final Component component1, final Component component2) -> {
            return component1.getSize().compareTo(component2.getSize());
        });
        ((Composite) sortedComponent).addAll(paragraphs);
        return sortedComponent;
    }

    public Component sortSentenceByWordLength(Component component) {
        Component sortedComponent = new Composite();
        for (Component paragraph : component.getComponents()) {
            Component sortedParagraph = new Composite();
            for (Component sentence : paragraph.getComponents()) {
                List<Component> words = sentence.getComponents();
                words.sort((final Component component1, final Component component2) -> {
                    Integer firstLength = ((Leaf) component1).getValue().length();
                    int secondLength = ((Leaf) component2).getValue().length();
                    return firstLength.compareTo(secondLength);
                });
                Component sortedSentence = new Composite();
                ((Composite) sortedSentence).addAll(words);
                sortedParagraph.add(sortedSentence);
            }
            sortedComponent.add(sortedParagraph);
        }


        return sortedComponent;
    }
}

