package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    private static final String LIST_NAME = "ToDoList";
    private static final String DESCRIPTION = "This is a task list To Do";

    @Test
    void testFindByListName() {
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);

        taskListDao.save(taskList);

        String listName = taskList.getListName();
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);

        Assertions.assertEquals(1, readTaskLists.size());

        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}
