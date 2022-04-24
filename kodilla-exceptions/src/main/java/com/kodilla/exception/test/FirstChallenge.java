package com.kodilla.exception.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b==0) {
            throw new ArithmeticException();
        } else {
            return a / b;
        }
    }

    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch(ArithmeticException exception) {
            System.out.println("Error at: " + exception);
        } finally {
            LocalDateTime attemptionTime = LocalDateTime.now();
            System.out.println("Atteption at time: " + attemptionTime);
        }
    }

}
