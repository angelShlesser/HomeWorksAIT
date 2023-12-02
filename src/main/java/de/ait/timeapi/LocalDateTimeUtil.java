package de.ait.timeapi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeUtil {
    public static void main(String[] args) {
        // Получение текущего LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Текущее время и дата: " + localDateTime);

        // Получение текущего LocalDateTime для определенного часового пояса (Australia/Darwin)
        ZoneId zoneId = ZoneId.of("Australia/Darwin");
        LocalDateTime localDateTimeAustralia = LocalDateTime.now(zoneId);
        System.out.println("Текущее время и дата в Австралии (Darwin): " + localDateTimeAustralia);

        // Создание LocalDateTime с заданной датой и временем
        LocalDateTime customLocalDateTime = LocalDateTime.of(2000, 1, 1, 23, 54);
        System.out.println("Заданное время и дата: " + customLocalDateTime);

        // Добавление 3 часов к существующему LocalDateTime
        LocalDateTime modifiedLocalDateTime = customLocalDateTime.plusHours(3);
        System.out.println("Измененное время и дата: " + modifiedLocalDateTime);

        // Преобразование LocalDateTime в ZonedDateTime для определенного часового пояса
        System.out.println("ZonedDateTime в часовом поясе Австралии (Darwin): " +
                modifiedLocalDateTime.atZone(zoneId));

        // Вывод только времени из LocalDateTime
        System.out.println("Только время: " + modifiedLocalDateTime.toLocalTime());

        // Проверка, является ли текущее время позже измененного времени
        System.out.println("Текущее время после измененного времени: " +
                LocalDateTime.now().isAfter(modifiedLocalDateTime));

        // Проверка, является ли текущее время ранее заданного времени
        System.out.println("Текущее время перед заданным временем: " +
                customLocalDateTime.isBefore(modifiedLocalDateTime));

        // Вывод часов и минут заданного времени
        System.out.println("Часы: " + customLocalDateTime.getHour());
        System.out.println("Минуты: " + customLocalDateTime.getMinute());

        // Добавление 24 часов к заданному времени
        LocalDateTime nextDayDateTime = customLocalDateTime.plusHours(24);
        System.out.println("Время через 24 часа: " + nextDayDateTime);

        // Определяем временную зону
        ZoneId zoneId1 = ZoneId.of("America/New_York");
        ZoneId zoneId2 = ZoneId.of("Asia/Tokyo");

        // Привязываем временную зону к LocalDateTime
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(zoneId1);
        System.out.println("Время в Нью-Йорке: " + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = localDateTime.atZone(zoneId2);
        System.out.println("Время в Токио: " + zonedDateTime2);

        // Переключаем временную зону
        ZonedDateTime newYorkTime = zonedDateTime1.withZoneSameInstant(zoneId2);
        System.out.println("То же время в Нью-Йорке, но в Токио: " + newYorkTime);

    }
}
