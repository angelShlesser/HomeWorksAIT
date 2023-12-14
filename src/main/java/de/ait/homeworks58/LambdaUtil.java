package de.ait.homeworks58;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class LambdaUtil {
    // Логгер для этого класса
    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaUtil.class);

    public static void main(String[] args) {
        // Создаем список строк
        List<String> strings = Arrays.asList("Арбуз", "Банан", "Апельсин", "Груша", "Авокадо");

        // Используем Stream API и метод filter для отфильтровки строк, начинающихся с буквы "А"
        List<String> filteredStrings = strings.stream()
                .filter(s -> s.startsWith("А"))
                .toList();

        // Выводим отфильтрованные строки на экран
        LOGGER.info("Отфильтрованные строки: {}", filteredStrings);

        // Создаем список целых чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Используем Stream API и метод map для преобразования каждого числа в его квадрат
        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number)
                .toList();

        // Выводим результат на экран
        LOGGER.info("Квадраты чисел: {}", squaredNumbers);

        // Используем Stream API и лямбда-выражение для фильтрации четных чисел и их вывода на экран
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(evenNumber -> LOGGER.info("Четное число: {}", evenNumber));

        // Используем метод forEach с лямбда-выражением для печати каждого элемента списка
        numbers.forEach(number -> LOGGER.info("Элемент списка: {}", number));

        // Создаем список строк
        List<String> stringsTwo = Arrays.asList("яблоко", "банан", "апельсин", "виноград");

        // Используем Stream API и метод map для преобразования строк в верхний регистр
        List<String> upperCaseStrings = stringsTwo.stream()
                .map(String::toUpperCase) // Используем метод toUpperCase для каждой строки
                .toList();

        // Выводим результат на экран
        LOGGER.info("Строки в верхнем регистре: {}", upperCaseStrings);

        List<String> cities = Arrays.asList("Paris", "London", "Berlin", "Madrid", "Lisbon");
        //Запускаем поток --> фильтруем те что начинаются на L --> перевод в верхний регистр --> отсортировать
        cities.stream()
                // Фильтруем города, оставляя только те, что начинаются на L
                .filter(capital -> capital.startsWith("L"))
                // Преобразуем города в верхний регистр
                .map(String::toUpperCase)
                .sorted()
                // Выводим результат на экран
                .forEach(city -> LOGGER.info("Результат: {}", city));
    }
}