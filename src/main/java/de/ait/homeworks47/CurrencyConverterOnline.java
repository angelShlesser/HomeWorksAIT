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
            System.out.println("Введите исходную валюту (USD или EURO):");
            String currency = scanner.nextLine();
            System.out.println("Введите целевую валюту (USD или EURO):");
            String targetCurrency = scanner.nextLine();
            double result = convertCurrency(amount, targetCurrency, currency);
            System.out.println("Результат конвертации: " + result);
            scanner.close();
    }

    /**
     * Метод для конвертации суммы из одной валюты в другую.
     *
     * @param amount         Сумма для конвертации.
     * @param targetCurrency Целевая валюта.
     * @param currency       Исходная валюта.
     * @return Результат конвертации.
     */
    public static double convertCurrency(String amount, String targetCurrency, String currency) {
        boolean isInputValid = false; // Флаг для отслеживания валидности ввода
        double convertResult = 0; // Результат конвертации

        // Запускаем цикл до тех пор, пока ввод не будет валидным
        while (!isInputValid) {
            try {
                double amountDouble = Double.parseDouble(amount);
                if (amountDouble < 0) {
                    throw new IllegalArgumentException("Сумма не может быть отрицательной.");
                }
                LOGGER.info("Получена сумма для конвертации: {}.", amountDouble);

                // Проверяем валидность целевой валюты
                if (!targetCurrency.equalsIgnoreCase("USD") && !targetCurrency.equalsIgnoreCase("EURO")) {
                    throw new IllegalArgumentException("Несуществующий код целевой валюты.");
                }

                // Проверяем валидность исходной валюты
                if (!currency.equalsIgnoreCase("USD") && !currency.equalsIgnoreCase("EURO")) {
                    throw new IllegalArgumentException("Несуществующий код исходной валюты.");
                }

                // Выполняем конвертацию в зависимости от исходной валюты
                if (currency.equalsIgnoreCase(targetCurrency)) {
                    LOGGER.info("Конвертация в ту же самую валюту.");
                } else if (currency.equalsIgnoreCase("USD")) {
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
                amount = scanner.nextLine(); // Повторный ввод суммы в случае ошибки

            } catch (IllegalArgumentException exception) {
                System.out.println("Ошибка: " + exception.getMessage());
                LOGGER.error("Ошибка ввода: {}", exception.getMessage());

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