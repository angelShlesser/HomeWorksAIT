package de.ait.homeworks58;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filterMethod {
    public static void main(String[] args) {
        // Создаем список строк
        List<String> strings = Arrays.asList("Арбуз", "Банан", "Апельсин", "Груша", "Авокадо");

        // Используем Stream API и метод filter для отфильтровки строк, начинающихся с буквы "А"
        List<String> filteredStrings = strings.stream()
                .filter(s -> s.startsWith("А"))
                .toList();

        // Выводим отфильтрованные строки на экран
        filteredStrings.forEach(System.out::println);

        // Создаем список целых чисел
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Используем Stream API и метод map для преобразования каждого числа в его квадрат
        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number)
                .toList();

        // Выводим результат на экран
        squaredNumbers.forEach(System.out::println);

        // Используем Stream API и лямбда-выражение для фильтрации четных чисел и их вывода на экран
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
        // Используем метод forEach с лямбда-выражением для печати каждого элемента списка
        numbers.forEach(System.out::println);

        // Создаем список строк
        List<String> stringsTwo = Arrays.asList("apple", "banana", "orange", "grape");

        // Используем Stream API и метод map для преобразования строк в верхний регистр
        List<String> upperCaseStrings = stringsTwo.stream()
                .map(String::toUpperCase) // Используем метод toUpperCase для каждой строки
                .toList();

        // Выводим результат на экран
        upperCaseStrings.forEach(System.out::println);
    }
}
