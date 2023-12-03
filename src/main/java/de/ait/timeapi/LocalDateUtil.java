package de.ait.timeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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

        // Получение текущей даты в Германии
        LocalDate localDateGermany = LocalDate.now();
        System.out.println("Дата в Германии: " + localDateGermany);

        // Получение текущей даты в Австралии и Африке
        ZoneId zoneIdAustralia = ZoneId.of("Australia/Darwin");
        ZoneId zoneIdAfrica = ZoneId.of("Africa/Addis_Ababa");

        LocalDate localDateAustralia = LocalDate.now(zoneIdAustralia);
        LocalDate localDateAfrica = LocalDate.now(zoneIdAfrica);

        System.out.println("Дата в Австралии: " + localDateAustralia);
        System.out.println("Дата в Африке: " + localDateAfrica);

        // Создание даты с указанным годом, месяцем и днем
        LocalDate localDateOf2000 = LocalDate.of(2000, 4, 5);
        System.out.println("Дата 5 апреля 2000 года: " + localDateOf2000);

        // Создание даты на основе года и номера дня в году
        LocalDate localDateNow = LocalDate.ofYearDay(2000, 1);
        System.out.println("Дата 1-го дня 2000 года: " + localDateNow);

        // Получение и вывод года текущей даты
        System.out.println("Год текущей даты: " + localDateNow.getYear());
        System.out.println("-----------");

        // Добавление и вычитание дней от текущей даты
        localDateNow = localDateNow.plusDays(57);
        System.out.println("Дата после добавления 57 дней: " + localDateNow);
        localDateNow = localDateNow.minusDays(17);
        System.out.println("Дата после вычитания 17 дней: " + localDateNow);

        // Определение шаблона форматирования
        // https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/time/format/DateTimeFormatter.html
        String pattern = "dd.MM.yyyy";

        // Создание объекта DateTimeFormatter с использованием шаблона
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        // Форматирование LocalDate с использованием DateTimeFormatter
        String formattedDate = dateTimeFormatter.format(localDateNow);

        // Вывод отформатированной даты
        System.out.println("Отформатированный формат: " + formattedDate);

        // Пример парсинга строки с датой в указанном формате
        String dateToParse = "10.10.2020";
        LocalDate localDateParser = LocalDate.parse(dateToParse, dateTimeFormatter);
        System.out.println("Дата после вычитания 800 дней: " + localDateParser.minusDays(800));

        // Пример использования локали (на примере локали Германии)
        DateTimeFormatter dateTimeFormatterGermany = DateTimeFormatter.ofPattern(pattern, Locale.GERMAN);
        System.out.println("Дата в формате Германии: " + LocalDate.parse(dateToParse, dateTimeFormatterGermany));
    }
}