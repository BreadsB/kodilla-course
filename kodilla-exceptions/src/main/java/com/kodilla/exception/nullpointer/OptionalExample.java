package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        User user = null;

        Optional<User> optionalUser = Optional.ofNullable(user);

        String username = optionalUser.orElse(new User("user1")).getUserName();
        optionalUser.ifPresent(user1 -> System.out.println(user1.getUserName()));

        System.out.println(username);
    }
}
