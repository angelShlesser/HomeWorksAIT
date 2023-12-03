package de.ait.homeworks56;

import java.time.LocalDateTime;
import java.util.List;

public class EventTest {
    public static void main(String[] args) {
        // Создаем экземпляры событий
        Event event1 = new Event("Meeting", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        Event event2 = new Event("Conference", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));

        // Создаем экземпляр планировщика
        EventScheduler eventScheduler = new EventScheduler();

        // Добавляем события в планировщик
        eventScheduler.addEvent(event1);
        eventScheduler.addEvent(event2);

        // Выводим все события
        System.out.println("All Events:");
        eventScheduler.getAllEvents().forEach(System.out::println);

        // Получаем события на конкретную дату
        LocalDateTime dateToCheck = LocalDateTime.now().plusDays(1);
        List<Event> eventsOnDate = eventScheduler.getEventsOnDate(dateToCheck);
        System.out.println("\nEvents on " + dateToCheck + ":");
        eventsOnDate.forEach(System.out::println);

        // Проверяем пересечение времен событий
        boolean areOverlapping = eventScheduler.areEventsOverlapping(event1, event2);
        System.out.println("\nEvents overlapping: " + areOverlapping);
    }
}
