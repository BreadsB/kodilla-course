package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {

    @Test
    void testOperationsGetAverage() {
        //GIVEN
        int[] listOfNumber = new int[] {2, 7, 10, 5, 4, 9, 1, 15, 20, 32};
        //WHEN
        double average = Operations.getAverage(listOfNumber);
        //THEN
        Assertions.assertEquals(10.5, average);
    }
}
