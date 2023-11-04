package de.ait.homeworks44;

import java.util.Scanner;

public class LibraryApp {
    private LibraryCatalog catalog;
    private Scanner scanner;

    public LibraryApp() {
        catalog = new LibraryCatalog();
        scanner = new Scanner(System.in);
    }

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

        Book book = new Book(title, author, year);
        catalog.addBook(book);
        System.out.println("Книга добавлена.");
    }

    private void removeBook() {
        System.out.print("Введите название книги для удаления: ");
        String title = scanner.nextLine();

        catalog.removeBook(title);
        System.out.println("Книга удалена.");
    }

    private void findBookByTitle() {
        System.out.print("Введите название книги для поиска: ");
        String title = scanner.nextLine();

        Book foundBook = catalog.findBookByTitle(title);

        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook.getTitle() + " (Автор: " + foundBook.getAuthor() + ")");
        } else {
            System.out.println("Книга не найдена.");
        }
    }

    private void listAllBooks() {
        System.out.println("Список всех книг:");
        for (Book book : catalog.listAllBooks()) {
            System.out.println(book.getTitle() + " (Автор: " + book.getAuthor() + ")");
        }
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}

