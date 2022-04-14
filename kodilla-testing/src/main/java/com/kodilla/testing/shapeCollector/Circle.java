package com.kodilla.testing.shapeCollector;

import java.text.DecimalFormat;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle implements Shape{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String shapeName() {
        return "Circle";
    }

    @Override
    public Double shapeSurfaceArea() {
        return (pow(radius,2))*PI;
    }
}
