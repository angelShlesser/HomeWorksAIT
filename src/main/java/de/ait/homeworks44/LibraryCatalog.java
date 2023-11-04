package de.ait.homeworks44;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LibraryCatalog {
    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryCatalog.class);
    private List<Book> bookList = new ArrayList<>();

    public boolean addBook(Book addBook) {
        if (bookList == null) {
            LOGGER.error("Книга с названием null");
            return false;
        } else {
            LOGGER.info("Книга добавлена: {}", addBook.getTitle());
            return bookList.add(addBook);
        }
    }

    public boolean removeBook(String isbn) {
        int counter = 0;
        if(isbn == null){
            LOGGER.error("Введен Null");
            return false;
        }
        Iterator<Book> iterator = bookList.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)) {
                counter++;
                iterator.remove();
                LOGGER.info("Книга с названием '{}' была удалена из каталога. ISBN {}", book.getTitle(), isbn);
            }
        }
        if (counter == 0 ){
            LOGGER.warn("Книга с isbn '{}' не найдена в каталоге.", isbn);
            return false;
        }
        else {
            LOGGER.info("Было удалено {} с ISBN {}", counter, isbn);
            return true;
        }
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> booksToReturn = new ArrayList<>();
        if (title == null) {
            LOGGER.error("Книга с названием null");
            return null;
        } else {

            for (Book book : bookList) {
                if (book.getTitle().equals(title)) {
                    LOGGER.info("Книга с название {} найдена", title);
                    booksToReturn.add(book);
                }
            }
            LOGGER.info("Было найдено {} книг с названием {}", booksToReturn.size(),title);
            return booksToReturn;
        }
    }
    public void listAllBooks() {
       if(bookList.isEmpty()){
           LOGGER.warn("В библиотеке нет книг");
       }
       else {
           for (Book book: bookList){
               LOGGER.info(book.toString());
           }
       }
    }

    public List<Book> getBookList() {
        return new ArrayList<>(bookList);
    }
}
