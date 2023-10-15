package de.ait.homeworks35_2;

public class Calculator {

    //TODO 1. Не проверки деления на 0
    // 2.Орфографическая ошибка в названии метода, точность названия методов
    // 3. Уточнить публичность методов
    // 4. Неправильная логика внутри метода percentage
    // 5. Уточнить возможность 0%
    // 6. Уточнить точность вычислений в методах, особенно divideValues, multiply
    // 7. Удалить лишнее из названия методов
    // 8. Неполноценные названия аргументов методов (a, b)
    // 9. Отсутствуют необходимые комментарии



    public int addition(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0){
            System.err.println("деление на 0 !!!");
            return -1;
        }
        return (double) a / b;
    }

    public double percentage(int total, int percent) {
        return (total* percent)/100.;
    }
}
