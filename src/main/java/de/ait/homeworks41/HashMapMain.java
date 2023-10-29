package de.ait.homeworks41;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    // Создайте объект HashMap<String, String> с названием capitalMap.
    private static Map<String, String> capitalMap = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(HashMapMain.class);

    public static void main(String[] args) {
        //Добавьте следующие страны и их столицы:
        //- Чехия - Прага - США - Вашингтон - Великобритания - Лондон
        //- Франция - Париж - Германия - Берлин. Выведите на экран размер capitalMap.
        capitalMap.put("Чехия", "Прага");
        capitalMap.put("США", "Вашингтон");
        capitalMap.put("Великобритания", "Лондон");
        capitalMap.put("Франция", "Париж");
        capitalMap.put("Германия", "Берлин");
        //Выведите на экран размер capitalMap.
        LOGGER.info("Размер capitalMap: {}",capitalMap.size());
        //Используя цикл, выведите все пары страна-столица из capitalMap
        showAllMap();
        //Замените столицу США с Вашингтона на Сан-Франциско и выведите capitalMap снова.
        capitalMap.replace("США", "Сан-Франциско");
        showAllMap();
        //"Мадрид" в capitalMap как столицу Испании.
        addNewCountry("Испания", "Мадрид");
        showAllMap();
        addNewCountry("Испания", "Бавария");
    }

    private static void showAllMap() {
        LOGGER.info("Весь список:");
        capitalMap.forEach((country, capital) -> LOGGER.info("Страна: {}, Столица: {}",country, capital));
    }

    private static boolean checkCountry(String countryNameKey) {
        return capitalMap.containsKey(countryNameKey);
    }

    private static boolean addNewCountry(String countryNameKey, String countryNameValue) {
        if (!checkCountry(countryNameKey)) {
            capitalMap.put(countryNameKey, countryNameValue);
            LOGGER.info("Страна успешно добавлена {} --> {}",countryNameKey, countryNameValue);
            return true;
        } else {
            LOGGER.info("Страна уже есть в списке {}",countryNameKey);
            return false;
        }
    }
}
