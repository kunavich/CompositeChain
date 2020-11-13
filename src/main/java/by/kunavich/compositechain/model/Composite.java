package by.kunavich.compositechain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private ArrayList<Component> components = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composite)) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void add(Component component) {
        components.add(component);
    }

    public void addAll(List<Component> components) {
        for (Component component : components) {
            this.components.add(component);
        }

    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Object getChild(int index) {
        return components.get(index);
    }

    @Override
    public Integer getSize() {
        return components.size();
    }

}
