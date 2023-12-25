package de.ait.threads;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoThreadExtends extends  Thread{
    // Логгер для этого класса
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoThreadExtends.class);

    private Thread thread;
    private String threadName;

    public DemoThreadExtends(String name) {
        this.threadName = name;
        LOGGER.info("Creating thread: {}", threadName);
    }
    public void run() {
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
            Thread.currentThread().interrupt();
            // Обрабатываем исключение, если поток был прерван во время сна
            LOGGER.warn("Thread {} was interrupted while sleeping.", threadName, e);
        } catch (Exception exception) {
            // Обрабатываем другие исключения
            LOGGER.error("Exception in thread {}", threadName, exception);
        }

        LOGGER.info("Thread {} is finished {}.", threadName, thread.isAlive());
    }

    public void start (){
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
    }
}
