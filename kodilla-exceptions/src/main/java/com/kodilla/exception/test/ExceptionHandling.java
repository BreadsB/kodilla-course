package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {

    public void handleExceptionSecondChallenge(double val1, double val2) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyIWillThrowException(val1, val2);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Wrong input values entered. I am going next...");
        } finally {
            System.out.println("...finishing program");
        }
    }
}