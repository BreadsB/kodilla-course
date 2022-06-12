package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Tasks {

    private final String name;
    private final String color;
    private final String whatToPaint;
    private boolean executed;

    public PaintingTask(final String name, final String color, final String whatToPaint) {
        this.name = name;
        this.color = color;
        this.whatToPaint = whatToPaint;
        this.executed = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: Painting " + whatToPaint + " with color: " + color);
        executed = true;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
