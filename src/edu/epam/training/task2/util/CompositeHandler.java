package edu.epam.training.task2.util;

import edu.epam.training.task2.entities.Component;
import edu.epam.training.task2.entities.Composite;
import org.apache.log4j.Logger;

import java.util.*;

public class CompositeHandler {

    final static Logger logger = Logger.getLogger(CompositeHandler.class);

    private Composite composite;

    public CompositeHandler(Composite composite) {
        this.composite = composite;
    }

    public void sortParagraph (){

        logger.info("Text is sorting paragraphs by amount of sentences.");
        List<Component> l = composite.getComponents();
        Composite[] arrcom = l.toArray(new Composite[l.size()]);

        for (int i = 0; i < arrcom.length; i++){
            for (int j = i + 1; j < arrcom.length; j++){
                if (arrcom[j].getComponents().size() < arrcom[i].getComponents().size()){
                    Composite temp = arrcom[i];
                    arrcom[i] = arrcom[j];
                    arrcom[j] = temp;
                }
            }
        }
        List<Component> list = new ArrayList<>(Arrays.asList(arrcom));
        composite.setComponents(list);

    }

    public Composite getComposite() {
        return composite;
    }
}
