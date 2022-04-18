package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        ForumUser forumUser1 = new ForumUser(1, "James Harper", LocalDate.of(1990,4,12), 'M', 15);
        ForumUser forumUser2 = new ForumUser(2, "Marie Juliet", LocalDate.of(1985,8,2), 'F', 7);
        ForumUser forumUser3 = new ForumUser(3, "Barbra Stone", LocalDate.of(1999,1,29), 'F', 4);
        ForumUser forumUser4 = new ForumUser(4, "Paul Logan", LocalDate.of(2005,1,7), 'M', 100);
        ForumUser forumUser5 = new ForumUser(5, "Liam Nelson", LocalDate.of(1992,12,19), 'M', 0);
        ForumUser forumUser6 = new ForumUser(6, "Tony Robins", LocalDate.of(2002,11,21), 'M', 31);

        forumUserList.add(forumUser1);
        forumUserList.add(forumUser2);
        forumUserList.add(forumUser3);
        forumUserList.add(forumUser4);
        forumUserList.add(forumUser5);
        forumUserList.add(forumUser6);
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }

}
