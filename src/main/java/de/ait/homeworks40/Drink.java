package de.ait.homeworks40;

public class Drink {
    private String name; //название
    private String type; //тип напитка: алкогольный, безалкогольный и т.д.
    private double volume; //объем в мл
    //создаем конструктор
    public Drink(String name, String type, double volume) {
        this.name = name;
        this.type = type;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", volume=" + volume +
                '}';
    }
}
