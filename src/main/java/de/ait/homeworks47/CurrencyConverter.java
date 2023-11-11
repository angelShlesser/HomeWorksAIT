package de.ait.homeworks47;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverter.class);
    private static final double USD = 1.2;
    private static final double EURO = 0.85;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        convertCurrency();
    }

    private static void convertCurrency() {
        double amount = scannerUser();
        String core;
        double result;

        do {
            System.out.println("Введите валюту для конвертации (например, usd, euro):");
            core = scanner.nextLine().toLowerCase();

            switch (core) {
                case "usd":
                    result = amount * USD;
                    break;
                case "euro":
                    result = amount * EURO;
                    break;
                default:
                    LOGGER.error("Некорректный код валюты: {}", core);
                    System.out.println("Некорректный код валюты. Повторите ввод.");
                    continue; // Повторяем цикл при дефолтном варианте
            }

            LOGGER.info("Выполнена конвертация: {}", result);
            System.out.println("Конвертация: " + result);
        } while (false); // Можно использовать другое условие для повторного ввода
    }

    private static double scannerUser() {
        double result = 0;

        while (true) {
            try {
                System.out.println("Введите сумму для конвертации:");
                LOGGER.info("Получение информации о конвертации");
                result = scanner.nextDouble();
                scanner.nextLine(); // Очистка буфера ввода
                break; // Выходим из цикла при успешном вводе
            } catch (InputMismatchException exception) {
                LOGGER.error("Ошибка ввода. Пожалуйста, введите числовое значение.", exception);
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return result;
    }
}