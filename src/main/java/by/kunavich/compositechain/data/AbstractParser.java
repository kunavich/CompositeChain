package by.kunavich.compositechain.data;

import by.kunavich.compositechain.model.Component;

public abstract class AbstractParser implements Parser {
    protected Parser successor;

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor(Parser successor) {
        this.successor = successor;
    }

}
