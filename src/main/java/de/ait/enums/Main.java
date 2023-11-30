package de.ait.enums;

import java.util.EnumMap;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        // Создание объектов DayUtil для сегодняшнего и завтрашнего дней
        DayUtil today = new DayUtil(29, Day.WEDNESDAY, Seasons.WINTER);
        DayUtil tomorrow = new DayUtil(30, Day.WEDNESDAY, Seasons.WINTER);

        // Вывод порядковых номеров сезона и дня недели
        System.out.println("Порядковый номер сезона: " + today.getSeason().ordinal());
        System.out.println("Порядковый номер дня недели: " + today.getDayOfWeek().ordinal());

        // Вывод первого сезона (WINTER) с использованием массива Seasons
        System.out.println("Первый сезон: " + Seasons.values()[0]);

        // Вывод описания сезона WINTER из enum Seasons
        System.out.println("Описание сезона WINTER: " + Seasons.valueOf("WINTER").getDescription());

        // Проверка, является ли сегодняшний день пятницей
        System.out.println("Сегодня пятница? " + today.dayOfWeek.equals(Day.FRIDAY));

        // Использование switch для вывода сообщения в зависимости от дня недели
        switch (today.dayOfWeek) {
            case MONDAY -> System.out.println("Сегодня не среда");
            case WEDNESDAY -> System.out.println("Сегодня среда");
            default -> System.out.println("Неизвестный день");
        }

        // Создание EnumMap для хранения строковых значений, связанных с днями недели
        EnumMap<Day, String> dayStringEnumMap = new EnumMap<>(Day.class);
        dayStringEnumMap.put(Day.TUESDAY, "Уже не понедельник");
        dayStringEnumMap.put(Day.SATURDAY, "Вечеринка");
        dayStringEnumMap.put(Day.MONDAY, "Не хочу на работу");
        dayStringEnumMap.put(Day.FRIDAY, "Ура пятница");
        // Список выстраивается по классу enum (MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY)
        // При null или получить выйдет ошибка NullPointerException
        // dayStringEnumMap.put(null, "test");

        // Вывод размера списка и значения для пятницы
        System.out.println("Размер списка: " + dayStringEnumMap.size());
        System.out.println("Значение для пятницы: " + dayStringEnumMap.get(Day.FRIDAY));

        // Вывод размера списка после удаления понедельника
        System.out.println("Размер списка после удаления понедельника: " + dayStringEnumMap.size());
        System.out.println("Значение для понедельника: " + dayStringEnumMap.remove(Day.MONDAY));

        // Проверка наличия четверга и значения "Не хочу на работу" в списке
        System.out.println("Содержит ли четверг? " + dayStringEnumMap.containsKey(Day.THURSDAY));
        System.out.println("Содержит ли значение 'Не хочу на работу'? " + dayStringEnumMap.containsValue("Не хочу на работу"));

        // Вывод всех значений списка
        System.out.println("Значения списка: " + dayStringEnumMap.values());

        // Проверка, равны ли значения для пятницы и понедельника
        System.out.println("Значения для пятницы и понедельника равны? " + dayStringEnumMap.get(Day.FRIDAY).equals(dayStringEnumMap.get(Day.MONDAY)));

        // Создание EnumSet для представления выходных дней (суббота и воскресенье)
        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);

        EnumSet<Day> weekendTwo = EnumSet.of(Day.SATURDAY, Day.SUNDAY, Day.MONDAY);

        // Создание EnumSet для представления рабочих дней (комплемент выходным дням)
        EnumSet<Day> workingDay = EnumSet.complementOf(weekend);

        EnumSet<Day> weekendCopy = EnumSet.copyOf(weekend);

        boolean result = weekend.addAll(workingDay);

        System.out.println("Добавление всех рабочих дней к выходным: " + result);

        EnumSet<Day> overlap = EnumSet.copyOf(workingDay);

        boolean resultOverlap = overlap.retainAll(weekendTwo);

        System.out.println("Удержание пересекающихся дней: " + resultOverlap);

        // Вывод всех значений EnumSet weekend
        System.out.println("Значения EnumSet weekend:");
        for (Day day: weekend){
            System.out.println(day.name());
        }
    }
}
