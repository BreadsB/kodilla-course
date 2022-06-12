package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    @Test
    void testShoppingTask() {
        TaskFactory taskFactory = new TaskFactory();

        Tasks shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPING_TASK);

        boolean executed = false;

        try {
            shoppingTask.executeTask();
            executed = shoppingTask.isTaskExecuted();
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        Assertions.assertEquals("Sunday's shopping", shoppingTask.getTaskName());
        Assertions.assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testDrivingTask() {

        //GIVEN
        TaskFactory taskFactory = new TaskFactory();
        Tasks drivingTask = taskFactory.makeTask(TaskFactory.DRIVING_TASK);
        boolean executed = false;

        //WHEN
        try {
            drivingTask.executeTask();
            executed = drivingTask.isTaskExecuted();
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        //THEN
        Assertions.assertEquals("Lift up sister", drivingTask.getTaskName());
        Assertions.assertTrue(executed);
    }

    @Test
    void testPaintingTask() {
        //GIVEN
        TaskFactory taskFactory = new TaskFactory();
        Tasks paintingTask = taskFactory.makeTask(TaskFactory.PAINTING_TASK);
        boolean executed = false;

        //WHEN
        try {
            paintingTask.executeTask();
            executed = paintingTask.isTaskExecuted();
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        //THEN
        Assertions.assertEquals("Painting Mona Lisa", paintingTask.getTaskName());
        Assertions.assertTrue(executed);

    }
}
