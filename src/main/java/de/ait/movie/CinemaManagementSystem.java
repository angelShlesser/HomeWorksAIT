package de.ait.movie;

import java.time.LocalDateTime;

public class CinemaManagementSystem {
    public static void main(String[] args) {
        try {
            // Создаем кинозал
            CinemaHall cinemaHall = new CinemaHall(1, 50); // Здесь 50 - общее количество мест в зале

            // Создаем фильмы
            LocalDateTime startTime1 = LocalDateTime.of(2023, 1, 1, 10, 0);
            LocalDateTime endTime1 = LocalDateTime.of(2023, 1, 1, 12, 0);
            Movie movie1 = new Movie("Movie 1", startTime1, endTime1);

            LocalDateTime startTime2 = LocalDateTime.of(2023, 1, 1, 13, 0);
            LocalDateTime endTime2 = LocalDateTime.of(2023, 1, 1, 15, 0);
            Movie movie2 = new Movie("Movie 2", startTime2, endTime2);

            LocalDateTime startTime3 = LocalDateTime.of(2023, 1, 1, 16, 0);
            LocalDateTime endTime3 = LocalDateTime.of(2023, 1, 1, 18, 0);
            Movie movie3 = new Movie("Movie 3", startTime3, endTime3);

            // Добавляем фильмы в расписание зала
            cinemaHall.addMovie(movie1);
            cinemaHall.addMovie(movie2);
            cinemaHall.addMovie(movie3);

            // Попытка бронирования билетов
            cinemaHall.bookTicket("Movie 1", 5); // Здесь 5 - количество билетов

            // Печать расписания и информации о зале
            System.out.println("Расписание зала " + cinemaHall.getHallNumber() + ":");
            for (Movie movie : cinemaHall.getMoviesSchedule()) {
                System.out.println(movie.getTitle() + " - " + movie.getStartTime() + " to " + movie.getEndTime());
            }

            System.out.println("Доступные места в зале " + cinemaHall.getHallNumber() + ": " +
                    (cinemaHall.getTotalSeats() - cinemaHall.getBookedSeats()));
        } catch (SoldOutException | ScheduleConflictException | IllegalArgumentException e) {
            // Обработка возможных исключений
            e.printStackTrace();
        }
    }
}
