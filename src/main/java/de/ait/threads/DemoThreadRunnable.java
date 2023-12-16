package de.ait.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoThreadRunnable implements Runnable {
    // Логгер для этого класса
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoThreadRunnable.class);

    private Thread thread;
    private String threadName;

    // Конструктор класса, принимает имя потока
    public DemoThreadRunnable(String threadName) {
        this.threadName = threadName;
        LOGGER.info("Creating thread: {}", threadName);
    }

    // Метод, который будет выполняться при запуске потока
    @Override
    public void run() {
        LOGGER.info("Running thread: {}", Thread.currentThread().getName()); // Используем метод Thread.currentThread() для получения текущего потока
        if (threadName.equals("Thread 1")) {
            thread.setPriority(10);
            thread.setName("Thread One!");
        }
        if (threadName.equals("Thread 2")) {
            thread.setPriority(1);
            thread.setName("Thread Two!");
            try {
                thread.join(1000);
            } catch (InterruptedException e) {
                LOGGER.error("Interrupted!", e);
            }
        }
        try {
            for (int i = 4; i > 0; i--) {
                LOGGER.info("Thread name: {}, i: {}", thread.getName(), i);

                // Засыпаем поток на 100 миллисекунд
                Thread.sleep(100);

                // Прерываем поток (необязательно делать это здесь, зависит от вашей логики)
                // thread.interrupt();

                // Выводим информацию о состоянии потока
                LOGGER.info("Thread name: {} State: {}", thread.getName(), thread.getState().name());
            }
        } catch (InterruptedException e) {
            // Обрабатываем исключение, если поток был прерван во время сна
            LOGGER.warn("Thread {} was interrupted while sleeping.", threadName, e);
        } catch (Exception exception) {
            // Обрабатываем другие исключения
            LOGGER.error("Exception in thread {}", threadName, exception);
        }

        LOGGER.info("Thread {} is finished {}.", threadName, thread.isAlive());
    }

    // Метод для запуска потока
    public void start() {
        LOGGER.info("Start thread: {}", threadName);
        if (thread == null) {
            // Создаем новый поток и передаем ему текущий объект DemoThreadRunnable
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}