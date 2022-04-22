package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {
    private static int iterator = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Forum Statistic Test Suite - begin");
    }

    @BeforeEach
    void before() {
        System.out.println("Test #"+ (++iterator));

    }

    @AfterAll
    static void afterAll() {
        System.out.println("Forum Statistic Test Suite - finish");
    }

    @Mock
    private static Statistics statisticsMock;

    List<String> usersListGenerator(int i) {
        List<String> list = new ArrayList<>();
        for (int n=0; ++n<=i; ) {
            list.add("User Name #"+n);
        }
        return list;
    }

    @DisplayName("Test method getting amount of posts, while it's quantity is 0")
    @Test
    void testQuantityOfPosts0() {
        ForumStatistics forum = new ForumStatistics();
        List<String> usersList = usersListGenerator(3);


        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.usersNames()).thenReturn(usersList);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(0, forum.getPostsCount());
        Assertions.assertEquals(16.67, forum.getAverageCommentsPerUser());
        Assertions.assertEquals(0.0, forum.getAveragePostsPerUser());
        Assertions.assertEquals(0.0, forum.getAverageCommentsPerPost());
    }

    @DisplayName("Test method getting amount of posts, while it's quantity is 1000")
    @Test
    void testQuantityOfPosts1000() {
        ForumStatistics forum = new ForumStatistics();
        when(statisticsMock.postsCount()).thenReturn(1000);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(1000, forum.getPostsCount());
    }

    @DisplayName("Testing method that gets amount of Comments while its quantity equals 0")
    @Test
    void testZeroAmountOfComments() {
        ForumStatistics forum = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(0, forum.getCommentsCount());
    }

    @DisplayName("Testing method that checks if there is less comments than posts using Mock")
    @Test
    void testCommentsLessThanPosts() {
        ForumStatistics forum = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(30);
        when(statisticsMock.postsCount()).thenReturn(50);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertTrue(forum.getCommentsCount() < forum.getPostsCount());
    }

    @DisplayName("Testing method that checks if there is more comments than posts using Mock")
    @Test
    void testCommentsMoreThanPosts() {
        ForumStatistics forum = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(30);
        when(statisticsMock.postsCount()).thenReturn(50);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(30, forum.getCommentsCount());
        Assertions.assertEquals(50, forum.getPostsCount());
        Assertions.assertFalse(forum.getCommentsCount() > forum.getPostsCount());
    }

    @DisplayName("Test method getting amount of users, while it's quantity is 0")
    @Test
    void testZeroAmountOfUsers() {
        ForumStatistics forum = new ForumStatistics();
        when(statisticsMock.commentsCount()).thenReturn(0);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(0, forum.getCommentsCount());
    }

    @DisplayName("Get average quantity of posts per user")
    @Test
    void testAveragePostsPerUser() {
        ForumStatistics forum = new ForumStatistics();
        List<String> usersList = usersListGenerator(15);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.postsCount()).thenReturn(400);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(15, forum.getForumUsersCount());
        Assertions.assertEquals(400, forum.getPostsCount());
        Assertions.assertEquals(26.67, forum.getAveragePostsPerUser());
    }

    @DisplayName("Get average quantity of comments per user")
    @Test
    void testAverageCommentsPerUser() {
        ForumStatistics forum = new ForumStatistics();
        List<String> usersList = usersListGenerator(19);
        when(statisticsMock.usersNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(97);
        when(statisticsMock.postsCount()).thenReturn(50);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(19, forum.getForumUsersCount());
        Assertions.assertEquals(97, forum.getCommentsCount());
        Assertions.assertEquals(5.11, forum.getAverageCommentsPerUser());
    }

    @DisplayName("Get average quantity of comments per post")
    @Test
    void testAverageCommentsPerPosts() {
        ForumStatistics forum = new ForumStatistics();
        List<String> usersList = usersListGenerator(15);

        when(statisticsMock.postsCount()).thenReturn(150);
        when(statisticsMock.commentsCount()).thenReturn(97);
        when(statisticsMock.usersNames()).thenReturn(usersList);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(0.65, forum.getAverageCommentsPerPost());
        Assertions.assertEquals(15, forum.getForumUsersCount());
    }

    @DisplayName("Get quantity of Users - case quantity 0")
    @Test
    void testQuantityOfUsers0() {
        ForumStatistics forum = new ForumStatistics();
        List<String> usersList = usersListGenerator(0);

        when(statisticsMock.usersNames()).thenReturn(usersList);

        forum.calculateAdvStatistics(statisticsMock);

        Assertions.assertEquals(0, forum.getForumUsersCount());
    }

    @DisplayName("Get quantity of Users - case quantity 100")
    @Test
    void testQuantityOfUsers100() {
        ForumStatistics forum = new ForumStatistics();
        List<String> usersList = usersListGenerator(100);

        when(statisticsMock.usersNames()).thenReturn(usersList);

        forum.calculateAdvStatistics(statisticsMock);
        double result = forum.getForumUsersCount();

        Assertions.assertEquals(100, result);
    }
}
