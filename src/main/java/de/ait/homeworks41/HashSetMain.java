package de.ait.homeworks41;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    //Создайте объект HashSet<String> с названием countriesSet.
    private static Set<String> countriesSet = new HashSet<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(HashSetMain.class);
    public static void main(String[] args) {
        //Добавьте в countriesSet те же страны, что и в countriesList.
        countriesSet.add("США");
        countriesSet.add("Великобритания");
        countriesSet.add("Франция");
        countriesSet.add("Чехия");
        countriesSet.add("Германия");
        countriesSet.add("Франция");
        // Выведите на экран размер countriesSet.
        LOGGER.info("Размер HashSet: {}",countriesSet.size());
        // Выведите на экран все элементы countriesSet.
        LOGGER.info("------");
        showAllCountries();
        addNewCountry("Франция");
    }

    private static void showAllCountries() {
        LOGGER.info("Элементы HashSet:");
        for (String country : countriesSet) {
            LOGGER.info(country);
        }
    }

    ////Проверьте, содержит ли countriesSet страну "Испания".
    private static boolean checkCountry(String countryNameKey) {
        return countriesSet.contains(countryNameKey);
    }

    private static boolean addNewCountry(String countryNameKey) {
        if (!checkCountry(countryNameKey)) {
            countriesSet.add(countryNameKey);
            LOGGER.info("Страна успешно добавлена {}",countryNameKey);
            return true;
        } else {
            LOGGER.error("Страна не добавлена {}",countryNameKey);
            return false;
        }
    }
}
