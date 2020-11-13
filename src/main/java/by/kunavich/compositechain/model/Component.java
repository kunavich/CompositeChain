package by.kunavich.compositechain.model;

import java.util.List;

public interface Component {

    void add(Component c);

    void remove(Component c);

    Object getChild(int index);

    Integer getSize();

    boolean equals(Object o);



    List<Component> getComponents();
}
