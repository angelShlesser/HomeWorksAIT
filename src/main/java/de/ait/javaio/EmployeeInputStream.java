package de.ait.javaio;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeInputStream {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeInputStream.class);
    private static String path = "files/employees.txt";

    public static void main(String[] args) {
        try (
                // Создаем поток ввода для файла
                FileInputStream fileInputStream = new FileInputStream(path);
                // Создаем объектный поток ввода для чтения объектов из файла
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            // Чтение объектов до достижения конца файла
            try {
                while (true) {
                    // Читаем объект из потока
                    Employee employee = (Employee) objectInputStream.readObject();
                    // Выводим информацию о прочитанном объекте
                    /* записываем в логгер если зарплата больше 5000 и имя */
                    if (employee.getSalary() > 5000 && employee.getName().equals("John Doe"))
                    LOGGER.info("Прочитан объект: ID = {}, Name = {}", employee.getId(), employee.getName());
                }
            } catch (EOFException e) {
                // Достигнут конец файла
                LOGGER.info("Завершено чтение. {}", e.getMessage());
            }
        } catch (FileNotFoundException e) {
            // Обработка ошибки отсутствия файла
            LOGGER.error("Файл {} не найден: {}", path, e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Обработка ошибок ввода-вывода
            LOGGER.error("Ошибка ввода-вывода: {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            // Обработка ошибки отсутствия класса Employee
            LOGGER.error("Класс Employee не найден: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
