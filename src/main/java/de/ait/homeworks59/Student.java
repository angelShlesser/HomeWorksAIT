package de.ait.homeworks59;

public class Student {
    private String firstName;
    private String lastName;
    private double averageGrade;

    private int age;

    public Student(String lastName, String firstName, double averageGrade, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.averageGrade = averageGrade;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", averageGrade=" + averageGrade +
                ", age=" + age +
                '}';
    }
}
