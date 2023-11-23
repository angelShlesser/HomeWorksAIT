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
        // Использование try-with-resources для автоматического закрытия ресурсов
        try (BufferedReader bufferedReader = new BufferedReader(input);
             BufferedWriter bufferedWriter = new BufferedWriter(output)) {
            String line;
            String lowerCaseWord = null;
            // Чтение строк из файла
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    // Преобразование слова в нижний регистр
                    lowerCaseWord = words[i].toLowerCase();
                    // Добавление пробела перед словом, если это не первое слово в строке
                    if (i > 0) {
                        bufferedWriter.write(" ");
                    }
                    // Запись преобразованного слова в файл
                    bufferedWriter.write(lowerCaseWord);
                }
                // Добавление новой строки после обработки каждой строки текста
                bufferedWriter.newLine();
            }
            // Принудительное опорожнение буферов записи
            bufferedWriter.flush();
            // Логирование успешного завершения записи
            LOGGER.info("Запись успешно завершена");
            return lowerCaseWord;
        }
    }
}
