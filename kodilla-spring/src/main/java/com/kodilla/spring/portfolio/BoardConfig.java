package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("ToDoList")
    TaskList listToDo;

    @Autowired
    @Qualifier("InProgressList")
    TaskList listInProgress;

    @Autowired
    @Qualifier("DoneList")
    TaskList listDone;

    @Bean
    public Board getBoard() {
        return new Board(listToDo, listInProgress, listDone);
    }

    @Bean(name = "ToDoList")
    @Scope("prototype")
    public TaskList createToDoList() {
        return new TaskList("To do list");
    }

    @Bean(name = "InProgressList")
    @Scope("prototype")
    public TaskList createInProgressList() {
        return new TaskList("In progress list");
    }

    @Bean(name = "DoneList")
    @Scope("prototype")
    public TaskList createDoneList() {
        return new TaskList("Done list");
    }
}
