package de.ait.homeworks39;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляров студентов
        Student studentAlex = new Student("Alex", 23);
        Student studentIgor = new Student("Igor", 26);
        Student studentLiza = new Student("Liza", 19);
        Student studentAnna = new Student("Anna", 20);

        // Создание экземпляра базы данных студентов
        StudentDatabase studentDatabase = new StudentDatabase();

        // Вывод всех студентов (должен быть пуст)
        studentDatabase.printAllStudents();

        // Добавление студентов в базу данных
        studentDatabase.addStudent(studentAlex);
        studentDatabase.addStudent(studentAnna);
        studentDatabase.addStudent(studentIgor);
        studentDatabase.addStudent(studentLiza);

        // Вывод всех студентов в базе данных
        studentDatabase.printAllStudents();

        // Удаление студента из базы данных (попытка удаления дважды)
        studentDatabase.removeStudent(studentAlex);
        // Попытка повторного удаления
        studentDatabase.removeStudent(studentAlex);

        System.out.println("-------");
    }
}
