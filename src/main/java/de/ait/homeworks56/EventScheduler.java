package de.ait.homeworks56;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class EventScheduler {
    private List<Event> events;

    // Конструктор для создания объекта EventScheduler
    public EventScheduler() {
        this.events = new ArrayList<>();
    }

    // Метод для добавления события в список
    public void addEvent(Event event) {
        events.add(event);
    }

    // Метод для удаления события из списка
    public void removeEvent(Event event) {
        events.remove(event);
    }

    // Метод для получения списка всех запланированных событий
    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    // Метод для получения списка событий, запланированных на конкретную дату
    public List<Event> getEventsOnDate(LocalDateTime date) {
        List<Event> eventsOnDate = new ArrayList<>();
        for (Event event : events) {
            LocalDateTime startDateTime = event.getStartDateTime();
            LocalDateTime endDateTime = event.getEndDateTime();

            if ((startDateTime.isEqual(date) || startDateTime.isBefore(date)) &&
                    (endDateTime.isEqual(date) || endDateTime.isAfter(date))) {
                eventsOnDate.add(event);
            }
        }
        return eventsOnDate;
    }

    // Метод для проверки, пересекаются ли времена двух разных событий
    public boolean areEventsOverlapping(Event event1, Event event2) {
        LocalDateTime startDateTime1 = event1.getStartDateTime();
        LocalDateTime endDateTime1 = event1.getEndDateTime();
        LocalDateTime startDateTime2 = event2.getStartDateTime();
        LocalDateTime endDateTime2 = event2.getEndDateTime();

        return (startDateTime1.isBefore(endDateTime2) && endDateTime1.isAfter(startDateTime2)) ||
                (startDateTime2.isBefore(endDateTime1) && endDateTime2.isAfter(startDateTime1));
    }
}