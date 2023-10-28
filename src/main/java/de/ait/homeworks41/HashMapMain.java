package de.ait.homeworks41;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapMain {
    public static void main(String[] args) {
        // Создайте объект HashMap<String, String> с названием capitalMap.
        Map<String, String> capitalMap = new HashMap<>();
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
        for(Map.Entry<String,String> entry: capitalMap.entrySet()){
            System.out.println("Страна: " + entry.getKey() + " - Столица: " + entry.getValue());
        }
        //Замените столицу США с Вашингтона на Сан-Франциско и выведите capitalMap снова.
        capitalMap.put("США", "Сан-Франциско");
        System.out.println("-----");
        for(Map.Entry<String,String> entry: capitalMap.entrySet()){
            System.out.println("Страна: " + entry.getKey() + " - Столица: " + entry.getValue());
        }
        //Дополнительно задание:
        //Создайте объект HashSet<String> с названием countriesSet.
        Set<String> countriesSet = new HashSet<>();
        //Добавьте в countriesSet те же страны, что и в countriesList.
        countriesSet.add("США");
        countriesSet.add("Великобритания");
        countriesSet.add("Франция");
        countriesSet.add("Чехия");
        countriesSet.add("Германия");
        countriesSet.add("Франция");
        //Проверьте, содержит ли countriesSet страну "Испания".
        System.out.println("-----");
        if(!countriesSet.contains("Испания")){
            System.out.println("Нет страны в списке: Испания");
            //Если нет, добавьте "Испания" в countriesSet
            countriesSet.add("Испания");
            System.out.println("В список HashSet добавлена Испания");
            //"Мадрид" в capitalMap как столицу Испании.
            capitalMap.put("Испания", "Мадрид");
            System.out.println(capitalMap);
            System.out.println("----");
            for(Map.Entry<String,String> entry: capitalMap.entrySet()){
                System.out.println("Страна: " + entry.getKey() + " - Столица: " + entry.getValue());
            }
        }
    }
}
