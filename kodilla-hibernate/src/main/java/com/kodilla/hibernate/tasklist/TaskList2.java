package com.kodilla.hibernate.tasklist;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "TASKLIST2")
public class TaskList2 {

    private String description;
    private int id;
    private String listName;


    public TaskList2() {
    }

    public TaskList2(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Column(name = "ID", unique = true)
    @Id
    @NotNull
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    @Column(name = "DESCRIPTION")
    private String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
