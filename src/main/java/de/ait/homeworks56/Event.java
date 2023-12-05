package de.ait.homeworks56;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    // Название события
    private String name;

    // Дата и время начала события
    private LocalDateTime startDateTime;

    // Дата и время окончания события
    private LocalDateTime endDateTime;

    // Конструктор класса
    public Event(String name, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.name = name;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    // Геттер и сеттер для названия события
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттер и сеттер для даты и времени начала события
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    // Геттер и сеттер для даты и времени окончания события
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    // Переопределение метода toString для более читаемого вывода
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "Event{" +
                "name='" + name + '\'' +
                ", startDateTime=" + startDateTime.format(formatter) +
                ", endDateTime=" + endDateTime.format(formatter) +
                '}';
    }
}