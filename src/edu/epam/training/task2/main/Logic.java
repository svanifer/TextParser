package edu.epam.training.task2.main;

import edu.epam.training.task2.entities.Composite;
import edu.epam.training.task2.enums.Types;
import edu.epam.training.task2.exceptions.EmptyFileException;
import edu.epam.training.task2.parsers.*;
import edu.epam.training.task2.util.CompositeHandler;
import edu.epam.training.task2.util.DataReader;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Logic {
    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(Logic.class);
        final String FILENAME = "source/text.txt";

        BasicConfigurator.configure();


        DataReader reader = new DataReader();
        String text = null;
        try {
            text = reader.lineRead(FILENAME);
        } catch (EmptyFileException e) {
            logger.error(e.toString());
        }
        System.out.println(text);
        Composite wholeText = new Composite(Types.TEXT);
        System.out.println();

        Parser textParser = new TextParser();
        Parser paragrapfParser = new ParagraphParser();
        Parser sentencefParser = new SentenceParser();
        Parser lexemeParser = new LexemeParser();
        textParser.setNextParser(paragrapfParser);
        paragrapfParser.setNextParser(sentencefParser);
        sentencefParser.setNextParser(lexemeParser);

        logger.info("Parsing is starting.");
        textParser.parse(text, wholeText);

        logger.info("Restoration of the text.");
        System.out.println("The default text is:");
        System.out.println(wholeText.getElement());

        CompositeHandler handler = new CompositeHandler(wholeText);
        handler.sortParagraph();
        logger.info("The text is sorted.");
        System.out.println("The sorted text is:");
        System.out.println(handler.getComposite().getElement());
    }
}
