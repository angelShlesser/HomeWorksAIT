package de.ait.homeworks61;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SommelierThread extends Thread{

    private static final Logger LOGGER = LoggerFactory.getLogger(SommelierThread.class);


    private String wineName;

    public SommelierThread(String wineName) {
        this.wineName = wineName;
    }

    public void run() {
       LOGGER.info("Выбираю вино");
        try {
            Thread.sleep(2000);
            LOGGER.info("Вино выбрано: {}", wineName);
        } catch (InterruptedException e) {
            LOGGER.error("ERROR !!! Ошибка");
        }
    }
}
