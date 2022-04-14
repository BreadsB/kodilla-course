package com.kodilla.testing.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class bookDirectoryTestSuite {

        private List<Book> generateBookList(int quantity) {
            List<Book> bookList = new ArrayList<>();
            for(int i=0; i<quantity; i++) {
                bookList.add(new Book("Title "+i, ", Author "+i, 1990+i));
            }
            return bookList;
        }

        @Mock
        private LibraryDatabase libraryDatabaseMock;
        private LibraryUser libraryUser;

        @DisplayName("Test if there is more than 20 results")
        @Test
        void testListBookWithConditionMoreThen20() {
            //GIVEN
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> bookList35 = generateBookList(35);
            List<Book> bookList0 = new ArrayList<>();
            List<Book> bookList15 = generateBookList(15);

            when(libraryDatabaseMock.listBookWithCondition(anyString())).thenReturn(bookList0);
            when(libraryDatabaseMock.listBookWithCondition("35Books")).thenReturn(bookList35);
            when(libraryDatabaseMock.listBookWithCondition("Fifteen")).thenReturn(bookList15);

            //WHEN
            List<Book> result2 = libraryDatabaseMock.listBookWithCondition("Any");
            List<Book> result1 = libraryDatabaseMock.listBookWithCondition("35Books");
            List<Book> result3 = libraryDatabaseMock.listBookWithCondition("Fifteen");


            //THEN
            Assertions.assertEquals(35, result1.size());
            Assertions.assertEquals(0, result2.size());
            Assertions.assertEquals(15, result3.size());
        }

        @DisplayName("Test if Fragment has less than 3 characters")
        @Test
        void testListBookWithConditionFragmentShorterThen3() {
            //GIVEN
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            //WHEN
            List<Book> bookList10 = bookLibrary.listBookWithCondition("As");
            //THEN
            Assertions.assertEquals(0, bookList10.size());
            verify(libraryDatabaseMock, times(0)).listBookWithCondition(anyString());

        }

        @DisplayName("Test - get book results from fragment")
        @Test
        void testListBookWithConditionReturnList() {
            //GIVEN
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> bookList = new ArrayList<>();
            Book newBook1 = new Book("Wiedzmin 1","Sapkowski", 1990);
            Book newBook2 = new Book("Wiedzmin 2","Sapkowski", 1990);
            Book newBook3 = new Book("Wiedzmin 3","Sapkowski", 1990);
            Book newBook4 = new Book("Wiedzmin 4","Sapkowski", 1990);
            bookList.add(newBook1);
            bookList.add(newBook2);
            bookList.add(newBook3);
            bookList.add(newBook4);
            String fragment = "Wiedzmin";
            when(libraryDatabaseMock.listBookWithCondition(fragment)).thenReturn(bookList);

            //when
            List<Book> resultList = bookLibrary.listBookWithCondition(fragment);
            //then
            Assertions.assertEquals(4, resultList.size());
        }

        @Test
        void testUserHasNoBooks() {
            //GIVEN
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> bookList = new ArrayList<>();
            LibraryUser user = new LibraryUser("Mike", "Diamond", "123456789");
            when(libraryDatabaseMock.listBookInHandOf(user)).thenReturn(bookList);
            //WHEN
            List<Book> result = bookLibrary.listBookInHandOf(user);
            //THEN
            Assertions.assertEquals(0, result.size());
        }

        @Test
        void testUserHasOneBook() {
            //GIVEN
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("Mike", "Diamond", "123456789");
            List<Book> bookList = new ArrayList<>();
            Book book1 = new Book("title 1", "author 1", 1990);
            bookList.add(book1);
            when(libraryDatabaseMock.listBookInHandOf(user)).thenReturn(bookList);
            //WHEN
            List<Book> result = bookLibrary.listBookInHandOf(user);
            //THEN
            Assertions.assertEquals(1, result.size());
            verify(libraryDatabaseMock, times(1)).listBookInHandOf(any());
        }

        @Test
        void testUserHasFiveBooks() {
            //GIVEN
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser user = new LibraryUser("John", "Smith", "5557779990");
            List<Book> bookList = generateBookList(5);
            when(libraryDatabaseMock.listBookInHandOf(user)).thenReturn(bookList);

            //WHEN
            List<Book> resultBookList = bookLibrary.listBookInHandOf(user);

            //THEN
            Assertions.assertEquals(5, resultBookList.size());
            verify(libraryDatabaseMock, times(1)).listBookInHandOf(user);
        }
    }