package de.ait.homeworks35;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private String isbn = "1234567890";
    private String title = "Sample Book";
    private String author = "John Doe";
    private Book book;
    @BeforeEach
    void setUp() {
        book = new Book(isbn, title, author);
    }

    @Test
    @DisplayName("Constructor Test")
    void testBookConstructor() {

        assertEquals(isbn, book.getIsbn());
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
    }

    @Test
    @DisplayName("Test Isbn display GET")
    void getIsbn() {
        assertEquals("1234567890", book.getIsbn());
    }

    @Test
    @DisplayName("Test Isbn display SET")
    void setIsbn() {
        book.setIsbn("445666");
        assertEquals("445666",book.getIsbn());
    }

    @Test
    void getTitle() {
        assertEquals("Sample Book",book.getTitle());
    }

    @Test
    void setTitle() {
        book.setTitle("New Book");
        assertEquals("New Book",book.getTitle());
    }

    @Test
    void getAuthor() {
        assertEquals("John Doe",book.getAuthor());
    }

    @Test
    void setAuthor() {
        book.setAuthor("Alex Doe");
        assertEquals("Alex Doe",book.getAuthor());
    }
}