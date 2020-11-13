package by.kunavich.compositechain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leaf implements Component {

    private TextType type;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TextType getType() {
        return type;
    }

    public void setType(TextType type) {
        this.type = type;
    }

    public void add(Component c) {
        // генерация исключения и return false (если метод не void )
    }

    public void remove(Component c) {
        // генерация исключения и return false (если метод не void)
    }

    public Object getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer getSize() {
        return 0;
    }

    @Override
    public List<Component> getComponents() {
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leaf)) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(value, leaf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
