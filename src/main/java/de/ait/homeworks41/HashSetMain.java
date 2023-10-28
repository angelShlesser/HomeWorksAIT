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
        addNewCountry("Франция");
    }

    private static void showAllCountries() {
        System.out.println("Элементы HashSet:");
        for (String country : countriesSet) {
            System.out.println(country);
        }
    }

    ////Проверьте, содержит ли countriesSet страну "Испания".
    private static boolean checkCountry(String countryNameKey) {
        return countriesSet.contains(countryNameKey);
    }

    private static boolean addNewCountry(String countryNameKey) {
        if (!checkCountry(countryNameKey)) {
            countriesSet.add(countryNameKey);
            System.out.println("Страна успешно добавлена " + countryNameKey);
            return true;
        } else {
            System.out.println("Страна не добавлена " + countryNameKey);
            return false;
        }
    }
}
