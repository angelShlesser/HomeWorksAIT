package de.ait.homeworks44;

import java.util.Scanner;

public class LibraryApp {
    private LibraryCatalog catalog = new LibraryCatalog();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Удалить книгу");
            System.out.println("3. Найти книгу по названию");
            System.out.println("4. Вывести список всех книг");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Чтобы считать символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    listAllBooks();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }

        scanner.close();
    }

    private void addBook() {
        System.out.print("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.print("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.print("Введите год книги: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите isbn книги: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, year, isbn);
        catalog.addBook(book);
    }

    private void removeBook() {
        System.out.print("Введите название книги для удаления: ");
        String title = scanner.nextLine();
        catalog.removeBook(title);
    }

    private void findBookByTitle() {
        System.out.print("Введите название книги для поиска: ");
        String title = scanner.nextLine();

        catalog.findBookByTitle(title);

    }

    private void listAllBooks() {
        System.out.println("Список всех книг:");
        catalog.listAllBooks();
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        Book book1 = new Book("Думай и богатей", "Наполеон Хилл", 1937, "1234567890");
        Book book2 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1967, "9876543210");
        Book book3 = new Book("1984", "Джордж Оруэлл", 1949, "5555555555");
        Book book4 = new Book("Преступление и наказание", "Федор Достоевский", 1866, "4444444444");
        Book book5 = new Book("Война и мир", "Лев Толстой", 1869, "1111111111");
        LibraryCatalog libraryCatalog = new LibraryCatalog();
        libraryCatalog.addBook(book1);
        libraryCatalog.addBook(book2);
        libraryCatalog.addBook(book3);
        libraryCatalog.addBook(book4);
        libraryCatalog.addBook(book5);
        libraryCatalog.addBook(book3);
        libraryCatalog.listAllBooks();
        libraryCatalog.findBookByTitle("1984");
        libraryCatalog.removeBook("5555555555");
        System.out.println("Количество книг: " + libraryCatalog.getBookList().size());
        //app.run();
    }
}

