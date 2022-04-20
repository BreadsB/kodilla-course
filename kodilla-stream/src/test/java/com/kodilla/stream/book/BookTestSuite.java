package com.kodilla.stream.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {

    @Test
    void testGetListUsingFor() {
        BookDirectory bookDirectory = new BookDirectory();
        List<Book> bookList = bookDirectory.getBookList();
        int numberOfBooksPublicatedAfter2007 = 0;

        for(Book book : bookList) {
            if (book.getYearOfPublication() >= 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assertions.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    void testGetListUsingIntStream() {
        //GIVEN
        BookDirectory bookDirectory = new BookDirectory();

        //WHEN
        List<Book> bookList = bookDirectory.getBookList();

        //THEN
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, bookList.size())
                .filter(i -> bookList.get(i).getYearOfPublication() >= 2007)
                .map(i -> 1)
                .sum();

        long longNumberOfBooksPublicatedAfter2007 = IntStream.range(0, bookList.size())
                .filter(i -> bookList.get(i).getYearOfPublication() >= 2007)
                .count();

        Assertions.assertEquals(3, numberOfBooksPublicatedAfter2007);
        Assertions.assertEquals(3, longNumberOfBooksPublicatedAfter2007);
    }
}
