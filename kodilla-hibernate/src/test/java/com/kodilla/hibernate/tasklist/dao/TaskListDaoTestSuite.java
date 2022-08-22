package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    private static final String LISTNAME = "ToDo";
    @Autowired
    private TaskListDao taskListDao;

    private static final String LIST_NAME = "ToDoList";
    private static final String DESCRIPTION = "This is a task list To Do";

    @Test
    void testFindByListName() {
        TaskList2 taskList = new TaskList2(LIST_NAME, DESCRIPTION);

        taskListDao.save(taskList);

        String listName = taskList.getListName();
        List<TaskList2> readTaskLists = taskListDao.findByListName(listName);

        Assertions.assertEquals(1, readTaskLists.size());

        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }
}
