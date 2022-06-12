package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Copier<Library>{

    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepClone() throws CloneNotSupportedException {
        Library libraryDeepCloned = super.clone();
        libraryDeepCloned.setBooks(new HashSet<>());

        for (Book book : books ) {
            Book clonedBook = book;
            libraryDeepCloned.getBooks().add(clonedBook);
        }

        return libraryDeepCloned;
    }
}
