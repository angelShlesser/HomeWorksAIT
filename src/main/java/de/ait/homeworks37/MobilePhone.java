package de.ait.homeworks37;

public class MobilePhone {
    /*
    Разработка классов модели:
    MobilePhone: класс, представляющий мобильный телефон с атрибутами,
    такими как id, brand, model, operatingSystem и price.
    Класс должен включать конструкторы, методы доступа (геттеры и сеттеры)
     */
    private int id;
    private String brand;
    private String model;
    private int operatingSystem;
    private double price;
    //Создаем конструктор
    public MobilePhone(int id, String brand, String model, int operatingSystem, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.price = price;
    }
    //Создаем геттеры и зет торы

    public int getId() {
        return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
            this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(int operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", price=" + price +
                '}';
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
