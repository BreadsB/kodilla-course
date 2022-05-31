package com.kodilla.good.patterns.challenges;

public class User {
    private final String firstName;
    private final String secondName;

    public User(final String firstName, final String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFullName() { return firstName + " " + secondName; }
}
