package de.ait.homeworks39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StudentDatabase {
    HashSet<Student> studentsList;

    // Конструктор для инициализации коллекции students.
    public StudentDatabase() {
        studentsList = new HashSet<>();
    }

    // Метод для добавления студента в базу данных.
    public boolean addStudent(Student student) {
        if (containsStudent(student)) {
            System.out.println("Не добавлен студент: " + student.getName());
            return false;
        } else {
            studentsList.add(student);
            System.out.println("Добавлен студент: " + student.getName());
            return true;
        }
    }

    // Метод для удаления студента из базы данных.
    public boolean removeStudent(Student student) {
        if (containsStudent(student)) {
            studentsList.remove(student);
            System.out.println("Студент удален: " + student.getName());
            return true;
        } else {
            System.out.println("Студент не найден для удаления: " + student.getName());
            return false;
        }
    }

    // Метод для проверки, содержится ли студент в базе данных.
    public boolean containsStudent(Student student) {
        return studentsList.contains(student);
    }

    // Переопределенный метод toString для вывода содержимого базы данных.
    @Override
    public String toString() {
        return "StudentDatabase{" +
                "studentsList=" + studentsList +
                '}';
    }

    // Метод для вывода всех студентов в базе данных.
    public void printAllStudents() {
        if (studentsList.isEmpty()) {
            System.out.println("Список студентов пуст.");
        } else {
            for (Student student : studentsList) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Age: " + student.getAge());
                System.out.println("-------");
            }
        }
    }
    //Поиск студента по имени
    public Student findStudentByName(String name) {
        if (studentsList.isEmpty()) {
            // Если список пуст, вернуть null, чтобы указать, что студент не найден.
            return null;
        }

        for (Student student : studentsList) {
            if (student.getName().equals(name)) {
                // Вернуть студента, если имя совпадает.
                return student;
            }
        }
        // Если студент с указанным именем не найден.
        return null;
    }
    //Получение списка студентов в определенном возрастном диапазоне:
    public List<Student> getStudentsInAgeRange(int minAge, int maxAge) {
        List<Student> studentsInAgeRange = new ArrayList<>();
        for (Student student : studentsList) {
            int age = student.getAge();
            if (age >= minAge && age <= maxAge) {
                studentsInAgeRange.add(student);
            }
        }

        if (studentsInAgeRange.isEmpty()) {
            System.out.println("Список студентов в указанном возрастном диапазоне пуст.");
        } else {
            System.out.println("Список студентов в указанном возрастном диапазоне:");
            for (Student student : studentsInAgeRange) {
                System.out.println(student);
            }
        }

        return studentsInAgeRange;
    }
    public int getStudentCount() {
        return studentsList.size();
    }
}