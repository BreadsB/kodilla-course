package com.kodilla.excetpion.test;

import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondChallengeTestSuite {

    @Test
    void exceptionHandlingClassTest() {
        SecondChallenge secondChallenge = new SecondChallenge();
        Assertions.assertAll(
                ()->Assertions.assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(3,0)),
                ()->Assertions.assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(0.5,0)),
                ()->Assertions.assertThrows(Exception.class, ()->secondChallenge.probablyIWillThrowException(1.5,1.5)),
                ()->Assertions.assertDoesNotThrow(()->secondChallenge.probablyIWillThrowException(1.5,0))
        );
    }

    @Test
    void secondChallengeExceptionHandler() {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.handleExceptionSecondChallenge(3.0, 0.0);
        exceptionHandling.handleExceptionSecondChallenge(0.5, 0.0);
        exceptionHandling.handleExceptionSecondChallenge(1.5, 1.5);
        exceptionHandling.handleExceptionSecondChallenge(1.5, 0);
    }
}
