package de.ait.homeworks51;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TextTransformationOnline {
    // Инициализация логгера с использованием SLF4J
    private static final Logger LOGGER = LoggerFactory.getLogger(TextTransformationOnline.class);
    // Пути к исходному и целевому файлам
    private static final String SOURCE_FILE = "files/source.txt";
    private static final String DESTINATION_FILE = "files/destination.txt";

    public static void main(String[] args) {
        // Использование try-with-resources для автоматического закрытия ресурсов
        try (FileReader reader = new FileReader(SOURCE_FILE);
             FileWriter writer = new FileWriter(DESTINATION_FILE)) {
            // Вызов метода для записи обработанного текста
            writeReversedTextFile(reader, writer);

        } catch (FileNotFoundException exception) {
            // Обработка исключения, если файл не найден
            LOGGER.error("Файл не найден {}", exception.getMessage());

        } catch (IOException exception) {
            // Обработка других исключений ввода-вывода
            LOGGER.error("Ошибка в обработке файла {}", exception.getMessage());
        }
    }

    // Метод для записи инвертированного текста в файл
    public static void writeReversedTextFile(Reader reader, Writer writer) throws IOException {
        // Инициализация BufferedReader и BufferedWriter для эффективного чтения и записи
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        String line;
        // Чтение строк из файла
        while ((line = bufferedReader.readLine()) != null) {
            // Разделение строки на слова
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                // Инвертирование каждого слова и запись в BufferedWriter
                String reversedWord = reverserString(words[i]);
                bufferedWriter.write(reversedWord);
                bufferedWriter.write(" ");
            }
            // Добавление новой строки после обработки каждой строки текста
            bufferedWriter.newLine();
        }
        // Принудительное опорожнение буферов записи
        bufferedWriter.flush();
        LOGGER.info("Запись успешно завершена");
    }

    // Метод для инвертирования строки
    public static String reverserString(String wordToReverse) {
        // Создание массива символов для инвертирования
        char[] lettersArray = new char[wordToReverse.length()];
        // Инвертирование символов
        for (int i = 0, j = wordToReverse.length() - 1; i <= j; i++, j--) {
            lettersArray[i] = wordToReverse.charAt(j);
            lettersArray[j] = wordToReverse.charAt(i);
        }
        // Создание строки из инвертированного массива символов
        String wordToReturn = new String(lettersArray);
        // Вывод информации в лог о успешной обработке слова
        LOGGER.info("Слово {} успешно обработано. Результат {}", wordToReverse, wordToReturn);
        // Возвращение инвертированного слова
        return wordToReturn;
    }
    public static String reverserStringSmall(String wordToReverse) {
        // Создаем объект StringBuilder, передавая ему входную строку
        StringBuilder reversedStringBuilder = new StringBuilder(wordToReverse);

        // Используем метод reverse() для инвертирования содержимого StringBuilder
        reversedStringBuilder.reverse();
        // Вывод информации в лог о успешной обработке слова
        LOGGER.info("Слово {} успешно обработано. Результат {}", wordToReverse, reversedStringBuilder.reverse());
        // Преобразуем инвертированный StringBuilder обратно в строку и возвращаем результат
        return reversedStringBuilder.toString();
    }
}
