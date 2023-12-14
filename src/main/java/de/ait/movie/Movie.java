package de.ait.movie;

import java.time.LocalDateTime;

public class Movie {
    private String title; //Название фильма.
    private LocalDateTime startTime; //Время начала показа фильма.
    private LocalDateTime endTime; //Время окончания показа фильма.

    public Movie(String title, LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Ошибка: Некорректный ввод времени. Начальное время должно быть до конечного времени.");
        }
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    //Метод для проверки, не пересекаются ли времена показа с другими фильмами.
    public boolean isTimeConflict(Movie otherMovie) {
        return !(this.endTime.isBefore(otherMovie.startTime) || this.startTime.isAfter(otherMovie.endTime));
    }

}
