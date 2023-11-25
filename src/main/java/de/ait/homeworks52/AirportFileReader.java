package de.ait.homeworks52;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AirportFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(AirportFileReader.class);

    public static void main(String[] args) {
        File file = new File("files/airports.txt");

        if (file.exists()) {
            try (
                    // Создание BufferedReader для чтения из файла
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    ){

                // Чтение строк из файла
                String line;
                while ((line = reader.readLine()) != null) {
                    // Разделение строки на части
                    String[] parts = line.split(";", 3);

                    if (parts.length == 3) {
                        // Вывод информации об аэропорте в консоль
                        String airportName = parts[0];
                        String iataCode = parts[1];
                        String country = parts[2];

                        LOGGER.info("Название: {}, Код: {}, Страна: {}",airportName,iataCode,country);
                    } else {
                        LOGGER.warn("Неверный формат строки в файле: {}", line);
                    }
                }
            } catch (IOException e) {
                LOGGER.error("Ошибка при чтении файла: {}", e.getMessage());
            }
        } else {
            LOGGER.error("Файл не существует: {}", file.getAbsolutePath());
        }
    }
}
