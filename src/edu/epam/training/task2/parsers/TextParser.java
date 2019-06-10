package edu.epam.training.task2.parsers;

import edu.epam.training.task2.entities.Composite;
import edu.epam.training.task2.enums.Types;
import org.apache.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends Parser{

    final static Logger logger = Logger.getLogger(TextParser.class);
    private static final String PARAGRAPH_REGEX = "\\s*.+\\r\\n";

    @Override
    public void parse (String text, Composite wholeText){

        Pattern patternParagraph = Pattern.compile(PARAGRAPH_REGEX);
        try {
            Matcher matcher = patternParagraph.matcher(text);

            while (matcher.find()) {
                String paragraphText = matcher.group().trim();
                Composite paragraphComposite = new Composite(Types.PARAGRAPH);
                wholeText.addComponent(paragraphComposite);

                if (next != null) {
                    next.parse(paragraphText, paragraphComposite);
                }
            }
        }catch (NullPointerException e){
            logger.error(e.toString() + " Text-file was empty.");
        }
    }
}
