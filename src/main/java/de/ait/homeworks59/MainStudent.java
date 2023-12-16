package de.ait.homeworks59;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainStudent {
    // Логгер для этого класса
    private static final Logger LOGGER = LoggerFactory.getLogger(MainStudent.class);

    public static void main(String[] args) {
        // Создание объектов студентов
        Student student1 = new Student("Zirn", "Alisa", 4.5, 19);
        Student student2 = new Student("Ivanov", "Sergei", 4.3, 23);
        Student student3 = new Student("Ynnul", "Lisa", 3.7, 20);
        Student student4 = new Student("Sonov", "Robert", 4.8, 25);
        Student student5 = new Student("Rechnov", "Alex", 4.4, 24);

        // Создание списка студентов и добавление в него студентов
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        // Фильтрация студентов с баллами выше 4.4
        double averageGradeToCheck = 4.4;
        List<Student> result = studentList.stream().filter(student -> student.getAverageGrade() > averageGradeToCheck).toList();
        result.forEach(System.out::println);

        // Сортировка студентов по фамилии
        studentList.sort(Comparator.comparing(student -> {
            // Предположим, что фамилия находится после последнего пробела в полном имени
            int lastSpaceIndex = student.getFirstName().lastIndexOf(" ");
            return lastSpaceIndex != -1 ? student.getFirstName().substring(lastSpaceIndex + 1) : student.getFirstName();
        }));

        // Сортировка студентов по фамилии (вариант 1)
        studentList.sort((studentOne, studentTwo) -> studentOne.getLastName().compareTo(studentTwo.getLastName()));

        // Сортировка студентов по фамилии (вариант 2)
        studentList.sort(Comparator.comparing(Student::getLastName));

        // Сортировка студентов по фамилии (вариант 3)
        result = studentList.stream()
                .sorted(Comparator.comparing(Student::getLastName)).toList();

        result.forEach(System.out::println);

        // Вывод отсортированного списка по фамилии
        LOGGER.info("\nОтсортированный список по фамилии:");
        studentList.forEach(student -> LOGGER.info(student.toString()));

        // Преобразование списка студентов в список их имен
        List<String> namesList = studentList.stream()
                .map(Student::getFirstName)
                .toList();

        // Вывод списка имен
        LOGGER.info("\nСписок имен:");
        namesList.forEach(LOGGER::info);

        // Фильтрация студентов с возрастом больше 22 и вывод их количества
        int targetAge = 22;
        long countResult = studentList.stream().filter(student -> student.getAge() > targetAge).count();
        LOGGER.info("Количество студентов с возрастом больше {}: {}", targetAge, countResult);

        // Нахождение студента с максимальным средним баллом
        Optional<Student> maxStudent = studentList.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade));

        maxStudent.ifPresent(student ->
                LOGGER.info("Студент с максимальным средним баллом: {}", student.getLastName()));
        //Вариант 2
        Student best = studentList.stream().reduce((studentOne, studentTwo) -> studentOne.getAverageGrade() > studentTwo.getAverageGrade() ? studentOne:studentTwo).orElse(null);
        System.out.println("Вариант 2. Студент с максимальным средним баллом:" + best);
        // Нахождение студента с минимальным средним баллом
        Optional<Student> minStudent = studentList.stream()
                .min(Comparator.comparingDouble(Student::getAverageGrade));

        minStudent.ifPresent(student ->
                LOGGER.info("Студент с минимальным средним баллом: {}", student.getLastName()));
    }
}
