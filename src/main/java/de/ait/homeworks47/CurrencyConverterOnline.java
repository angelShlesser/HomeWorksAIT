package de.ait.homeworks47;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CurrencyConverterOnline {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyConverterOnline.class);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            System.out.println("Введите сумму для конвертации:");
            String amount = scanner.nextLine();
            System.out.println("Введите исходную валюты (USD или EURO):");
            String currency = scanner.nextLine();
            System.out.println("Введите целевую валюты (USD или EURO):");
            String targetCurrency = scanner.nextLine();
            double result = convertCurrency(amount, targetCurrency, currency);
            System.out.println("Результат конвертации: " + result);
    }

    public static double convertCurrency(String amount, String targetCurrency, String currency) {
        // Флаг для отслеживания валидности ввода
        boolean isInputValid = false;
        double convertResult = 0;

        // Запускаем цикл до тех пор, пока ввод не будет валидным
        while (!isInputValid) {
            try {
                // Преобразуем введенную сумму в число
                double amountDouble = Double.parseDouble(amount);
                LOGGER.info("Получена сумма для конвертации: {}.", amountDouble);

                // Проверяем валидность целевой валюты
                if (!targetCurrency.equals("USD") && !targetCurrency.equals("EURO")) {
                    throw new IllegalArgumentException("Несуществующий код целевой валюты.");
                }

                // Проверяем валидность исходной валюты
                if (!currency.equals("USD") && !currency.equals("EURO")) {
                    throw new IllegalArgumentException("Несуществующий код исходной валюты.");
                }

                // Выполняем конвертацию в зависимости от исходной валюты
                if (currency.equals("USD")) {
                    convertResult = amountDouble * 0.85;
                    LOGGER.info("Конвертация в USD: {}", convertResult);
                } else {
                    convertResult = amountDouble * 1.2;
                    LOGGER.info("Конвертация в EURO: {}", convertResult);
                }

                // Устанавливаем флаг валидности ввода
                isInputValid = true;
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка: Введено не числовое значение. Введите сумму для конвертации:");
                LOGGER.error("Недопустимый формат: {}", amount, exception);
                // Повторный ввод суммы в случае ошибки
                amount = scanner.nextLine();
            } catch (IllegalArgumentException exception) {
                System.out.println("Ошибка: " + exception.getMessage());
                LOGGER.error("Ошибка ввода валюты: {}", exception.getMessage());
                // Повторный ввод валюты в случае ошибки
                if (exception.getMessage().contains("целевой")) {
                    System.out.println("Введите целевую валюту (USD или EURO):");
                    targetCurrency = scanner.nextLine();
                } else {
                    System.out.println("Введите исходную валюту (USD или EURO):");
                    currency = scanner.nextLine();
                }
            }
        }
        return convertResult;
    }
}
