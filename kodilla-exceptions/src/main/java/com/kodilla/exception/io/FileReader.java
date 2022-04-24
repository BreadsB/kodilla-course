package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() {
        ClassLoader cl = getClass().getClassLoader();
        File file = new File(cl.getResource("names.txt").getFile());
        Path path = Path.of(file.getPath());
//        Path path = Path.of("wrong-path.txt");

        try (Stream<String> output = Files.lines(path)) {
            output.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error at " + e);
        } finally {
            LocalDateTime attemptionDate = LocalDateTime.now();
            System.out.println(attemptionDate);
        }
    }
}
