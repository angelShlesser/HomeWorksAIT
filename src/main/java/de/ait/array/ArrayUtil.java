package de.ait.array;

public class ArrayUtil {
    public static void main(String[] args) {
        // Одномерный массив строк
        String[] books = new String[5];
        books[1] = "Harry Potter";
        System.out.println(books[1]);

        // Многомерный массив строк
        // 3 строки и 5 элементов в каждой
        //     0         1        2         3         4
        // "123123", "121435", "114145", "16532", "17754"   [0]
        // "23213",  "24553",  "25365",  "2156",  "23421"    [1]
        // "324212", "3434234","334324", "354325", "37545"    [2]
        String[][] pinCodes = new String[3][5];
        pinCodes[0][0] = "123123";
        pinCodes[1][0] = "23213";
        pinCodes[2][0] = "324212";
        pinCodes[0][1] = "121435";

        // Запись блоками
        String[][] pinCodeReserve = {
                {"123123", "121435", "114145"},
                {"23213", "24553", "25365"},
                {"324212", "3434234", "334324"}
        };
        System.out.println(pinCodeReserve[0][1]);

        // Вывод элементов многомерного массива с использованием циклов
        for (int i = 0; i < pinCodeReserve.length; i++) {
            for (int j = 0; j < pinCodeReserve[i].length; j++) {
                System.out.println(pinCodeReserve[i][j]);
            }
        }
    }
}
