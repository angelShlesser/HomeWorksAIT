package de.ait.homeworks60;

public class Task implements Runnable {

    private String string;


    // Конструктор, принимающий строковый параметр
    public Task(String string) {
        this.string = string;
    }
    @Override
    public void run() {
        // Выводим строку, переданную в конструкторе
        System.out.println(string);
    }
}
