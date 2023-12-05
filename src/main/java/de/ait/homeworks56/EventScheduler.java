package de.ait.homeworks56;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventScheduler {
    private List<Event> eventsList;

    // Конструктор для создания объекта EventScheduler
    public EventScheduler() {
        this.eventsList = new ArrayList<>();
    }

    // Метод для добавления события в список
    public void addEvent(Event eventToAdd) {
        eventsList.add(eventToAdd);
    }

    // Метод для удаления события из списка
    public void removeEvent(Event eventToDelete) {
        eventsList.remove(eventToDelete);
    }

    // Метод для получения списка всех запланированных событий
    public List<Event> getAllEvents() {
        return new ArrayList<>(eventsList);
    }

    // Метод для получения списка событий, запланированных на конкретную дату
    public List<Event> getEventsOnDate(LocalDate localDate) {
        List<Event> eventsOnDate = new ArrayList<>();
        for (Event event : eventsList) {
            if (event.getStartDateTime().toLocalDate().isEqual(localDate)) {
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

    // Метод для проверки, пересекаются ли времена двух событий
    public boolean checkEventsToOverlap(Event eventOne, Event eventTwo){
        return eventOne.getStartDateTime().isBefore(eventTwo.getEndDateTime())
                && eventTwo.getStartDateTime().isBefore(eventOne.getEndDateTime());
    }
}
