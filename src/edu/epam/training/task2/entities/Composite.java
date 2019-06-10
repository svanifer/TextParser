package edu.epam.training.task2.entities;

import edu.epam.training.task2.enums.Types;
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    private Types type;
    private List<Component> components = new ArrayList<>();

    public Composite() {
    }

    public Composite (Types type){
        this.type = type;
    }

    @Override
    public String getElement() {

        String text = "";
        for (Component c : components) {

            if (c.getType() == Types.PARAGRAPH) {
                text = text + c.getElement() + "\n\r" + " ";
            }else if (c.getType() == Types.SIGN){
                text = text + c.getElement();
            }else {
                text = text + c.getElement();

            }
        }
        return (" " + text);
    }


    public void addComponent(Component c){
        components.add(c);
    }

    public void removeComponent(Component c){
        components.remove(c);
    }

    @Override
    public Types getType() {
        return type;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
