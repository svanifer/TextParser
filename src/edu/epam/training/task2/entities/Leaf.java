package edu.epam.training.task2.entities;

import edu.epam.training.task2.enums.Types;

public class Leaf implements Component{

    private String element;
    private Types type;

    public Leaf(String element, Types type) {
        this.element = element;
        this.type = type;
    }

    @Override
    public Types getType() {
        return type;
    }

    @Override
    public String getElement() {
        return element;
    }
}
