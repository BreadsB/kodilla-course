package com.kodilla.patterns.strategy.social;

public class User {

    private final String name;
    protected SocialPublisher favouritePublisher;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFavouritePublisher(SocialPublisher favouritePublisher) {
        this.favouritePublisher = favouritePublisher;
    }

    public String post() {
        return this.getName() + favouritePublisher.share();
    }
}
