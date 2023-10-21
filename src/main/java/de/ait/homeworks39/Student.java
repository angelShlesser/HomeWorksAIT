package de.ait.homeworks39;

import java.util.UUID;

public class Student {
    /*
    Поля:
    id (int): уникальный идентификатор студента.
    name (String): имя студента.
    age (int): возраст студента.
     */
    private UUID id;
    private String name;
    private int age;
//Конструктор для инициализации всех полей. Геттеры/Сеттеры.
    public Student(String name, int age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
