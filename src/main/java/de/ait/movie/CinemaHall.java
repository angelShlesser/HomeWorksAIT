package de.ait.movie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CinemaHall {
    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public List<Movie> getMoviesSchedule() {
        return moviesSchedule;
    }

    public void setMoviesSchedule(List<Movie> moviesSchedule) {
        this.moviesSchedule = moviesSchedule;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    private int hallNumber; //Номер кинозала.
    private List<Movie> moviesSchedule; //Список фильмов в расписании зала.

    private int totalSeats; // Общее количество мест в зале
    private int bookedSeats; // Количество уже забронированных мест

    public CinemaHall(int hallNumber) {
        this.hallNumber = hallNumber;
        this.moviesSchedule = new ArrayList<>();
    }

    // Конструктор для инициализации полей
    public CinemaHall(int hallNumber, int totalSeats) {
        this.hallNumber = hallNumber;
        this.totalSeats = totalSeats;
        this.moviesSchedule = new ArrayList<>();
        this.bookedSeats = 0;
    }
    /*
    Добавляет фильм в расписание, предварительно
    проверив на пересечение времени показа с уже запланированными фильмами.
     */
    public void addMovie(Movie movie) throws ScheduleConflictException {
        if (!isScheduleConflict(movie.getStartTime(),movie.getEndTime())) {
            moviesSchedule.add(movie);
            System.out.println("Фильм успешно добавлен в расписание зала " + hallNumber);
        }
        else {
            System.out.println("Ошибка: Пересечение времени с уже запланированными фильмами в зале " + hallNumber);
            throw new ScheduleConflictException("Ошибка: Пересечение времени с уже запланированными фильмами в зале " + hallNumber);
        }
    }
    //Проверяет наличие пересечения времени сеансов.
    private boolean isScheduleConflict(LocalDateTime newMovieStart, LocalDateTime newMovieEnd){
    for (Movie scheduledMovie : moviesSchedule){
        if (scheduledMovie.isTimeConflict(new Movie("",newMovieStart,newMovieEnd))){
            return true;
        }
    }
    return false;
    }

    public void bookTicket(String movieTitle, int numberOfTickets) throws SoldOutException {
        // Находим фильм по названию
        Movie movie = findMovieByTitle(movieTitle);

        // Проверяем, есть ли такой фильм в расписании
        if (movie != null) {
            // Проверяем наличие свободных мест
            int availableSeats = totalSeats - bookedSeats;
            if (availableSeats >= numberOfTickets) {
                // Уменьшаем количество доступных мест
                bookedSeats += numberOfTickets;
                System.out.println("Билеты на фильм \"" + movieTitle + "\" успешно забронированы.");
            } else {
                throw new SoldOutException("Ошибка: Недостаточно свободных мест для бронирования.");
            }
        } else {
            throw new IllegalArgumentException("Ошибка: Фильм с названием \"" + movieTitle + "\" не найден в расписании зала " + hallNumber);
        }
    }

    // Метод для поиска фильма по названию
    private Movie findMovieByTitle(String movieTitle) {
        for (Movie movie : moviesSchedule) {
            if (movie.getTitle().equals(movieTitle)) {
                return movie;
            }
        }
        return null;
    }
}
