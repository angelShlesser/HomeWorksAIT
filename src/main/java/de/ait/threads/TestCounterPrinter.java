package de.ait.threads;

public class TestCounterPrinter {

    public static void main(String[] args) {
        CounterPrinter counterPrinter = new CounterPrinter();

        ThreadDemoCounter threadDemoCounter = new ThreadDemoCounter("Thread -1", counterPrinter);
        ThreadDemoCounter threadDemoCounterSecond = new ThreadDemoCounter("Thread -2", counterPrinter);

        threadDemoCounter.start();
        threadDemoCounterSecond.start();

        try {
            threadDemoCounter.join();
            threadDemoCounterSecond.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }


    }

}
