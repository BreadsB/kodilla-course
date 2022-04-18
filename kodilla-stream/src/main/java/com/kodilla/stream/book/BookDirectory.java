package com.kodilla.stream.book;

import java.util.ArrayList;
import java.util.List;

public final class BookDirectory {
    private final List<Book> bookList = new ArrayList<>();

    public BookDirectory() {
        bookList.add(new Book("Lalka", "Boleslaw Prus", 1990, "00001"));
        bookList.add(new Book("Dziany", "Adam Mickiewicz", 1990, "00002"));
        bookList.add(new Book("Boska Komedia", "Dante Alighieri", 1990,"00003"));
        bookList.add(new Book("Quo Vadis", "Henryk Sienkiewicz", 1990, "00004"));
        bookList.add(new Book("Balldayna", "Juliusz Slowacki", 1990,"00005"));
        bookList.add(new Book("Ryan Talley", "Gangsters and kings", 2007,"00006"));
        bookList.add(new Book("Madelynn Carson", "Unity without duty", 2007,"00007"));
        bookList.add(new Book("Giancarlo Guerrero", "Enemies of eternity", 2009,"00008"));
    }

    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }
}
