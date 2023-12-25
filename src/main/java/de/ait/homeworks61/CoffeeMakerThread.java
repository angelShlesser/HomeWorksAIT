package de.ait.homeworks61;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoffeeMakerThread  extends Thread{
    private static final Logger LOGGER = LoggerFactory.getLogger(CoffeeMakerThread.class);

    public void run(){
        LOGGER.info("Кофе мелется");
        try {
            Thread.sleep(2000);
            LOGGER.info("Кофе заваривается");
            Thread.sleep(5000);
            LOGGER.info("Кофе готов");
        } catch (InterruptedException exception) {
            LOGGER.error("ERROR !!! Ошибка");
        }
    }

}
