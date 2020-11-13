package by.kunavich.compositechain.data.reader;

import by.kunavich.compositechain.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class FileDataReaderTest {
    private static final String INVALID_FILE_PATH = "invalid.txt";
    private static final String VALID_FILE_PATH = "test.txt";
    private static final String EXPECTED_TEXT = "Hi user.\n" + "This is Valid path.\n";

    @Test(expected = DataException.class)
    void readIncorectFilePathShoudThowDataExceptionTest() throws DataException {
        DataReader dataReader = new FileDataReader();
        String actual = dataReader.read(INVALID_FILE_PATH);
    }

    @Test
    void readCorectFilePathTest() throws DataException {
        DataReader dataReader = new FileDataReader();
        String actual = dataReader.read(VALID_FILE_PATH);
        Assert.assertEquals(EXPECTED_TEXT, actual);
    }

}