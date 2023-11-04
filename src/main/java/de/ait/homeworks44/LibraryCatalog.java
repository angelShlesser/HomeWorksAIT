package de.ait.homeworks44;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryCatalog {
    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryCatalog.class);
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        if (!bookList.contains(book)) {
            bookList.add(book);
            LOGGER.info("Книга добавлена: {}", book.getTitle());
        } else {
            LOGGER.error("Книга уже существует в каталоге: {}", book.getTitle());
        }
    }

    public void removeBook(String title) {
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
                LOGGER.info("Книга с названием '{}' была удалена из каталога.", title);
                return;
            }
        }
        LOGGER.error("Книга с названием '{}' не найдена в каталоге.", title);
    }

    public Book findBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                LOGGER.info("Книга найдена: {}", title);
                return book;
            }
        }
        LOGGER.error("Книга не найдена: {}", title);
        return null;
    }

    public List<Book> listAllBooks() {
        return new ArrayList<>(bookList);
    }
}
