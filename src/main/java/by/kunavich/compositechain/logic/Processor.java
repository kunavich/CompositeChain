package by.kunavich.compositechain.logic;

import by.kunavich.compositechain.model.Component;
import by.kunavich.compositechain.model.Composite;

public interface Processor {
    Component calculate(Component text);

    public String restore(Component text);
}
