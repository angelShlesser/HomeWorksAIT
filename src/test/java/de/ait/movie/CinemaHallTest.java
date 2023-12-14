package de.ait.movie;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CinemaHallTest {

    @Test
    void testAddMovie() {
        try {
            // Создаем кинозал с 20 местами
            CinemaHall cinemaHall = new CinemaHall(1, 20);

            // Создаем фильм
            LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
            LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);
            Movie movie = new Movie("Test Movie", startTime, endTime);

            // Добавляем фильм в расписание зала
            cinemaHall.addMovie(movie);

            // Проверяем, что фильм добавлен в расписание
            assertEquals(1, cinemaHall.getMoviesSchedule().size());
        } catch (ScheduleConflictException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testAddMovieWithConflict() {
        // Создаем кинозал
        CinemaHall cinemaHall = new CinemaHall(2, 30);

        // Создаем два фильма с пересекающимся временем
        LocalDateTime startTime1 = LocalDateTime.of(2023, 1, 1, 14, 0);
        LocalDateTime endTime1 = LocalDateTime.of(2023, 1, 1, 16, 0);
        Movie movie1 = new Movie("Movie 1", startTime1, endTime1);

        LocalDateTime startTime2 = LocalDateTime.of(2023, 1, 1, 15, 30);
        LocalDateTime endTime2 = LocalDateTime.of(2023, 1, 1, 18, 0);
        Movie movie2 = new Movie("Movie 2", startTime2, endTime2);

        // Добавляем первый фильм в расписание
        try {
            cinemaHall.addMovie(movie1);
        } catch (ScheduleConflictException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        // Пытаемся добавить второй фильм, который пересекается по времени
        assertThrows(ScheduleConflictException.class, () -> cinemaHall.addMovie(movie2));
    }

    @Test
    void testBookTicket() {
        try {
            // Создаем кинозал с 10 местами
            CinemaHall cinemaHall = new CinemaHall(3, 10);

            // Создаем фильм
            LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
            LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);
            Movie movie = new Movie("Test Movie", startTime, endTime);

            // Добавляем фильм в расписание зала
            cinemaHall.addMovie(movie);

            // Пытаемся забронировать 5 билетов
            cinemaHall.bookTicket("Test Movie", 5);

            // Проверяем, что билеты успешно забронированы
            assertEquals(5, cinemaHall.getBookedSeats());

            // Проверяем, что доступных мест осталось 5
            assertEquals(5, cinemaHall.getTotalSeats() - cinemaHall.getBookedSeats());
        } catch (SoldOutException | ScheduleConflictException | IllegalArgumentException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testBookTicketSoldOutException() {
        // Создаем кинозал с 5 местами
        CinemaHall cinemaHall = new CinemaHall(4, 5);

        // Создаем фильм
        LocalDateTime startTime = LocalDateTime.of(2023, 1, 1, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2023, 1, 1, 12, 0);
        Movie movie = new Movie("Sold Out Movie", startTime, endTime);

        // Добавляем фильм в расписание зала
        try {
            cinemaHall.addMovie(movie);
        } catch (ScheduleConflictException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        // Пытаемся забронировать больше билетов, чем доступно
        assertThrows(SoldOutException.class, () -> cinemaHall.bookTicket("Sold Out Movie", 10));
    }
}