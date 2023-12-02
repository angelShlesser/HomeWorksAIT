package de.ait.timeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateUtil {

    public static void main(String[] args) {
        // Получение текущей даты
        LocalDate localDate = LocalDate.now();

        // Вывод года, месяца и дня недели
        System.out.println("Текущая дата: " + localDate.getYear() + " " + localDate.getMonth() + " " + localDate.getDayOfWeek());

        // Получение текущей даты и времени
        LocalDateTime localDateTime = LocalDateTime.now();

        // Вывод текущего часа и минуты
        System.out.println("Текущее время: " + localDateTime.getHour() + ":" + localDateTime.getMinute());
    }
}