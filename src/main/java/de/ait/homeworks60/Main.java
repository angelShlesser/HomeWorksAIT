package de.ait.homeworks60;

public class Main {
    public static void main(String[] args) {
        Task taskOne = new Task("Hallo Java");
        Task taskTwo = new Task("Hallo Python");
        Task taskThree = new Task("Hallo JavaScript");
        Thread threadOne = new Thread(taskOne);
        Thread threadTwo = new Thread(taskTwo);
        Thread threadThree = new Thread(taskThree);
        threadOne.start();
        threadTwo.start();
        threadThree.start();

        MyTask myTask = new MyTask();
        Thread threadMyTask = new Thread(myTask);
        Thread threadMyTaskSecond = new Thread(myTask);
        threadMyTask.start();
        threadMyTaskSecond.start();
    }
}
