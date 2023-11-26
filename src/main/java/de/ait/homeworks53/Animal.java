package de.ait.homeworks53;

public class Animal {
    /*
    Создайте класс Animal, который содержит поля name (имя), species (вид), и age (возраст).
    Добавьте конструктор, геттеры и сеттеры для этих полей.
     */
    private String name;
    private String species;
    private int age;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
