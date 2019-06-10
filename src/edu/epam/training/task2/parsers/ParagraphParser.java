package edu.epam.training.task2.parsers;

import edu.epam.training.task2.entities.Composite;
import edu.epam.training.task2.enums.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends Parser{

    private static final String SENTENCE_REGEX = "[^.!?]+[.!?]";

        @Override
    public void parse(String text, Composite paragraph) {

            Pattern patternSentence = Pattern.compile(SENTENCE_REGEX);
            Matcher matcher = patternSentence.matcher(text);

            while (matcher.find()) {
                String sentenceText = matcher.group().trim();
                Composite sentenceComposite = new Composite(Types.SENTENCE);
                paragraph.addComponent(sentenceComposite);

                if (next != null){
                    next.parse(sentenceText, sentenceComposite);
                }
            }


    }
}
