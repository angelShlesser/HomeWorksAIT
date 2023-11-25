package de.ait.homeworks52;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AirportFileCreator {
    private static final Logger LOGGER = LoggerFactory.getLogger(AirportFileCreator.class);

    public static void main(String[] args) {
        File file = new File("files/airports.txt");

        if (!file.exists()) {
            try {
                // Создание всех несуществующих директорий
                file.getParentFile().mkdirs();

                if (file.createNewFile()) {
                    LOGGER.info("Успешное создание файла: {}", file.getAbsolutePath());
                } else {
                    LOGGER.error("Не удалось создать файл.");
                }
            } catch (IOException e) {
                LOGGER.error("Ошибка при создании файла: {}", e.getMessage());
            }
        } else {
            LOGGER.warn("Файл уже существует: {}", file.getAbsolutePath());
        }

        // Информация об аэропортах
        String[] airportData = {
                "Paris-Charles-de-Gaulle;CDG;France",
                "Heathrow Airport;LHR;United Kingdom",
                "Los Angeles International Airport;LAX;United States",
                "Tokyo Haneda Airport;HND;Japan",
                "Sydney Airport;SYD;Australia",
                "Berlin Brandenburg Airport;BER;Germany",
                "Beijing Capital International Airport;PEK;China",
                "Dubai International Airport;DXB;United Arab Emirates",
                "Johannesburg OR Tambo International Airport;JNB;South Africa",
                "Moscow Sheremetyevo International Airport;SVO;Russia"
        };

        // Вызов метода для создания файла с информацией об аэропортах
        createAirportFile(file, airportData);
    }

    /**
     * Создает файл с информацией об аэропортах.
     *
     * @param filePath    Путь к файлу.
     * @param airportData Массив строк с информацией об аэропортах.
     */
    public static void createAirportFile(File filePath, String[] airportData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String data : airportData) {
                writer.write(data);
                writer.newLine();
                LOGGER.info("Информация записана: {}", data);
            }
            LOGGER.info("Информация успешно записана в файл: {}", filePath);
        } catch (IOException e) {
            LOGGER.error("Ошибка при создании файла: {}", e.getMessage());
        }
    }
}
