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
    }

    @Nested
    class ShapeCollectorTests {
    @DisplayName("Test - add shape to ShapeColletor")
    @Test
    void testAddShape() {
        //Given
        ShapeCollector shapeCollector1 = new ShapeCollector();
        Shape triangle1 = new Triangle(5.00, 8.00);
        //When
        boolean result = shapeCollector1.addShape(triangle1);
        //Then
        Assertions.assertTrue(result);
    }

    @DisplayName("Test - remove shape from ShapeColletor")
    @Test
    void testRemoveShape() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape square = new Square(5.00);
        collector.addShape(square);
        //When
        boolean result = collector.removeShape(square);
        //Then
        Assertions.assertTrue(result);
    }

    @DisplayName("Test - remove shape from empty collector")
    @Test
    void testRemoveShapeNotExist() {
        //Given
        ShapeCollector collector = new ShapeCollector();
        Shape square = new Square(5.00);
        //When
        boolean result = collector.removeShape(square);
        //Then
        Assertions.assertFalse(result);
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
        String showFigures = collector.showFigures();

        String result = "Circle,Triangle,Square,";

        Assertions.assertEquals(result, showFigures);
    }


}

@Nested
@DisplayName("Tests for Shape class")
class ShapeTests {
    @DisplayName("Test - get shape name")
    @Test
    void testGetShapeName() {
        //GIVEN
        Circle circle = new Circle(5.00);
        String result = "Circle";
        //WHEN
        String circleName = circle.shapeName();
        //THEN
        Assertions.assertEquals(result, circleName);
    }

    @DisplayName("Test - get surface area")
    @Test
    void testGetSurfaceArea() {
        //GIVEN
        Circle circle = new Circle(5.00);
        Double circleSurfaceArea = 78.53981633974483;
        //WHEN
        Double result1 = circle.shapeSurfaceArea();
        //THEN
        Assertions.assertEquals(result1, circleSurfaceArea);
    }
}
