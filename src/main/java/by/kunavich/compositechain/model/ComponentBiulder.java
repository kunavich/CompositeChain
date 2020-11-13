package by.kunavich.compositechain.model;

import java.util.List;

public class ComponentBiulder {
    public Component biuld(List<String> list ){//firstString,String secondString) {
        Component component = new Composite();
        for (String line:list   ) {
            Leaf leaf = new Leaf();
            leaf.setValue(line);
            component.add(leaf);
        }
        return  component;
    }
}
