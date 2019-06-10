package edu.epam.training.task2.parsers;

import edu.epam.training.task2.entities.Composite;

public abstract class Parser {

    protected Parser next;

    public abstract void parse(String text, Composite c);

    public void setNextParser (Parser nextParser){
        next = nextParser;
    }
}
