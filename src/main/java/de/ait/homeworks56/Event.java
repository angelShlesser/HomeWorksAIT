package de.ait.homeworks56;

import java.time.LocalDateTime;

public class Event {
    /*
    Создайте класс Event, который содержит следующие поля:
        String name - название события.
        LocalDateTime startDateTime - дата и время начала события.
        LocalDateTime endDateTime - дата и время окончания события.
    Реализуйте конструкторы, геттеры и сеттеры для этих полей.
     */
    private String name;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Event(String name, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                '}';
    }
}
