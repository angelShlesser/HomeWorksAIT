package de.ait.homeworks41;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    //Создайте объект HashSet<String> с названием countriesSet.
    private static Set<String> countriesSet = new HashSet<>();

    public static void main(String[] args) {
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
        showAllCountries();
    }

    private static void showAllCountries() {
        System.out.println("Элементы HashSet:");
        for (String country : countriesSet) {
            System.out.println(country);
        }
    }

    ////Проверьте, содержит ли countriesSet страну "Испания".
    private static void addCountries(String countries) {
        if (!countriesSet.contains(countries)) {
            countriesSet.add(countries);
            System.out.println("В список HashSet добавлена " + countries);
        } else {
            System.out.println("В списке уже есть: " + countries);
        }
    }
}
