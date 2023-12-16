package de.ait.threads;

public class TestDemoThreadRunnable {
    public static void main(String[] args) {
        DemoThreadRunnable demo =new DemoThreadRunnable("Thread 1");
        demo.start();
        DemoThreadRunnable secondDemo = new DemoThreadRunnable("Thread 2");
        secondDemo.start();
        DemoThreadRunnable thirdDemo = new DemoThreadRunnable("Thread 3");
        thirdDemo.start();
    }
}
