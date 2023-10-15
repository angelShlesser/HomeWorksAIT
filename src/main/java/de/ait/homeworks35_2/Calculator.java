package de.javalessons.homework35_2;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b==0) {throw new IllegalArgumentException(("Ошибка деления на 0"));}
        return a / b;
    }
    public double percentages(int total, int percent) {
        if (percent == 0) {
            throw new IllegalArgumentException("Ошибка деления на 0");
        }
        return ((double) total * percent) / 100;
    }
    //TODO Именование методов: Теперь методы имеют более читаемые названия, такие как subtract вместо substract и percentages вместо percentage.
    // Это улучшает читаемость кода и следует стандартам именования в Java.
    // Обработка деления на ноль: Метод divide выбрасывает исключение IllegalArgumentException, если b равно нулю, что предотвращает деление на ноль и обеспечивает безопасность.
    // Расчет процентов: Метод percentages теперь правильно вычисляет проценты, и ошибка в формуле была исправлена.
}
