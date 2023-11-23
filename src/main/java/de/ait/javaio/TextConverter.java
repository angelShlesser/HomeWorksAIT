package de.ait.javaio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class TextConverter {
    // Инициализация логгера с использованием SLF4J
    private static final Logger LOGGER = LoggerFactory.getLogger(TextConverter.class);

    /**
     * Преобразует каждое слово в прочитанном тексте в нижний регистр
     * и записывает результат в другой файл.
     *
     * @param input  Reader для чтения текста из файла.
     * @param output Writer для записи обработанного текста в файл.
     * @return Строка, содержащая преобразованный текст.
     * @throws IOException В случае ошибок ввода/вывода.
     */
    public String convertToLowerCase(Reader input, Writer output) throws IOException {
        // Инициализация BufferedReader и BufferedWriter для эффективного чтения и записи
        try (BufferedReader bufferedReader = new BufferedReader(input);
             BufferedWriter bufferedWriter = new BufferedWriter(output)) {
            String line;
            StringBuilder convertedTextBuilder = new StringBuilder();

            // Чтение строк из файла
            while ((line = bufferedReader.readLine()) != null) {
                // Разделение строки на слова
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    // Преобразование каждого слова в нижний регистр и запись в BufferedWriter
                    String lowerCaseWord = words[i].toLowerCase();
                    bufferedWriter.write(lowerCaseWord);
                    bufferedWriter.write(" ");
                    convertedTextBuilder.append(lowerCaseWord).append(" ");
                }
                // Добавление новой строки после обработки каждой строки текста
                bufferedWriter.newLine();
                convertedTextBuilder.append(System.lineSeparator());
            }

            LOGGER.info("Запись успешно завершена");
            return convertedTextBuilder.toString().trim(); // Убрать лишние пробелы в конце строки
        }
    }
}
