package edu.epam.training.task2.parsers;

import edu.epam.training.task2.entities.Composite;
import edu.epam.training.task2.entities.Leaf;
import edu.epam.training.task2.enums.Types;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends Parser {

    private static final String REGEX = "([a-zA-Z]+?\\b)|([,.!-?']+?)";
    private static final String WORD_REGEX = "[a-zA-Z]+?\\b";
    private static final String SIGN_REGEX = "[,.!-?']+?";

    @Override
    public void parse(String text, Composite lexeme) {
        Pattern pattern = Pattern.compile(REGEX);
        Pattern wpattern = Pattern.compile(WORD_REGEX);
        Pattern spattern = Pattern.compile(SIGN_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            String beanText = matcher.group();
            Matcher wmatcher = wpattern.matcher(beanText);
            Matcher smatcher = spattern.matcher(beanText);

            if (wmatcher.matches()) {
                Leaf wordLeaf = new Leaf(beanText, Types.WORD);
                lexeme.addComponent(wordLeaf);
                if (next != null) {
                    next.parse(beanText, null);
                }
            }else if (smatcher.matches()){
                Leaf signLeaf = new Leaf(beanText, Types.SIGN);
                lexeme.addComponent(signLeaf);
                if (next != null) {
                    next.parse(beanText, null);
                }
            }
        }
    }
}
