package de.ait.homeworks36;

//Lessons 36 home
public class Superhero {
    //String name: имя супергероя.
    private String name;
    //int power: уровень силы супергероя (от 1 до 10).
    private int power;
    //int age: возраст супергероя.
    private int age;

    /*Реализуйте конструктор для класса Superhero, который принимает параметры name,
    power и age и инициализирует соответствующие поля.*/
    public Superhero(String name, int power, int age) {
        this.name = name;
        if (power < 1) {
            this.power = 1; // Минимальное значение силы
        } else if (power > 10) {
            this.power = 10; // Максимальное значение силы
        } else {
            this.power = power;
        }
        this.age = age;
    }
    //Добавьте геттеры и сеттеры для всех полей.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power < 1) {
            // Минимальное значение силы - 1
            this.power = 1;
        } else if (power > 10) {
            // Максимальное значение силы - 10
            this.power = 10;
        } else {
            this.power = power;
        }
    }

    public int getAge() {
        return age;
    }

    // для возраста ограничения не вижу смысла делать, он может быть из будущего или жить тысячилетиями=)
    public void setAge(int age) {
        this.age = age;
    }

    /*
    Переопределите метод toString() для класса Superhero,
    чтобы он возвращал строку с информацией о супергерое в формате: "Имя: [name], Сила: [power], Возраст: [age]".
     */
    @Override
    public String toString() {
        return "\nИмя: [" + name + "] Сила: [" + power + "] Возраст: [" + age + "]";
    }
}
