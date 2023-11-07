package de.ait.homeworks45;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SafeArrayElementExtraction {
    private static final Logger LOGGER = LoggerFactory.getLogger(SafeArrayElementExtraction.class);
    private static final Scanner scanner = new Scanner(System.in);
    private static String[] array;

    public static void main(String[] args) {
        createAndPopulateArray();
        scanner.close();
    }

    public static void processUserInput() {
        while (true) {
            LOGGER.info("Введите элемента для извлечения от 1 до 5 (или 'exit' для завершения): ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                LOGGER.info("Программа завершена.");
                break;
            }

            try {
                int result = Integer.parseInt(input);
                int index = result - 1;
                String element = array[index];

                if (element != null) {
                    LOGGER.info("Извлеченный элемент: {}", element);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                LOGGER.error("ERROR. Введено число за пределами массива");
            } catch (NumberFormatException exception) {
                LOGGER.error("Не верный формат индекса массива");
            } finally {
                LOGGER.info("Операция поиска завершена.");
            }
        }
    }

    public static void createAndPopulateArray() {
        array = new String[5];
        LOGGER.info("Заполните массив (5 элементов):");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextLine();
            LOGGER.info("Добавлен {} элемент массива: {}", i + 1, array[i]);
        }
        LOGGER.info("Создание массива завершено.");
        processUserInput();
    }
}