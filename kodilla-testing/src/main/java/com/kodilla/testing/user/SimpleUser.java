package com.kodilla.testing.user;

public class SimpleUser {

    private String userName;
    private String realName;

    public SimpleUser(String name) {
        this.userName = name;
    }

    public SimpleUser(String username, String realName) {
        this.userName=username;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User name: " + userName;
    }

    public String getUserName() {
        return userName;
    }
    public String getRealName() { return realName; }
}
