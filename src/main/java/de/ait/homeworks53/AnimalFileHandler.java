package de.ait.homeworks53;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AnimalFileHandler {
    // Инициализация логгера с использованием SLF4J
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimalFileHandler.class);

    /*
     * Метод для записи списка животных в файл.
    */
    public static void writeToFile(List<Animal> animals, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Animal animal : animals) {
                // Запись информации о животном в файл
                fileWriter.write("Имя: " + animal.getName() + ", Вид: " + animal.getSpecies() +
                        ", Возраст: " + animal.getAge() + "\n");
            }
            LOGGER.info("Данные о животных успешно записаны в файл: {}", filePath);
        } catch (IOException exception) {
            // Обработка ошибок ввода-вывода
            LOGGER.error("Ошибка при записи в файл: {}", exception.getMessage());
        }
    }

    /*
     * Метод для чтения из файла и вывода на экран.
    */
    public static void readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Вывод информации о животных на экран
                System.out.println(line);
            }
            LOGGER.info("Чтение данных о животных из файла: {}", filePath);
        }
        catch (FileNotFoundException exception){
            LOGGER.error("Файл не найден {}", exception.getMessage());
        }
        catch (IOException exception) {
            // Обработка ошибок ввода-вывода
            LOGGER.error("Ошибка при чтении из файла: {}", exception.getMessage());
        }
    }
}