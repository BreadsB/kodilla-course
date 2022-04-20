package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public interface Operations {
    static Double getAverage(int[] numbers) {
        IntStream.range(0,numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);

        Double average = IntStream.range(0, numbers.length)
                .mapToDouble(n -> numbers[n])
                .average()
                .orElseThrow();

        return average;
    }
}
