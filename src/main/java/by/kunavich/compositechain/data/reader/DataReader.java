package by.kunavich.compositechain.data.reader;

import by.kunavich.compositechain.exception.DataException;

public interface DataReader {
    String read(String filename) throws DataException;
}
