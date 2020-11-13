package by.kunavich.compositechain.data.reader;

import by.kunavich.compositechain.exception.DataException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileDataReader implements DataReader {
    @Override
    public String read(String filename) throws DataException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            stringBuilder.append(line);
            while (line != null) {
                line = reader.readLine();
                stringBuilder.append(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new DataException(e.getMessage(),e);
        }
        return stringBuilder.toString();
    }
}
