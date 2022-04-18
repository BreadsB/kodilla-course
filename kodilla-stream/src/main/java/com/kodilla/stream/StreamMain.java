package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        Forum newForum = new Forum();
        Map<Integer, ForumUser> newForumUserList = newForum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getBirthDate().getYear() >= 20)
                .filter(forumUser -> forumUser.getPublishedPostsQuantity() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdentifier, forumUser -> forumUser));

        String stringNewForumUserList = newForumUserList.values().stream()
                .map(ForumUser::toString)
                .collect(Collectors.joining(",\n", "<< ", " >>"));

        System.out.println(stringNewForumUserList);
    }
}
