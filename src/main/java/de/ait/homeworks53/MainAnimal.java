package de.ait.homeworks53;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainAnimal {
    // Инициализация логгера с использованием SLF4J
    private static final Logger LOGGER = LoggerFactory.getLogger(MainAnimal.class);

    public static void main(String[] args) {
        // Создаем объекты Animal
        Animal lion = new Animal("Leo", "Lion", 5);
        Animal elephant = new Animal("Ellie", "Elephant", 10);
        Animal giraffe = new Animal("Gerry", "Giraffe", 7);
        // Путь к файлу
        String filePath = "files/animals.txt";
        File file = new File(filePath);

        // Создаем список животных
        List<Animal> animals = new ArrayList<>();
        animals.add(lion);
        animals.add(elephant);
        animals.add(giraffe);

        try {
            // Попытка создания файла
            if (file.createNewFile()) {
                LOGGER.info("Файл успешно создан: {}", filePath);
            } else {
                LOGGER.info("Файл уже существует: {}", filePath);
            }
        } catch (IOException exception) {
            LOGGER.error("Ошибка при создании файла: {}", exception.getMessage());
        }

        // Запись в файл animals.txt
        AnimalFileHandler.writeToFile(animals, filePath);

        // Чтение из файла
        LOGGER.info("Чтение данных о животных из файла: {}", filePath);
        AnimalFileHandler.readFromFile(filePath);
    }
}