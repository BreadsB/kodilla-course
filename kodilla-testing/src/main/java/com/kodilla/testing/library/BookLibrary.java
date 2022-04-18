package com.kodilla.testing.library;

import java.util.*;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

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
    }

    public List<Book> listBookInHandOf(LibraryUser libraryUser) {

//        Map<LibraryUser, List<Book>> mapUserBook = new HashMap<>();
//        Nie musisz tworzyć nowej mapy, ona już powinna być w bazie danych.
        List<Book> resultList = libraryDatabase.listBookInHandOf(libraryUser);
        if(resultList.isEmpty()) {
            System.out.println("Empty list");
            return null;
        } else {
            return resultList;
        }

//        if(mapUserBook.containsKey(libraryUser)) {
////            List<Book> resultList = libraryDatabase.listBookInHandOf(libraryUser);
////            if resultList.isEmpty() { "pusta" }
////            else { wyświetl listę z książkami }
//            return mapUserBook.get(libraryUser);
//        } else {
////            utwórz nową listę
//            List<Book> resultList = libraryDatabase.listBookInHandOf(libraryUser);
//            mapUserBook.put(libraryUser, resultList);
//            return resultList;
//        }
    }
}