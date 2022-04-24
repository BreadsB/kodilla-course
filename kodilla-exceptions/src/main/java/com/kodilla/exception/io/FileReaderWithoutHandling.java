package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {

    public void readFile() throws IOException {
        ClassLoader cl = getClass().getClassLoader();
        File file = new File(cl.getResource("names.txt").getFile());
        Path path = Path.of(file.getPath());
//        Path path = Path.of("wrong-path.txt");
        Stream<String> output = Files.lines(path);
        output.forEach(System.out::println);
    }
}
