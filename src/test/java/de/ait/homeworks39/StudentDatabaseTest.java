package de.ait.homeworks39;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;
    private Student studentInna;
    private Student studentSergei;
    private Student studentAnna;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
        studentInna = new Student("Inna", 25);
        studentSergei = new Student("Sergei", 27);
        studentAnna = new Student("Anna", 22);
    }

    @Test
    void testAddStudentSuccess() {
        Assertions.assertEquals(0,studentDatabase.getStudentCount());
        Assertions.assertTrue(studentDatabase.addStudent(studentInna));
        Assertions.assertEquals(1,studentDatabase.getStudentCount());
    }
    @Test
    void testAddStudentNull() {
        Assertions.assertFalse(studentDatabase.addStudent(null));
    }
    @Test
    void testAddStudentFalse() {
        Assertions.assertEquals(0,studentDatabase.getStudentCount());
        studentDatabase.addStudent(studentInna);
        Assertions.assertFalse(studentDatabase.addStudent(studentInna));
        Assertions.assertEquals(1,studentDatabase.getStudentCount());
    }

    @Test
    void testAddDuplicateStudent() {
        Assertions.assertTrue(studentDatabase.addStudent(studentInna));
        Assertions.assertEquals(1, studentDatabase.getStudentCount());
        Assertions.assertFalse(studentDatabase.addStudent(studentInna));
        Assertions.assertEquals(1, studentDatabase.getStudentCount());
    }

    @Test
    void testRemoveStudent() {
        Assertions.assertEquals(0,studentDatabase.getStudentCount());
        studentDatabase.addStudent(studentInna);
        studentDatabase.addStudent(studentSergei);
        Assertions.assertEquals(2,studentDatabase.getStudentCount());
        Assertions.assertTrue(studentDatabase.removeStudent(studentSergei));
        Assertions.assertEquals(1,studentDatabase.getStudentCount());
    }
    @Test
    void testPrintAllStudentsEmptyDatabase() {
        studentDatabase.printAllStudents();
    }

    @Test
    void testPrintAllStudents() {
        studentDatabase.addStudent(studentInna);
        studentDatabase.addStudent(studentAnna);
        studentDatabase.printAllStudents();
    }
    @Test
    void testRemoveNullStudent() {
        Assertions.assertFalse(studentDatabase.removeStudent(null));
    }
    @Test
    void testRemoveStudentEmptyDatabase() {
        Assertions.assertFalse(studentDatabase.removeStudent(studentInna));
    }
    @Test
    void testFindStudentByName() {
        // Проверяем, что список пуст, ожидаем null
        Assertions.assertNull(studentDatabase.findStudentByName("Inna"));

        studentDatabase.addStudent(studentInna);
        studentDatabase.addStudent(studentSergei);
        studentDatabase.addStudent(studentAnna);

        Student foundStudent = studentDatabase.findStudentByName("Inna");
        // Проверяем, что студент найден
        Assertions.assertNotNull(foundStudent);
        Assertions.assertEquals("Inna", foundStudent.getName());

        foundStudent = studentDatabase.findStudentByName("John");
        // Проверяем, что студент не найден, ожидаем null
        Assertions.assertNull(foundStudent);
    }

    @Test
    void testGetStudentsInAgeRange() {
        // Проверяем, что список пуст
        Assertions.assertEquals(0, studentDatabase.getStudentCount());

        studentDatabase.addStudent(studentInna);
        studentDatabase.addStudent(studentSergei);
        studentDatabase.addStudent(studentAnna);

        List<Student> studentsInRange = studentDatabase.getStudentsInAgeRange(20, 26);
        // Проверяем, что вернулось 2 студента
        Assertions.assertEquals(2, studentsInRange.size());

        studentsInRange = studentDatabase.getStudentsInAgeRange(28, 30);
        // Проверяем, что список пуст
        Assertions.assertTrue(studentsInRange.isEmpty());

        studentsInRange = studentDatabase.getStudentsInAgeRange(19, 27);
        // Проверяем, что вернулось 3 студента
        Assertions.assertEquals(3, studentsInRange.size());

    }

    @Test
    void testGetStudentCount() {
        // Проверяем, что список пуст
        Assertions.assertEquals(0, studentDatabase.getStudentCount());

        studentDatabase.addStudent(studentInna);
        studentDatabase.addStudent(studentSergei);
        studentDatabase.addStudent(studentAnna);
        // Проверяем, что список содержит 3 студента
        Assertions.assertEquals(3, studentDatabase.getStudentCount());
    }
}