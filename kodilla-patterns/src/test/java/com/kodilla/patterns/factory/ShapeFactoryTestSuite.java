package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTestSuite {

    @Test
    void testFactoryCircle() {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);

        Assertions.assertEquals(Math.PI * Math.pow(4.5, 2.0), circle.getArea(), 0);
        Assertions.assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare() {
        ShapeFactory factory = new ShapeFactory();

        Shape square = factory.makeShape(ShapeFactory.SQUARE);

        Assertions.assertEquals(28.0, square.getCircumference(),0);
        Assertions.assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle() {
        ShapeFactory factory = new ShapeFactory();

        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);

        Assertions.assertEquals(35.0, rectangle.getCircumference());
        Assertions.assertEquals("The long rectangle", rectangle.getName());
    }
}
