package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

import java.net.URISyntaxException;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader fr = new FileReader();
        try {
            fr.readFile("names.txt");
        } catch (FileReaderException fileReaderException) {
            System.out.println("Problem with reading file!");
        } catch (URISyntaxException uriE) {
            System.out.println("Uri syntax exception!");
        }
    }
}
