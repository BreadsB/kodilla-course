package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForumUser {
    private String name;
    private String realName;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();


    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        posts.add(new ForumPost(postBody, author));
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        comments.add(new ForumComment(thePost, commentBody, author));
    }

    public int getPostQuantity() {
        return posts.size();
    }

    public int getCommentQuantity() {
        return comments.size();
    }
    public ForumPost getPost(int postNumber) {
        if(posts.size()==0) {
            System.out.println("No posts");
            return null;
        } else {
            return posts.get(postNumber);
        }
    }
    public ForumComment getComment(int commentNumber) {
        return comments.get(commentNumber);
    }
    public boolean removePost(ForumPost thePost) {
        if(posts.contains(thePost)) {
            return posts.remove(thePost);
        } else {
            return false;
        }
    }
    public boolean removeComment(ForumComment theComment) {
        if(comments.contains(theComment)) {
            return comments.remove(theComment);
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
