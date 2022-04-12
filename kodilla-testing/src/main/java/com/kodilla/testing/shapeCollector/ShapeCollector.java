package com.kodilla.testing.shapeCollector;

import java.util.ArrayList;

public class ShapeCollector {
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();

    public boolean addShape(Shape shape) {
        if(shape != null) {
          return shapeList.add(shape);
        } else {
            return false;
        }
    }

    public boolean removeShape(Shape shape) {
        if(shape != null && shapeList.size() != 0) {
            return shapeList.remove(shape);
        } else {
            return false;
        }
    }

    public Shape getShape(int position) {
        if(position <= shapeList.size()) {
            return shapeList.get(position);
        } else {
            return null;
        }
    }

    public String showFigures() {
        if (shapeList.size() == 0) {
            return "List empty";
        } else {
            return shapeList.toString();
        }
    }
}
