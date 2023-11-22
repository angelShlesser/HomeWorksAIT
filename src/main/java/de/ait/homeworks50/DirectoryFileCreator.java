package de.ait.homeworks50;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryFileCreator {

    // Инициализация логгера с использованием SLF4J
    private static final Logger LOGGER = LoggerFactory.getLogger(DirectoryFileCreator.class);

    // Текст для запроса пользователя о пути для создания директории
    private static final String createText = "Задайте путь для создаваемой директории: ";

    // Имя директории, которую мы создадим
    private static final String myDirectory = "MyDirectory";

    public static void main(String[] args) {
        // Выводим текст запроса
        System.out.println(createText);

        // Инициализация сканнера для чтения пользовательского ввода
        Scanner scanner = new Scanner(System.in);

        // Получаем путь от пользователя
        String pathToCreate = scanner.nextLine();

        // Создаем объект File для директории, которую мы хотим создать
        File directoryToCreate = new File(pathToCreate + File.separator + myDirectory);

        // Создаем строку для пути к директории
        String path = pathToCreate + File.separator + myDirectory;

        // Объект File для результирующего файла, который мы создадим в директории
        File resultFile = null;

        // Проверяем, существует ли уже директория
        if (directoryToCreate.exists()) {
            // Если директория существует, выводим предупреждение
            LOGGER.warn("Создание директории {} невозможно. Она уже существует ", path);
            System.out.println("Создание директории " + path + " невозможно. Она уже существует");
        } else {
            // Если директории нет, пытаемся ее создать
            boolean created = directoryToCreate.mkdir();

            if (created) {
                // Если директория успешно создана, выводим сообщение
                LOGGER.info("Директория {} успешно создана", path);
                System.out.println("Директория" + path + " успешно создана");

                // Создаем файл внутри созданной директории
                resultFile = createFileInDirectory(path, "MyFile.txt");

                if (resultFile != null) {
                    // Если файл успешно создан, выводим сообщение
                    System.out.println("Файл успешно создан в директории " + path);
                } else {
                    // Если файл не создан, выводим сообщение об ошибке
                    System.out.println("Не удалось создать файл в директории " + path);
                }
            } else {
                // Если директория не создана, выводим предупреждение
                LOGGER.warn("Директория {} не была создана. Проверьте права.", path);
                System.out.println("Директория " + path + " не была создана. Проверьте права.");
            }

            // Если у нас есть результат (т.е., директория была создана успешно)
            if (resultFile != null) {
                // Тут вы можете вызвать метод deleteFileAndDirectory
                //deleteFileAndDirectory(resultFile, directoryToCreate);
            }
        }
    }

    // Метод для создания файла в указанной директории
    private static File createFileInDirectory(String directory, String fileName) {
        // Создаем объект File для файла
        File file = new File(directory + File.separator + fileName);

        try {
            // Пытаемся создать файл
            boolean resultFileCreated = file.createNewFile();

            if (resultFileCreated) {
                // Если файл успешно создан, выводим сообщение
                LOGGER.info("Файл {} в директории {} был успешно создан", fileName, directory);
                return file;
            } else {
                // Если файл не создан, выводим сообщение об ошибке
                LOGGER.warn("Не удалось создать файл {} в директории {}", fileName, directory);
                return null;
            }
        } catch (IOException exception) {
            // Если произошла ошибка, выводим сообщение об ошибке
            LOGGER.error("Исключение при создании файла {} в директории {}, Описание: {} ",
                    fileName, directory, exception.getMessage());
            return null;
        }
    }

    // Метод для удаления файла и директории
    private static boolean deleteFileAndDirectory(File fileToDelete, File directoryToCreate) {
        // Пытаемся удалить файл
        boolean deleteResult = fileToDelete.delete();

        if (deleteResult) {
            // Если файл успешно удален, выводим сообщение
            LOGGER.info("Файл {} был успешно удален в директории {}",
                    fileToDelete.getName(), fileToDelete.getAbsolutePath());

            // Пытаемся удалить директорию
            directoryToCreate.delete();

            // Если директория успешно удалена, выводим сообщение
            LOGGER.info("Директория {} была успешно удалена", directoryToCreate.getAbsolutePath());

            return true;
        } else {
            // Если файл не удален, выводим предупреждение
            LOGGER.warn("Файл {} не был удален в директории {}",
                    fileToDelete.getName(), fileToDelete.getAbsolutePath());
            return false;
        }
    }
}