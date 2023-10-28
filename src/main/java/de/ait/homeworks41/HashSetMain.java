package de.ait.homeworks41;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        //Создайте объект HashSet<String> с названием countriesSet.
        Set<String> countriesSet = new HashSet<>();
        //Добавьте в countriesSet те же страны, что и в countriesList.
        countriesSet.add("США");
        countriesSet.add("Великобритания");
        countriesSet.add("Франция");
        countriesSet.add("Чехия");
        countriesSet.add("Германия");
        countriesSet.add("Франция");
        // Выведите на экран размер countriesSet.
        System.out.println("Размер HashSet: " + countriesSet.size());
        // Выведите на экран все элементы countriesSet.
        System.out.println("------");
        System.out.println("Элементы HashSet:");
        for (String country : countriesSet) {
            System.out.println(country);
        }

    }
}
