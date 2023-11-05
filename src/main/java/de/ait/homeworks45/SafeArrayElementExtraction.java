package de.ait.homeworks45;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class SafeArrayElementExtraction {
    private static final Logger LOGGER = LoggerFactory.getLogger(SafeArrayElementExtraction.class);
    public static void main(String[] args) {
        String[] array = {"Apple", "Banana", "Cherry", "Date", "Fig"};
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите индекс элемента для извлечения: ");

            try {
                int index = Integer.parseInt(scanner.nextLine());
                String element = safeExtractElement(array, index);

                if (element != null) {
                    LOGGER.info("Извлеченный элемент: {}",element);
                }
            } catch (NumberFormatException exception) {
                LOGGER.error("Не верный формат индекса массива");
            } finally {
                LOGGER.info("Операция поиска завершена.");
            }
        }
    }

    public static String safeExtractElement(String[] array, int index) {
        if (array == null) {
            LOGGER.info("Массив отсутствует.");
            return null;
        }

        try {
            if (index < 0 || index >= array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return array[index];
        } catch (ArrayIndexOutOfBoundsException exception) {
            LOGGER.warn("Введено число за пределами массива");
        }
        return null;
    }
}
