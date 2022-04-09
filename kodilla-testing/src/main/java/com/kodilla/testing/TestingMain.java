package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6.2 Pierwszy test jednostkowy");

        SimpleUser user1 = new SimpleUser("Adam");
        String userName = user1.getUserName();

        if(userName.equals("Adam")) {
            System.out.println("Test userName - OK");
        } else {
            System.out.println("Test userName - FAIL");
        }

        //Create calculator object
        Calculator calculator1 = new Calculator();
        int result = calculator1.add(5, 3);

        //Add Test
        if(result==8) {
            System.out.println("Test Calculator Add - OK");
        } else {
            System.out.println("Test Calculator Add - FAIL");
        }

        //Substract Test
        result = calculator1.substract(10, 5);
        if(result==5) {
            System.out.println("Test Calculator Substract - OK");
        } else {
            System.out.println("Test Calculator Substract - FAIL");
        }
    }
}
