package de.ait.homeworks56;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class EventTest {
    // Создаем экземпляр планировщика
    private static EventScheduler eventScheduler = new EventScheduler();
    public static void main(String[] args) {
        // Создаем экземпляры событий
        Event event1 = new Event("Meeting", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Event event2 = new Event("Conference", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));

        // Добавляем события в планировщик
        eventScheduler.addEvent(event1);
        eventScheduler.addEvent(event2);

        // Выводим все события
        System.out.println("All Events:");
        eventScheduler.getAllEvents().forEach(System.out::println);

        // Получаем события на конкретную дату
        LocalDate dateToCheck = LocalDate.now().plusDays(1);
        List<Event> eventsOnDate = eventScheduler.getEventsOnDate(dateToCheck);
        System.out.println("\nEvents on " + dateToCheck + ":");
        eventsOnDate.forEach(System.out::println);

        // Проверяем пересечение времен событий
        System.out.println("\nChecking for overlapping events:");
        boolean areOverlapping = eventScheduler.areEventsOverlapping(event1, event2);
        System.out.println("Events overlapping: " + areOverlapping);
    }
}
