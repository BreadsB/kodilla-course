package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
@DisplayName("Testing TaskList and Board using Spring")
public class BoardTestSuite {

    @Test
    @DisplayName("Check if ToDoList exist and is empty")
    void testToDoListExistAndIsEmpty() {
        //GIVEN
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //WHEN
        String listName = board.getToDoList().getTaskListName();
        int listSize = board.getToDoList().getTaskList().size();

        //THEN
        Assertions.assertEquals("To do list", listName);
        Assertions.assertEquals(0, listSize);
    }

    @Test
    @DisplayName("Check if InProgressList exist and is empty")
    void testInProgressListExistAndIsEmpty() {
        //GIVEN
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //WHEN
        String listName = board.getInProgressList().getTaskListName();
        int listSize = board.getInProgressList().getTaskList().size();

        //THEN
        Assertions.assertEquals("In progress list", listName);
        Assertions.assertEquals(0, listSize);
    }

    @Test
    @DisplayName("Check if DoneList exist and is empty")
    void testDoneListExistAndIsEmpty() {
        //GIVEN
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //WHEN
        String listName = board.getDoneList().getTaskListName();
        int listSize = board.getDoneList().getTaskList().size();

        //THEN
        Assertions.assertEquals("Done list", listName);
        Assertions.assertEquals(0, listSize);
    }

    @Test
    @DisplayName("Test adding new tasks to lists")
    void testAddTask() {
        //GIVEN
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean(Board.class);

        //WHEN
        Assertions.assertTrue(board.getToDoList().addTask("Buy milk"));
        board.getToDoList().addTask("Buy coffe");
        board.getToDoList().addTask("Buy icecream");

        board.getInProgressList().addTask("Laundry");
        board.getInProgressList().addTask("Training");

        board.getDoneList().addTask("Homework");

        String toDoList = board.getToDoList().getTasks();

        //THEN
        Assertions.assertEquals("Buy milk, Buy coffe, Buy icecream", toDoList);
        Assertions.assertEquals(3, board.getToDoList().getTaskList().size());
        Assertions.assertEquals(2, board.getInProgressList().getTaskList().size());
        Assertions.assertEquals(1, board.getDoneList().getTaskList().size());
    }

    @Test
    void testSomething() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BoardConfig.class);
        Arrays.stream(ctx.getBeanDefinitionNames())
                .forEach(System.out::println);

        ctx.getBean("showSomething");
    }
}
