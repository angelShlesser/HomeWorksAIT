package de.ait.homeworks56;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventScheduler.class);
    private List<Event> eventsList;

    // Конструктор для создания объекта EventScheduler
    public EventScheduler() {
        this.eventsList = new ArrayList<>();
        LOGGER.info("EventScheduler initialized");
    }

    // Метод для добавления события в список
    public void addEvent(Event eventToAdd) {
        eventsList.add(eventToAdd);
        LOGGER.info("Event added: {}", eventToAdd);
    }

    // Метод для удаления события из списка
    public void removeEvent(Event eventToDelete) {
        eventsList.remove(eventToDelete);
        LOGGER.info("Event removed: {}", eventToDelete);
    }

    // Метод для получения списка всех запланированных событий
    public List<Event> getAllEvents() {
        LOGGER.info("Getting all events");
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
        LOGGER.info("Getting events on date {}: {}", localDate, eventsOnDate);
        return eventsOnDate;
    }

    // Метод для проверки, пересекаются ли времена двух разных событий
    public boolean areEventsOverlapping(Event event1, Event event2) {
        LocalDateTime startDateTime1 = event1.getStartDateTime();
        LocalDateTime endDateTime1 = event1.getEndDateTime();
        LocalDateTime startDateTime2 = event2.getStartDateTime();
        LocalDateTime endDateTime2 = event2.getEndDateTime();

        boolean overlap = (startDateTime1.isBefore(endDateTime2) && endDateTime1.isAfter(startDateTime2)) ||
                (startDateTime2.isBefore(endDateTime1) && endDateTime2.isAfter(startDateTime1));

        LOGGER.info("Checking overlap between events {} and {}: {}", event1, event2, overlap);

        return overlap;
    }

    // Метод для проверки, пересекаются ли времена двух событий
    public boolean checkEventsToOverlap(Event eventOne, Event eventTwo){
        boolean overlap = eventOne.getStartDateTime().isBefore(eventTwo.getEndDateTime())
                && eventTwo.getStartDateTime().isBefore(eventOne.getEndDateTime());

        LOGGER.info("Checking overlap between events {} and {}: {}", eventOne, eventTwo, overlap);

        return overlap;
    }
}
