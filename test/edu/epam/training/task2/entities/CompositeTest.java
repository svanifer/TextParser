package edu.epam.training.task2.entities;

import edu.epam.training.task2.enums.Types;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeTest {

    Composite composite = new Composite();
    Composite composite1 = new Composite();


    @Test
    public void testGetElementEmptyComposite(){
        assertEquals(composite.getElement(), " ");
    }


    @Test
    public void testGetElement(){
        composite1.addComponent(new Leaf("Leaf", Types.TEXT));
        assertEquals(composite1.getElement(), " Leaf");
    }


}