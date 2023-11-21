package de.ait.javaio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class JavaIOStreams {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaIOStreams.class);

    private static final String PATH = "/Users/developer/Documents/DEVELOPMENT/giftbowRepo/JavaLessonAIT/password.txt";


    public static void main(String[] args) {
        try {
            InputStream inputStream  = null;

            inputStream.close();
        }
        catch (FileNotFoundException exception) {
            LOGGER.error("Файл {} не найден {}", PATH, exception.getMessage());
        }
        catch (IOException exception){
           LOGGER.error("Ошибка при закрытии потока: {}", exception.getMessage());
        }
        catch (Exception exception){
            LOGGER.error("Иная ошибка при работе с потоком: {}", exception.getMessage());
        }

    }
}



