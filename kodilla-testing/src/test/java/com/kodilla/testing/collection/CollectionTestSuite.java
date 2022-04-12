package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Collection Test Suite: START");
    }

    @BeforeEach
    public void before() {
        System.out.println("Test start");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Finish");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Collection Test Suite: END");
    }

    @DisplayName("Testing if exterminator list has null items")
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> testListEmpty = new ArrayList<>();

        //When
        List<Integer> exterminatorList = exterminator.exterminate(testListEmpty);

        //Then
        Assertions.assertNull(exterminatorList);
    }

    @DisplayName("Testing if exterminator method returns list of ONLY even numbers")
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> testListNormal = new ArrayList<>();
        testListNormal.add(7);
        testListNormal.add(3);
        testListNormal.add(5);
        testListNormal.add(8);
        testListNormal.add(12);
        List<Integer> exterminatorList = exterminator.exterminate(testListNormal);

        //When
        List<Integer> resultList = new ArrayList<>(List.of(8,12));

        //Then
        Assertions.assertEquals(exterminatorList, resultList);

    }
}
