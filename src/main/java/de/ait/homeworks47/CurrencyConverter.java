package de.ait.homeworks47;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverter.class);
    private static final double usdRate = 1.2;
    private static final double euroRate = 0.85;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        performCurrencyConversion();
    }

    private static void performCurrencyConversion() {
        double amount = scannerUser();
        String currencyCode;
        double result;

        while (true) {
            System.out.println("Введите код валюты для конвертации (например, usd, euro):");
            currencyCode = scanner.nextLine().toLowerCase();

            try {
                switch (currencyCode) {
                    case "usd":
                        result = convert(amount, usdRate);
                        break;
                    case "euro":
                        result = convert(amount, euroRate);
                        break;
                    default:
                        LOGGER.error("Некорректный код валюты: {}", currencyCode);
                        throw new IllegalArgumentException("Некорректный код валюты: " + currencyCode);
                }

                LOGGER.info("Выполнена конвертация {} {} в {} {}", amount, currencyCode.toUpperCase(), result, getTargetCurrencyName(currencyCode));
                System.out.println("Конвертация " + amount + " " + currencyCode.toUpperCase() + " в " + result + " " + getTargetCurrencyName(currencyCode));
                break; // Выходим из цикла после успешной конвертации

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                LOGGER.warn("Повторный ввод кода валюты после ошибки.");
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

    private static String getTargetCurrencyName(String currencyCode) {
        if (currencyCode.equals("usd")) {
            return "euro";
        } else {
            return "usd";
        }
    }
}