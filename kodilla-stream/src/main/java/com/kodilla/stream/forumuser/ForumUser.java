package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {
    private final int identifier;
    private final String userName;
    private final LocalDate birthDate;
    private final char sex;
    private final int publishedPostsQuantity;

    public ForumUser(final int identifier, final String userName, final LocalDate birthDate, final char sex, final int publishedPostsQuantity) {
        this.identifier = identifier;
        this.userName = userName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.publishedPostsQuantity = publishedPostsQuantity;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public char getSex() {
        return sex;
    }

    public int getPublishedPostsQuantity() {
        return publishedPostsQuantity;
    }

    @Override
    public String toString() {
        return  "identifier=" + identifier +
                ", userName='" + userName + '\'' +
                ", birthDate=" + birthDate +
                ", sex=" + sex +
                ", publishedPostsQuantity=" + publishedPostsQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return identifier == forumUser.identifier && sex == forumUser.sex && publishedPostsQuantity == forumUser.publishedPostsQuantity && Objects.equals(userName, forumUser.userName) && Objects.equals(birthDate, forumUser.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, userName, birthDate, sex, publishedPostsQuantity);
    }
}
