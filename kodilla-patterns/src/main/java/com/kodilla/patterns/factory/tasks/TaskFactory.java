package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String DRIVING_TASK = "DRIVINGTASK";
    public static final String PAINTING_TASK = "PAINTINGTASK";
    public static final String SHOPPING_TASK = "SHOPPINGTASK";

    public final Tasks makeTask(final String taskClass) {

        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("Lift up sister", "Shopping center", "Car");
            case PAINTING_TASK:
                return new PaintingTask("Painting Mona Lisa", "Red", "Mona Lisa");
            case SHOPPING_TASK:
                return new ShoppingTask("Sunday's shopping", "Apple", 2.0);
            default:
                return null;
        }
    }
}
