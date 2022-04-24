package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class FileReader {

    public void readFile(final String fileName) throws FileReaderException, URISyntaxException {
        ClassLoader cl = getClass().getClassLoader();

        try (Stream<String> output = Files.lines(Path.of(cl.getResource(fileName).toURI()))) {
            output.forEach(System.out::println);
        } catch (Exception e) {
            throw new FileReaderException();
        } finally {
            LocalDateTime attemptionDate = LocalDateTime.now();
            System.out.println(attemptionDate);
        }
    }
}
