package edu.epam.training.task2.util;

import edu.epam.training.task2.exceptions.EmptyFileException;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class DataReaderTest {

    DataReader reader = new DataReader();

    @Test(expectedExceptions = EmptyFileException.class)
    public void testLineReadEmptyFile() throws EmptyFileException {
        reader.lineRead("source/empty.txt");
    }

    @Test
    public void testLineReadNoFile() throws EmptyFileException{
        assertEquals(reader.lineRead("source/y.txt").length(), 0);
    }

    @Test
    public void testLineReadNormFile() throws EmptyFileException{
        assertEquals(reader.lineRead("source/text.txt").length() > 0, true);
    }
}