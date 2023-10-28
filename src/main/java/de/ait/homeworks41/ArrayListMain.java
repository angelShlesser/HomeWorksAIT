package de.ait.homeworks41;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListMain {
    public static void main(String[] args) {
        // Создайте объект ArrayList<String> с названием countriesList.
        List<String> countriesList = new ArrayList<>();
        //Добавьте в countriesList следующие страны:
        //США, Великобритания, Франция, Чехия, Германия, Франция
        countriesList.add("США");
        countriesList.add("Великобритания");
        countriesList.add("Франция");
        countriesList.add("Чехия");
        countriesList.add("Германия");
        countriesList.add("Франция");
        //Выведите на экран размер countriesList.
        System.out.println("Размер листа:");
        System.out.println(countriesList.size());
        //Выведите на экран все элементы countriesList в исходном порядке.
        System.out.println("------");
        System.out.println("Выводим лист:");
        for (String list: countriesList){
            System.out.println(list);
        }
        //Удалите дубликаты из countriesList и выведите список снова.
        countriesList.add("США");
        countriesList.add("Германия");
        //Вывод списка для проверки
        System.out.println("------");
        System.out.println("Выводим лист c дубликатами:");
        for (String list: countriesList){
            System.out.println(list);
        }
        //Поиск и удаление дубликатов
        Set<String> result = new HashSet<>(countriesList);
        countriesList.clear();
        countriesList.addAll(result);
        System.out.println("------");
        System.out.println("Лист после удаления дубликатов:");
        for(String list:countriesList){
            System.out.println(list);
        }

    }
}
