package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Tasks {
    private final String name;
    private final String where;
    private final String using;
    private boolean executed;

    public DrivingTask(final String name, final String where, final String using) {
        this.name = name;
        this.where = where;
        this.using = using;
        this.executed = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: Driving to " + where + ", using: " + using);
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
