package de.ait.homeworks47;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverter.class);
    private static final double USD_RATE = 1.2;
    private static final double EURO_RATE = 0.85;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        convertCurrency();
    }

    private static void convertCurrency() {
        double amount = scannerUser();
        String core;
        double result;

        while (true) {
            System.out.println("Введите валюту для конвертации (например, usd, euro):");
            core = scanner.nextLine().toLowerCase();

            try {
                switch (core) {
                    case "usd":
                        result = convert(amount, USD_RATE);
                        break;
                    case "euro":
                        result = convert(amount, EURO_RATE);
                        break;
                    default:
                        LOGGER.error("Некорректный код валюты: {}", core);
                        throw new IllegalArgumentException("Некорректный код валюты: " + core);
                }

                LOGGER.info("Выполнена конвертация: {}", result);
                System.out.println("Конвертация: " + result);
                break; // Выходим из цикла после успешной конвертации

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                scanner.nextLine(); // Сбросить буфер после ошибки
            }
        }

        System.out.println("Операция конвертации завершена.");
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
                System.out.println("Ошибка ввода. Пожалуйста, введите числовое значение.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return result;
    }

    private static double convert(double amount, double rate) {
        return amount * rate;
    }
}