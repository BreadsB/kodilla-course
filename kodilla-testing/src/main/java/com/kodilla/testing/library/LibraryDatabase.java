package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
    List<Book> listBookWithCondition(String titleFragment);

    List<Book> listBookInHandOf(LibraryUser user);

    boolean rentABook(LibraryUser libraryUser, Book book);

    int returnBooks(LibraryUser user);
}
