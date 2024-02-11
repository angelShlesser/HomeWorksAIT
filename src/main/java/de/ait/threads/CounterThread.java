package de.ait.threads;

public class CounterThread extends Thread {

    private Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            counter.increment();
            System.out.println(super.getName() + " i = " + i + " counter " + counter.getCount());
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException exception) {
            System.out.println("ERROR!!! " + exception.getMessage());
        }
    }
}
