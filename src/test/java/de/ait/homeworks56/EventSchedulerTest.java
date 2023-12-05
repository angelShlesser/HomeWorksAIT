package de.ait.homeworks56;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventSchedulerTest {
    private EventScheduler eventScheduler;
    private Event event1;
    private Event event2;

    private Event event3;
    private Event event4;

    @BeforeEach
    void setUp() {
        eventScheduler = new EventScheduler();
        event1 = new Event("Встреча", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        event2 = new Event("Конференция", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));

        // Первое событие: с 1 часа до 3 часов
        event3 = new Event("Встреча", LocalDateTime.of(2023, 1, 1, 1, 0),
                LocalDateTime.of(2023, 1, 1, 3, 0));
        // Второе событие: с 2 часов до 4 часов
        event4 = new Event("Конференция", LocalDateTime.of(2023, 1, 1, 2, 0),
                LocalDateTime.of(2023, 1, 1, 4, 0));
    }

    @Test
    @DisplayName("Добавление события в планировщик")
    void addEvent() {
        eventScheduler.addEvent(event1);
        assertTrue(eventScheduler.getAllEvents().contains(event1));
    }

    @Test
    @DisplayName("Удаление события из планировщика")
    void removeEvent() {
        eventScheduler.addEvent(event1);
        eventScheduler.removeEvent(event1);
        assertFalse(eventScheduler.getAllEvents().contains(event1));
    }

    @Test
    @DisplayName("Получение всех событий из планировщика")
    void getAllEvents() {
        eventScheduler.addEvent(event1);
        eventScheduler.addEvent(event2);
        List<Event> allEvents = eventScheduler.getAllEvents();
        assertTrue(allEvents.contains(event1));
        assertTrue(allEvents.contains(event2));
    }

    @Test
    @DisplayName("Получение событий на определенную дату из планировщика")
    void getEventsOnDate() {
        eventScheduler.addEvent(event1);
        eventScheduler.addEvent(event2);
        List<Event> eventsOnDate = eventScheduler.getEventsOnDate(LocalDateTime.now().plusDays(1).toLocalDate());
        assertTrue(eventsOnDate.contains(event2));
        assertFalse(eventsOnDate.contains(event1));
    }

    @Test
    @DisplayName("Проверка пересечения времен событий в планировщике")
    void areEventsOverlapping() {
        assertFalse(eventScheduler.areEventsOverlapping(event1, event2));
    }

    @Test
    @DisplayName("Проверка пересечения времен событий с использованием нового метода в планировщике")
    void checkEventsToOverlap() {
        assertFalse(eventScheduler.checkEventsToOverlap(event1, event2));
    }

    @Test
    @DisplayName("Проверка пересечения времен событий в планировщике")
    void areEventsOverlappingSuccess() {
        assertTrue(eventScheduler.areEventsOverlapping(event3, event4));
    }

    @Test
    @DisplayName("Проверка пересечения времен событий с использованием нового метода в планировщике")
    void checkEventsToOverlapSuccess() {
        assertTrue(eventScheduler.checkEventsToOverlap(event3, event4));
    }
}