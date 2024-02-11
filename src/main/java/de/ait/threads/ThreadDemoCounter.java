package de.ait.threads;

public class ThreadDemoCounter  extends Thread{

    private Thread thread;
    private String threadname;

    CounterPrinter counterPrinter;

    public ThreadDemoCounter(String threadname, CounterPrinter counterPrinter) {
        this.threadname = threadname;
        this.counterPrinter = counterPrinter;
    }

    @Override
    public void run(){
        synchronized (counterPrinter) {
            System.out.println (threadname + "-->");
            counterPrinter.print();
        }
        if(thread.getName().equals("Thread -1")){
            this.threadname = "Thread-One";
        }
        System.out.println("Thread --> " + threadname + " is done");
    }

    public void start(){
        System.out.println("Start thread "+ threadname);
        if(thread == null){
            thread = new Thread(this, threadname);
            thread.start();
        }
    }
}
