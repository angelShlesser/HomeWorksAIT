package de.ait.homeworks35;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
    }

    @Test
    void addBook() {
        Book book = new Book("1234567890", "Sample Book", "John Doe");
        bookManager.addBook(book);

        // Проверяем, что книга добавлена успешно
        assertTrue(bookManager.findBookByISBN("1234567890") != null);
    }

    @Test
    void testAddDuplicateBook() {
        Book book1 = new Book("1234567890", "Sample Book 1", "John Doe");
        Book book2 = new Book("1234567890", "Sample Book 2", "Jane Smith");

        // Добавляем первую книгу
        bookManager.addBook(book1);

        // Пытаемся добавить вторую книгу с тем же ISBN
        Assertions.assertThrows(IllegalArgumentException.class, () -> {bookManager.addBook(book2);});
    }

    @Test
    void removeBook() {
        Book book = new Book("1234567890", "Sample Book", "John Doe");
        bookManager.addBook(book);

        // Проверяем, что книга была успешно удалена
        assertTrue(bookManager.removeBook("1234567890"));
        // Проверяем, что книги больше нет в списке
        assertNull(bookManager.findBookByISBN("1234567890"));
    }

    @Test
    void testRemoveNonExistentBook() {
        // Пытаемся удалить книгу, которой нет в списке
        assertFalse(bookManager.removeBook("9876543210"));
    }
    @Test
    void testFindBookByNullISBN() {
        Book book1 = new Book("1234567890", "Sample Book 1", "John Doe");
        bookManager.addBook(book1);

        // Попытка поиска с null вместо ISBN
        Book result = bookManager.findBookByISBN(null);

        // Ожидаем, что результат поиска будет null, так как мы передали null вместо ISBN
        assertNull(result);
    }
    @Test
    void testFindBookByISBN() {
        // Проверьте нахождение книги по её ISBN
        Book book = new Book("1234567890", "Sample Book 1", "John Doe");
        bookManager.addBook(book);

        Book result = bookManager.findBookByISBN("1234567890");

        assertNotNull(result);
        assertEquals("Sample Book 1", result.getTitle());
    }
}