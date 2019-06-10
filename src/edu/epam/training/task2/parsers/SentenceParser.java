package edu.epam.training.task2.parsers;

import edu.epam.training.task2.entities.Composite;
import edu.epam.training.task2.enums.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {

    private static final String LEXEME_REGEX = "[a-zA-Z\\-'0-9]+?[\\s\\,\\.\\!\\?]";

    @Override
    public void parse(String text, Composite sentence) {

        Pattern pattern = Pattern.compile(LEXEME_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String lexemeText = matcher.group();
            Composite lexemeComposite = new Composite(Types.LEXEME);
            sentence.addComponent(lexemeComposite);
            if (next != null){
                next.parse(lexemeText, lexemeComposite);
            }

        }

    }
}
