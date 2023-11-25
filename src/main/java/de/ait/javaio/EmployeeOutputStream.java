package de.ait.javaio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeOutputStream {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeOutputStream.class);
    private static String path = "files/employees.txt";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee employeeBatman = new Employee(1123, "Batman", 500.0);
        Employee employeeRobin = new Employee(1124, "Robin", 600.0);
        Employee employeeJohn = new Employee(1001, "John Doe", 7000.0);
        Employee employeeJane = new Employee(1002, "Jane Smith", 8000.0);
        Employee employeeBob = new Employee(1003, "Bob Johnson", 5000.0);

        // Добавление всех сотрудников в коллекцию
        employees.add(employeeBatman);
        employees.add(employeeRobin);
        employees.add(employeeJohn);
        employees.add(employeeJane);
        employees.add(employeeBob);

        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {

            // Запись всех объектов из коллекции
            for (Employee employee : employees) {
                outputStream.writeObject(employee);
                outputStream.flush();
                LOGGER.info("Данные сотрудника успешно сохранены. ID: {}", employee.getId());
            }
            LOGGER.info("Данные записаны.");

        } catch (FileNotFoundException e) {
            LOGGER.error("Файл {} не найден или не создан: {}", path, e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Ошибка в обработке данных. Файл: {}, {}", path, e.getMessage());
        }
    }
}
