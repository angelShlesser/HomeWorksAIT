package de.ait.homeworks57;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class TwoDArrayOperationsOnline {
    private static final Logger LOGGER = LoggerFactory.getLogger(TwoDArrayOperationsOnline.class);

    public static void main(String[] args) {
        int[][] arrayForTest = createArray(5, 5);

        // Поиск и вывод максимального значения
        int maxValue = findMaxValue(arrayForTest);
        System.out.println("Maximum Value: " + maxValue);

        // Поиск и вывод среднего значения
        double average = findAverage(arrayForTest);
        System.out.println("Average: " + average);

        // Вывод элементов, превышающих среднее значение
        System.out.println("Elements greater than average:");
        showElementsGreaterThan(arrayForTest, average);
    }

    /**
     * Создание и заполнение двумерного массива случайными числами.
     *
     * @param lineSize размер массива по строкам
     * @param colSize  размер массива по столбцам
     * @return созданный массив
     */
    public static int[][] createArray(int lineSize, int colSize) {
        if (lineSize <= 0 || colSize <= 0) {
            LOGGER.error("Wrong value method: {} {}", lineSize, colSize);
            throw new NumberFormatException("Wrong value in method!");
        }
        int[][] arrayToReturn = new int[lineSize][colSize];
        Random random = new Random();

        for (int i = 0; i < arrayToReturn.length; i++) {
            for (int j = 0; j < arrayToReturn[i].length; j++) {
                // Генерация случайного числа от 0 до 100 включительно
                int randomInt = random.nextInt(101);
                arrayToReturn[i][j] = randomInt;
                LOGGER.info("ArrayToReturn Position {} {} Value {}", i, j, randomInt);
            }
        }
        return arrayToReturn;
    }

    /**
     * Поиск максимального значения в двумерном массиве.
     *
     * @param array массив для поиска
     * @return максимальное значение
     */
    public static int findMaxValue(int[][] array) {
        int maxValue = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                }
            }
        }

        LOGGER.info("Maximum Value {}", maxValue);
        return maxValue;
    }

    /**
     * Вычисление среднего значения в двумерном массиве.
     *
     * @param array массив для вычисления
     * @return среднее значение
     */
    public static double findAverage(int[][] array) {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                count++;
                sum += array[i][j];
            }
        }

        LOGGER.info("Sum {}", sum);
        LOGGER.info("Element {}", count);

        double average = count > 0 ? sum / count : 0;
        LOGGER.info("Average {}", average);
        return average;
    }

    /**
     * Вывод элементов массива, превышающих заданное значение.
     *
     * @param array  массив для вывода
     * @param number значение, по которому производится фильтрация
     */
    public static void showElementsGreaterThan(int[][] array, double number) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > number) {
                    System.out.printf(array[i][j] + " ");
                }
            }
        }
    }
}
