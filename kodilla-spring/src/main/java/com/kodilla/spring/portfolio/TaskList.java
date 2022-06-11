package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {

    private List<String> tasks;

    private String taskListName;

    public TaskList(String taskListName) {
        this.taskListName = taskListName;
        this.tasks = new ArrayList<>();
    }

    public String getTasks() {
        return this.tasks.stream()
                .collect(Collectors.joining(", "));
    }

    public List<String> getTaskList() {
        return this.tasks;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public boolean addTask(String task) {
        return this.tasks.add(task);
    }
}
