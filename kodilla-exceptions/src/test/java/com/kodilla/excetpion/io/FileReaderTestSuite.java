package com.kodilla.excetpion.io;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;

import java.net.URISyntaxException;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        FileReader fileReader = new FileReader();
        Assertions.assertDoesNotThrow(() -> fileReader.readFile("names.txt"));
    }

    @Test
    void fileNotExistThrowsException() {
        FileReader fileReader = new FileReader();
        Assertions.assertThrows(FileReaderException.class, ()-> fileReader.readFile("no-names.txt"));
    }

    @Test
    void readFileWithName() {
        FileReader fileReader = new FileReader();
        Assertions.assertAll(
                ()->Assertions.assertThrows(FileReaderException.class, ()->fileReader.readFile("no-name.txt")),
                ()->Assertions.assertDoesNotThrow(()->fileReader.readFile("names.txt")),
                ()->Assertions.assertThrows(FileReaderException.class, ()->fileReader.readFile(null))
        );
    }
}
