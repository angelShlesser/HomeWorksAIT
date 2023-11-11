package de.ait.homeworks47;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CurrencyConverter {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverter.class);
    private double usd = 1.2;
    private static double euro = 0.85;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        convertCurrency();

    }
    private static void convertCurrency(){
        double amount = scannerUser();
        try {
            double result = amount * euro;
            LOGGER.info("Выполнена конвертация {}", result);
            System.out.println("Конвертация " + result);
        } catch (Exception e) {
            LOGGER.error("Произошла ошибка при конвертации", e);
        }
    }
    private static double scannerUser(){
        System.out.println("Введите сумму для конвертации USD:");
        LOGGER.info("Получение информации о конвертации");
        double result = 0;
        try {
            result = scanner.nextDouble();
        } catch (Exception e) {
            LOGGER.error("Ошибка ввода. Пожалуйста, введите числовое значение.", e);
            scanner.nextLine(); // Очистка буфера ввода
            result = scannerUser(); // Повторный запрос ввода
        }
        return result;
    }
}
