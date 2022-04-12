package com.kodilla.testing.shapeCollector;

import org.junit.jupiter.api.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Starting Test Suite");
    }

    @BeforeEach
    public void before() {
        System.out.println("Starting Test Case");
    }

    @AfterEach
    public void after() {
        System.out.println("Ending Test Case");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Finish Test Suite");
    }

    @DisplayName("Test - add shape to ShapeColletor")
    @Test
    void testAddShape() {
        ShapeCollector shapeCollector1 = new ShapeCollector();
        Shape triangle1 = new Triangle(5.00, 8.00);
        boolean result = shapeCollector1.addShape(triangle1);
        Assertions.assertTrue(result);
    }

    @DisplayName("Test - remove shape from ShapeColletor")
    @Test
    void testRemoveShape() {
        ShapeCollector collector = new ShapeCollector();
        Shape square = new Square(5.00);
        collector.addShape(square);
        boolean result = collector.removeShape(square);
        Assertions.assertTrue(result);
    }

    @DisplayName("Test - remove shape from empty collector")
    @Test
    void testRemoveShapeNotExist() {
        ShapeCollector collector = new ShapeCollector();
        Shape square = new Square(5.00);
        Assertions.assertFalse(collector.removeShape(square));
    }

    @DisplayName("Test - get shape from collector")
    @Test
    void testGetShape() {
        ShapeCollector collector = new ShapeCollector();
        Shape circle = new Circle(4.00);
        collector.addShape(circle);
        Assertions.assertEquals(circle, collector.getShape(0));
    }

    @DisplayName("Test - get shape lists")
    @Test
    void testGetShapeList() {
        ShapeCollector collector = new ShapeCollector();
        Shape circle = new Circle(4.00);
        Shape triangle = new Triangle(3.00, 8.00);
        Shape square = new Square(8.00);
        collector.addShape(circle);
        collector.addShape(triangle);
        collector.addShape(square);
        String result = "Circle, Triangle, Square";

        Assertions.assertEquals(result, collector.showFigures());
    }
}
