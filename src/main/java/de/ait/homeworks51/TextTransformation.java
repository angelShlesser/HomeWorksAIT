package de.ait.homeworks51;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class TextTransformation {
    private static final Logger LOGGER = LoggerFactory.getLogger(TextTransformation.class);

    public static void main(String[] args) throws IOException {
        File sourceFile = new File("files/source.txt");
        File destinationFile = new File("files/destination.txt");

        try {
            if (sourceFile.exists() && destinationFile.exists()) {
                System.out.println("Файлы уже существуют");
            }

            sourceFile.createNewFile();
            destinationFile.createNewFile();
            LOGGER.info("Файл был создан: {}", sourceFile.getName());
            LOGGER.info("Файл был создан: {}", destinationFile.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Чтение и обработка текста из source.txt
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFile))) {

            String lineInDocument = bufferedReader.readLine();

            while (lineInDocument != null) {
                // Инверсия каждого слова
                String invertedLine = invertWords(lineInDocument);

                // Вывод в консоль
                System.out.println(invertedLine);

                // Запись в файл destination.txt
                bufferedWriter.write(invertedLine);
                bufferedWriter.newLine();

                // Считываем следующую строку
                lineInDocument = bufferedReader.readLine();
            }

            LOGGER.info("Обработка текста и запись в файл успешно завершены.");
        }
    }

    private static String invertWords(String input) {
        // Разделение строки на слова
        String[] words = input.split("\\s");

        // Инверсия каждого слова
        StringBuilder invertedLine = new StringBuilder();
        for (String word : words) {
            invertedLine.append(invertWord(word)).append(" ");
        }

        return invertedLine.toString().trim();
    }

    private static String invertWord(String word) {
        // Инверсия символов в слове
        StringBuilder invertedWord = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            invertedWord.append(word.charAt(i));
        }

        return invertedWord.toString();
    }
}
