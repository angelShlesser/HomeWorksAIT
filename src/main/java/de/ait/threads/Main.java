package de.ait.threads;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterThread threadOne = new CounterThread(counter);
        CounterThread threadTwo = new CounterThread(counter);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Counter --> " + counter.getCount());
    }
}
