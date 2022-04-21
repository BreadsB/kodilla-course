package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import static java.time.temporal.ChronoUnit.DAYS;

public class BoardTestSuite {

    @Test
    void testAddTaskListAverageWorkingOnTask() {
        Board project = prepareTestData();
        TaskList listInProgress = new TaskList("In Progress List");

        double result = project.getTaskLists().stream()
                .filter(taskList -> taskList.equals(listInProgress))
                .flatMap(taskList -> taskList.getTaskList().stream())
                .mapToInt(task -> Math.abs(task.getCreated().compareTo(LocalDate.now())))
                .average().getAsDouble();

        Assertions.assertEquals(13.25, result);
    }

    @Test
    void testFindLongTasks() {
        Board project = prepareTestData();
        TaskList listInProgress = new TaskList("In Progress List");

        List<Task> result = project.getTaskLists().stream()
                .filter(taskList -> taskList.equals(listInProgress))
                .flatMap(taskList -> taskList.getTaskList().stream())
//                .filter(task -> task.getCreated().compareTo(LocalDate.now().minusDays(10)) <= 0)
                .filter(task -> DAYS.between(task.getCreated(), LocalDate.now()) >= 10)
                .collect(Collectors.toList());

        Assertions.assertEquals(3, result.size());
    }

    @Test
    void testFindOutdatedTasks() {
        Board project = prepareTestData();
        List<TaskList> undone = new ArrayList<>();
        TaskList listToDo = new TaskList("ToDo List");
        TaskList listInProgress = new TaskList("In Progress List");
        undone.add(listInProgress);
        undone.add(listToDo);

        List<Task> result = project.getTaskLists().stream()
                .filter(taskList -> undone.contains(taskList))
                .flatMap(taskList -> taskList.getTaskList().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        Assertions.assertEquals(2, result.size());
    }

    @Test
    void testAddTaskList() {
        Board project = prepareTestData();

        TaskList testTaskList = new TaskList("tasklist1");
        project.addTaskList(testTaskList);

        Assertions.assertEquals(4, project.getTaskLists().size());
    }

    @Test
    void testFindAllTasks() {
        Board project = prepareTestData();
        User searchUser = new User("developer1", "Andrew Clark");

        List<Task> result = project.getTaskLists().stream()
                .flatMap(taskList -> taskList.getTaskList().stream())
                .filter(task -> task.getAssignedUser().equals(searchUser))
//                .map(task -> task.getTitle() + ":: " + task.getDescription())
                .collect(Collectors.toList());

        System.out.println(result);

        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(searchUser, result.get(0).getAssignedUser());
        Assertions.assertEquals(searchUser, result.get(1).getAssignedUser());
    }

    private Board prepareTestData() {

        User user1 = new User("ScrumMaster1","Roberto di Merano");
        User user2 = new User("tester1", "Markus Schwarz");
        User user3 = new User("tester2", "Sophie Dubois");
        User user4 = new User("developer1", "Andrew Clark");

        Task task1 = new Task("Unit tests", "Create unit test suite", user2, user1, LocalDate.now().minusDays(20), LocalDate.now().plusDays(30));
        Task task2 = new Task("Automatic tests", "Create automatic tests suite", user3, user1, LocalDate.now().minusDays(20), LocalDate.now().plusDays(5));
        Task task3 = new Task("New functionality", "Prepare new functionality", user4, user1, LocalDate.now().minusDays(7), LocalDate.now().minusDays(3));
        Task task4 = new Task("Test new functionality", "Test new functionality", user2, user4, LocalDate.now().minusDays(3), LocalDate.now().plusDays(10));
        Task task5 = new Task("Check my tests", "Check my new tests", user2, user3, LocalDate.now().minusDays(10), LocalDate.now().plusDays(10));
        Task task6 = new Task("Problems with new functionality", "Replace a few lines of code in new functionality", user4, user2, LocalDate.now().minusDays(5), LocalDate.now().minusDays(2));
        Task task7 = new Task("Create Project", "Create plan for whole project", user1, user1, LocalDate.now().minusDays(13), LocalDate.now().minusDays(1));

        TaskList devsTaskList = new TaskList("ToDo List");
        devsTaskList.addTask(task3);
        devsTaskList.addTask(task6);

        TaskList testerTaskList = new TaskList("In Progress List");
        testerTaskList.addTask(task1);
        testerTaskList.addTask(task2);
        testerTaskList.addTask(task4);
        testerTaskList.addTask(task5);

        TaskList masterTaskList = new TaskList("Done");
        masterTaskList.addTask(task7);

        Board project = new Board("Company's project task list");
        project.addTaskList(devsTaskList);
        project.addTaskList(testerTaskList);
        project.addTaskList(masterTaskList);

        return project;
    }
}
