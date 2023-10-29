package de.ait.homeworks41;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    // Создайте объект ArrayList<String> с названием countriesList.
    private static List<String> countriesList = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayListMain.class);
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
        LOGGER.info("Размер countriesList: {}",countriesList.size());
        //Выведите на экран все элементы countriesList в исходном порядке.
        showAllCountries();
        //Поиск и удаление дубликатов
        removeDuplicates();
        //Вывод список без дубликатов
        showAllCountries();
        //Вывод размера после удаления дубликатов
        LOGGER.info("Размер countriesList: {}",countriesList.size());
        }
    //Метод для вывода всей countriesList
    private static void showAllCountries(){
        LOGGER.info("Выводим весь countriesList:");
        for (String countries : countriesList) {
            LOGGER.info(countries);
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
        LOGGER.info("Дубликаты были удалены");
    }
}
