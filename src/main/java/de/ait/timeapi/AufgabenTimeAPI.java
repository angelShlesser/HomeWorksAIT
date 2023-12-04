package de.ait.timeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class AufgabenTimeAPI {

    public static void main(String[] args) {
        // Получаем текущую дату
        LocalDate localDate = LocalDate.now();

        // Добавляем 5 дней и 3 месяца к текущей дате и выводим результат
        System.out.println(localDate.plusDays(5).plusMonths(3));

        // Добавляем 5 дней к текущей дате и выводим результат
        System.out.println(localDate.plusDays(5));

        // Выводим следующий месяц после текущего
        System.out.println(localDate.getMonth().plus(3));

        // Создаем LocalDateTime для 1 января 2023 года, 12:00
        LocalDateTime localDateTime = LocalDateTime.of(2023, 1, 1, 12, 0);
        System.out.println(localDateTime);

        // Создаем объект LocalDateTime для "1 января 2023 года, 12:00"
        LocalDateTime dateTime = LocalDateTime.of(2023, Month.JANUARY, 1, 12, 0);

        // Создаем объект DateTimeFormatter с необходимым шаблоном
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy 'года, 'HH:mm");

        // Форматируем LocalDateTime и выводим в консоль
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(formattedDateTime);

        // Создаем две LocalDate и вычисляем разницу в днях и годах между ними
        LocalDate localDateOne = LocalDate.of(2030, 1, 1);
        LocalDate localDateTwo = LocalDate.now();
        long daysDifference = ChronoUnit.DAYS.between(localDateTwo, localDateOne);
        long yearsDifference = ChronoUnit.YEARS.between(localDateTwo, localDateOne);

        System.out.println(daysDifference);
        System.out.println(yearsDifference);

        // Получаем текущий год и проверяем, является ли он високосным
        int currentYear = LocalDate.now().getYear();
        boolean isLeapYear = Year.of(currentYear).isLeap();

        System.out.println("Текущий год: " + currentYear);
        System.out.println("Високосный год? " + isLeapYear);

        // Вызываем функции для проверки високосности текущей даты
        System.out.println(checkYearMet(localDate));
        System.out.println(checkYearNow(localDate));

        // Получаем текущее время в зоне "Europe/Paris" и выводим результат
        ZoneId zoneIdParis = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneIdParis);
        System.out.println(zonedDateTime);
    }

    // Функция для проверки високосности года (методика Metonic)
    public static boolean checkYearMet(LocalDate localDate) {
        if (localDate.getMonth().equals(Month.FEBRUARY) && localDate.getDayOfMonth() == 29) {
            return true;
        } else if (localDate.getYear() % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Функция для проверки високосности года с использованием Java Time API
    public static boolean checkYearNow(LocalDate localDate) {
        return localDate.isLeapYear();
    }
}