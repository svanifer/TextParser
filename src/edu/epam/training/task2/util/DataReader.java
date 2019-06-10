package edu.epam.training.task2.util;

import edu.epam.training.task2.exceptions.EmptyFileException;
import org.apache.log4j.Logger;
import java.io.*;

public class DataReader {
    //This class reads data from txt-file

    final static Logger logger = Logger.getLogger(DataReader.class);

    public String lineRead(String path) throws EmptyFileException {
            /* Этот метод читает данные из файла и возвращает их одной "строкой". */

            String text = "";

            try (FileInputStream inFile = new FileInputStream(path)){
                byte[] str = new byte[inFile.available()];
                inFile.read(str);
                text = new String(str);
                if (text.length() == 0){
                    throw new EmptyFileException("File was empty.");
                }
                logger.info("File was successfully read.");
            } catch (FileNotFoundException e) {
                logger.error(e.toString());
            } catch (IOException e) {
                logger.error(e.toString());
            }


            return text;
        }
}
