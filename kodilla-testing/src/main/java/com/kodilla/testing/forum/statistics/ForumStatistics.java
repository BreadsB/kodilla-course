package com.kodilla.testing.forum.statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ForumStatistics {
    private int postsCount;
    private int commentsCount;
    private List<String> usersNamesList;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();
        this.usersNamesList = statistics.usersNames();

        if(postsCount>0) { this.averageCommentsPerPost = averageCommentsPerPost(); }
        if(usersNamesList.size()>0) {
            this.averagePostsPerUser = averagePostsPerUser();
            this.averageCommentsPerUser = averageCommentsPerUser();
        }
    }

    public int getPostsCount() {
        return this.postsCount;
    }

    public int getCommentsCount() {

        return this.commentsCount;
    }

    public int getForumUsersCount() {
        return this.usersNamesList.size();
    }

    private double averagePostsPerUser() {
            return BigDecimal.valueOf((double) this.getPostsCount() / this.getForumUsersCount())
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
    }

    private double averageCommentsPerUser() {
            return BigDecimal.valueOf((double) this.getCommentsCount() / this.getForumUsersCount())
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
    }

    private double averageCommentsPerPost() {
            return BigDecimal.valueOf((double) this.getCommentsCount() / this.getPostsCount())
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
    }

    public double getAveragePostsPerUser() {
        return this.averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return this.averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return this.averageCommentsPerPost;
    }

    public void showStatistics() {
        System.out.println( "Forum Statistics:" );
        System.out.println( "\n Number of Users: " + this.getForumUsersCount() );
        System.out.println( "Number of Posts: " + this.getPostsCount() );
        System.out.println( "Number of Comments: " + this.getCommentsCount() );
        System.out.println( "Average quantity of Posts per User " + this.averagePostsPerUser );
        System.out.println( "Average quantity of Comments per User " + this.averageCommentsPerUser );
        System.out.println( "Average quantity of Comments per Post " + this.averageCommentsPerPost );
    }

}
