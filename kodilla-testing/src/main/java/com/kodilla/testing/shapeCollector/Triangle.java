package com.kodilla.testing.shapeCollector;

public class Triangle implements Shape{

    private double baseLength;
    private double height;

    public Triangle(double a, double h) {
        this.baseLength = a;
        this.height = h;
    }

    @Override
    public String shapeName() {
        return "Triangle";
    }

    @Override
    public Double shapeSurfaceArea() {
        return (baseLength * height) / 2 ;
    }
}
