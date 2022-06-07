package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTestSuite {

//    @Autowired
//    Calculator calculator;

    @Test
    void testCalculations() {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = (Calculator) context.getBean("calculator");

        double adding = calculator.add(5, 5);
        double substract = calculator.sub(15, 5);
        double multiply = calculator.mul(10, 1);
        double divide = calculator.div(100, 10);

        Assertions.assertEquals(adding, 10);
        Assertions.assertEquals(substract, 10);
        Assertions.assertEquals(multiply, 10);
        Assertions.assertEquals(divide, 10);
    }
}
