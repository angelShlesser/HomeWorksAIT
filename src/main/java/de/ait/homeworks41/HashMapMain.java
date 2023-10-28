package de.ait.homeworks41;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    // Создайте объект HashMap<String, String> с названием capitalMap.
    private static Map<String, String> capitalMap = new HashMap<>();

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
        System.out.println("Размер capitalMap: " + capitalMap.size());
        //Используя цикл, выведите все пары страна-столица из capitalMap
        System.out.println("------");
        showAllMap();
        //Замените столицу США с Вашингтона на Сан-Франциско и выведите capitalMap снова.
        capitalMap.replace("США", "Сан-Франциско");
        System.out.println("-----");
        showAllMap();
        //"Мадрид" в capitalMap как столицу Испании.
        addNewCountry("Испания", "Мадрид");
        System.out.println("----");
        showAllMap();
        addNewCountry("Испания", "Бавария");
    }

    private static void showAllMap() {
        System.out.println("Весь список:");
        capitalMap.forEach((country, capital) -> System.out.println("Страна: " + country + ", Столица: " + capital));
    }

    private static boolean checkCountry(String countryNameKey) {
        return capitalMap.containsKey(countryNameKey);
    }

    private static boolean addNewCountry(String countryNameKey, String countryNameValue) {
        if (!checkCountry(countryNameKey)) {
            capitalMap.put(countryNameKey, countryNameValue);
            System.out.println("Страна успешно добавлена " + countryNameKey + " --> " + countryNameValue);
            return true;
        } else {
            System.out.println("Страна уже есть в списке " + countryNameKey);
            return false;
        }
    }
}
