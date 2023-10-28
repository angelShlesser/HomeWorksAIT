package de.ait.homeworks41;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
    // Создайте объект HashMap<String, String> с названием capitalMap.
    private static Map<String, String> capitalMap = new HashMap<>();

    public static void main(String[] args) {
        //Добавьте следующие страны и их столицы:
        //- Чехия - Прага - США - Вашингтон - Великобритания - Лондон
        //- Франция - Париж - Германия - Берлин c. Выведите на экран размер capitalMap.
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
        addOrUpdateCapital("Испания", "Мадрид");
        System.out.println("----");
        showAllMap();
        addOrUpdateCapital("Испания", "Бавария");
        showAllMap();
    }

    private static void showAllMap() {
        System.out.println("Весь список:");
        capitalMap.forEach((country, capital) -> {
            System.out.println("Страна: " + country + ", Столица: " + capital);
        });
    }

    private static void addOrUpdateCapital(String country, String capital) {
        if (!capitalMap.containsKey(country)) {
            capitalMap.put(country, capital);
            System.out.println("В список HashMap добавлена столица для страны: " + country);
        } else {
            System.out.println("В списке уже есть столица для страны: " + country);
        }
    }
}
