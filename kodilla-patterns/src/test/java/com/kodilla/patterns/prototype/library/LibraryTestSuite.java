package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {

        Library library = new Library("Library 1");
        Book exampleBook = new Book("Rise and Sky", "Tim John", LocalDate.of(1990, 1, 18));
        library.getBooks().add(exampleBook);


        for(int i=0; i<10; i++) {
            library.getBooks().add(new Book("Book " + i, "Author " + i, LocalDate.now().minusYears(i)));
        }

        Library shallowClonedLibrary = null;
        Library deepClonedLibrary = null;

        try {
            shallowClonedLibrary = library.shallowClone();
            deepClonedLibrary = library.deepClone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(exampleBook);

        System.out.println(library.getBooks().size());
        System.out.println(deepClonedLibrary.getBooks().size());
        System.out.println(shallowClonedLibrary.getBooks().size());

        Assertions.assertEquals(10, shallowClonedLibrary.getBooks().size());
        Assertions.assertEquals(library.getBooks(), shallowClonedLibrary.getBooks());
        Assertions.assertEquals(11, deepClonedLibrary.getBooks().size());
        Assertions.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}
