package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Tasks {

    private final String name;
    private final String whatToBuy;
    private final double quantity;
    private boolean executed;


    public ShoppingTask(final String name, final String whatToBuy, final double quantity) {
        this.name = name;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.executed = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: Buying " + quantity + " of " + whatToBuy);
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
