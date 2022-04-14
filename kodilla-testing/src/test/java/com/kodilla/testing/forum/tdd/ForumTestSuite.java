package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Start of a test");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("End of a test");
    }
    @BeforeEach
    public void beforeTests() {
        System.out.println("Preparing to execute test nr #"+(++testCounter));
    }

    @Nested
    @DisplayName("All tests for Posts")
    class TestPosts {
        @DisplayName("Test adding new post")
        @Test
        void testAddPost() {
            //Given
            ForumUser user1 = new ForumUser("Mike337", "Mike Bread");
            //When
            user1.addPost(user1.getName(), "Hello World");
            //Then
            Assertions.assertEquals(1, user1.getPostQuantity());
        }

        @DisplayName("Test getting a post")
        @Test
        void testGetPost() {
            //Given
            ForumUser user1 = new ForumUser("Mike337", "Mike Bread");
            ForumPost post1 = new ForumPost("Hello World", user1.getName());
            //When
            user1.addPost(user1.getName(), post1.getPostBody());
            ForumPost retrievedPost = user1.getPost(0);
            //Them
            Assertions.assertEquals(post1, retrievedPost);
        }

        @DisplayName("Test removing a non-existing post")
        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("Test removing a Post")
        @Test
        void testRemovePost() {
            //Given
            ForumUser user1 = new ForumUser("mrsmith", "John Smith");
            ForumPost post1 = new ForumPost("Hello Post", user1.getName());
            //When
            user1.addPost(user1.getName(), post1.getPostBody());
            boolean result = user1.removePost(post1);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, user1.getPostQuantity());
        }
    }

    @Nested
    @DisplayName("All tests for Comments")
    class TestComments {
        @DisplayName("Test Adding a new comment")
        @Test
        void testAddComment() {
            //Given
            ForumUser user1 = new ForumUser("Mike337", "Mike Bread");
            ForumPost post1 = new ForumPost("Hello World", user1.getName());
            //When
            user1.addComment(post1, user1.getName(), "Comment to hello world");
            //Then
            Assertions.assertEquals(1, user1.getCommentQuantity());
        }

        @DisplayName("Test getting a comment")
        @Test
        void testGetComment() {
            //Given
            ForumUser user1 = new ForumUser("Mike337", "Mike Bread");
            ForumPost post1 = new ForumPost("Hello", user1.getName());
            ForumComment comment1 = new ForumComment(post1, "Hello Comment", user1.getName());
            //When
            user1.addComment(post1, user1.getName(), comment1.getCommentBody());
            ForumComment retrievedComment = user1.getComment(0);
            //Then
            Assertions.assertEquals(comment1, retrievedComment);
        }

        @DisplayName("Test removing non-existing comment")
        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser user1 = new ForumUser("mrsmith", "John Smith");
            ForumPost post1 = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment comment1 = new ForumComment(post1, "mrsmith",
                    "Thank you for all good words!");
            //When
            boolean result = user1.removeComment(comment1);
            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("Test removing a comment")
        @Test
        void testRemoveComment() {
            //Given
            ForumUser user1 = new ForumUser("mrsmith", "John Smith");
            ForumPost post1 = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrsmith");
            ForumComment comment1 = new ForumComment(post1, "Thank you for all good words!", "mrsmith");
            //When
            user1.addComment(post1, comment1.getAuthor(), comment1.getCommentBody());
            boolean result = user1.removeComment(comment1);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, user1.getCommentQuantity());
        }
    }
}
