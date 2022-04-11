package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: start");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: finish");
    }

    @DisplayName("When created SimpleUser with name, " +
            "then getUsername should return correct name")
    @Test
    void testCaseRealName() {
        //Arrange
        SimpleUser simpleUser = new SimpleUser("The Forum User", "Mike John");

        //Act
        String result = simpleUser.getRealName();
//        String expectedResult = "The Forum User";
        System.out.println("Testing: "+result);
        //Assert
        Assertions.assertEquals("Mike John", result);
    }

    @DisplayName("When created SimpleUser with realName, " +
                "then getRealName should return corrent name")
    @Test
    void testCaseUserName() {
        //Arrange
        SimpleUser simpleUser = new SimpleUser("The Forum User", "Mike John");

        //Act
        String result = simpleUser.getUserName();
        System.out.println("Testing: "+result);

        //Assert
        Assertions.assertEquals("Mike John", result);
    }
}
