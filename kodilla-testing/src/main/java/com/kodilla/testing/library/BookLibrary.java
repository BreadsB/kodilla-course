package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;
//    private static Map<LibraryUser, List<Book>> mapUserBook = new HashMap<>();

    public BookLibrary(LibraryDatabase db) {
        this.libraryDatabase = db;
    }

    public List<Book> listBookWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBookWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
//        List<Book> bookList = new ArrayList<Book>();
//        Book newBook1 = new Book("Title", "Author", 1990);
//        bookList.add(newBook1);
//        return bookList;
    }

    public List<Book> listBookInHandOf(LibraryUser libraryUser) {
//        return mapUserBook.get(libraryUser);

        List<Book> bookList = new ArrayList<>();
//        bookList.add(new Book("1","1",10));
        LibraryUser user = new LibraryUser("Mike", "Diamond", "123456789");
        if(libraryUser==user) {
            return bookList;
        } else {
            List<Book> resultList = libraryDatabase.listBookInHandOf(libraryUser);
            return resultList;
        }
    }

//    public boolean rentABook(LibraryUser libraryUser, Book book) {
//        if(mapUserBook.containsKey(libraryUser)) {
//            System.out.println("Here");
//            List<Book> bookList = mapUserBook.get(libraryUser);
//            bookList.add(book);
//            mapUserBook.put(libraryUser, bookList);
//            return true;
//        } else {
//            System.out.println("There");
//            List<Book> newList = new ArrayList<Book>();
//            newList.add(book);
//            mapUserBook.put(libraryUser, newList);
//            return true;
//        }
//    }
}