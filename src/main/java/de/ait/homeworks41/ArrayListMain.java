package de.ait.homeworks41;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    // Создайте объект ArrayList<String> с названием countriesList.
    private static List<String> countriesList = new ArrayList<>();

    public static void main(String[] args) {
        //Добавьте в countriesList следующие страны:
        //США, Великобритания, Франция, Чехия, Германия, Франция
        countriesList.add("США");
        countriesList.add("Великобритания");
        countriesList.add("Франция");
        countriesList.add("Чехия");
        countriesList.add("Германия");
        countriesList.add("Франция");
        //Выведите на экран размер countriesList.
        System.out.println("Размер countriesList: " + countriesList.size());
        //Выведите на экран все элементы countriesList в исходном порядке.
        showAllCountries();
        System.out.println("=====");
        //Поиск и удаление дубликатов
        removeDuplicates();
        //Вывод список без дубликатов
        System.out.println("======");
        showAllCountries();
        //Вывод размера после удаления дубликатов
        System.out.println("======");
        System.out.println("Размер countriesList: " + countriesList.size());
        }
    //Метод для вывода всей countriesList
    private static void showAllCountries(){
        System.out.println("Выводим весь countriesList:");
        for (String countries : countriesList) {
            System.out.println(countries);
        }
    }
    //Метод для удаления дубликатов countriesList
    private static  void removeDuplicates(){
        // Создайте новый ArrayList для хранения уникальных стран
        List<String> uniqueCountries = new ArrayList<>();
        for (String country : countriesList) {
            if (!uniqueCountries.contains(country)) {
                uniqueCountries.add(country);
            }
        }
        countriesList= new ArrayList<>(uniqueCountries);
        System.out.println("Дубликаты были удалены");
    }
}
