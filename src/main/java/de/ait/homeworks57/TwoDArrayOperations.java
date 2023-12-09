package de.ait.homeworks57;

import java.util.Random;

public class TwoDArrayOperations {
    public static void main(String[] args) {
        // Создание и заполнение массива
        int[][] array = new int[5][5];
        fillArray(array);

        // Вывод массива на экран
        System.out.println("Исходный массив:");
        printArray(array);

        // Поиск максимального элемента
        int maxElement = findMaxElement(array);
        System.out.println("\nМаксимальный элемент в массиве: " + maxElement);

        // Расчет среднего значения
        double average = calculateAverage(array);
        System.out.println("Среднее значение элементов в массиве: " + average);

        // Поиск чисел по условию (больше среднего значения)
        System.out.println("\nЭлементы массива, большие среднего значения:");
        findNumbersAboveAverage(array, average);
    }

    // Метод для заполнения массива случайными числами от 1 до 100
    private static void fillArray(int[][] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100) + 1;
            }
        }
    }

    // Метод для вывода массива на экран
    private static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для поиска максимального элемента в массиве
    private static int findMaxElement(int[][] array) {
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxElement) {
                    maxElement = array[i][j];
                }
            }
        }
        return maxElement;
    }

    // Метод для вычисления среднего значения элементов в массиве
    private static double calculateAverage(int[][] array) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
                count++;
            }
        }
        return (double) sum / count;
    }

    // Метод для вывода чисел в массиве, которые больше среднего значения
    private static void findNumbersAboveAverage(int[][] array, double average) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > average) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}
