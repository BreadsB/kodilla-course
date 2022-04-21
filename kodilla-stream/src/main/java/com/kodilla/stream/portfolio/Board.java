package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Board {
    private final List<TaskList> taskLists = new ArrayList<>();
    private final String boardName;

    public Board(final String boardName) {
        this.boardName = boardName;
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getBoardName() {
        return boardName;
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TaskList taskList) {
        return taskLists.remove(taskList);
    }

    @Override
    public String toString() {
        return "Board{" +
                "taskLists=" + taskLists +
                ", boardName='" + boardName + '\'' +
                '}';
    }
}
