package de.ait.timeapi;

import java.time.LocalTime;

public class LocalTimeUtil {
    public static void main(String[] args) {
        // Получение текущего времени
        LocalTime localTime = LocalTime.now();
        System.out.println("Текущее время: " + localTime);

        // Создание объекта LocalTime с конкретным временем
        LocalTime time = LocalTime.of(20, 0, 0);
        System.out.println("Заданное время: " + time);

        // Изменение времени с использованием методов plus и minus
        time = time.plusHours(2);
        time = time.minusHours(1);
        time = time.plusSeconds(3009);
        System.out.println("Измененное время: " + time);

        // Создание объекта LocalTime из количества секунд с начала дня
        LocalTime localFromSeconds = LocalTime.ofSecondOfDay(3009);
        System.out.println("Время из секунд: " + localFromSeconds);

        // Получение минут и часов из объекта LocalTime
        System.out.println("Минуты: " + time.getMinute());
        System.out.println("Часы: " + time.getHour());
    }
}
