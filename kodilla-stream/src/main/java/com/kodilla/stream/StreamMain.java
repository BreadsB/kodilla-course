package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.reference.PoemBeautifierReference;

import java.util.Locale;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");
        SaySomething saySomething = new SaySomething();
        saySomething.say();

//        ExecuteSaySomething say = new ExecuteSaySomething();
        Processor processor = new Processor();
        processor.execute(() -> System.out.println("Hello World"));

        System.out.println("Calculating expressions with lambdas");
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a,b)-> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);

        System.out.println("Calculating expressions with method reference");
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::add);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::substract);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::multiply);
        expressionExecutor.executeExpression(10, 5, FunctionalCalculator::divide);

        System.out.println("Poem Beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("This is a beautiful poem", a -> "-- " + a + " --");
        poemBeautifier.beautify("This is a beautiful poem", a -> "-% " + a.toUpperCase(Locale.ROOT) + " %-");
        poemBeautifier.beautify("This is a beautiful poem", a -> "aA " + a.toUpperCase(Locale.ROOT) + " Aa");
        poemBeautifier.beautify("be or not to be, that is the question", a -> {
            char[] b= a.toCharArray();
            for (int i=0; i < a.length(); i+=2) {
                b[i] = Character.toUpperCase(b[i]);
            }
            return new String(b);
        });
        poemBeautifier.beautify("Building THEE NEW houses", PoemBeautifierReference::lowerCases);

        System.out.println("Generate 20 numbers using Stream NumbersGenerator");
        NumbersGenerator.generateEven(20);
    }
}
