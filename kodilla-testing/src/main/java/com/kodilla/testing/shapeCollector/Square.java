package com.kodilla.testing.shapeCollector;

import static java.lang.Math.pow;

public class Square implements Shape{

    private double sideLength;

    public Square(double a) {
        this.sideLength = a;
    }

    @Override
    public String shapeName() {
        return "Square";
    }

    @Override
    public Double shapeSurfaceArea() {
        return pow(sideLength,2);
    }
}
