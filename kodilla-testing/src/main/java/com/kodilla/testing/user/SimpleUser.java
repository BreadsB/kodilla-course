package com.kodilla.testing.user;

public class SimpleUser {

    private String userName;

    public SimpleUser(String name) {
        this.userName = name;
    }

    @Override
    public String toString() {
        return "User name: " + userName;
    }

    public String getUserName() {
        return userName;
    }
}
