package de.ait.homeworks42;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sportsman {
    /*
     a. Создайте класс Sportsman со следующими полями:
     - String name (имя спортсмена)
     - int age (возраст)
     - String sport (вид спорта)
     - int records (рекорд спортсмена)
     */
    private String name; //имя спортсмена
    private int age; // Возраст
    private String sport; //Вид спорта
    private int records; //рекорд спортсмена
    private static final Logger LOGGER = LoggerFactory.getLogger(Sportsman.class);

    public Sportsman(String name, int age, String sport, int records) {
        this.name = name;
        this.age = age;
        this.sport = sport;
        this.records = records;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sport='" + sport + '\'' +
                ", records=" + records +
                '}';
    }

    // c. Реализуйте метод updateRecord(int newRecord),
    // который будет обновлять рекорд спортсмена, если newRecord больше текущего рекорда.
    public boolean updateRecord(int newRecord) {
        if (newRecord > records) {
            setRecords(newRecord);
            LOGGER.info("Новый рекорд установлен: {} --> {}", getName(), newRecord);
            return true;
        } else {
            LOGGER.info("Попытка уставить новый рекорд {} не получилось. ({})", getName(), getRecords());
            return false;
        }
    }

    //Реализуйте метод isEligibleForCompetition(int minAge, int maxAge), который проверяет,
    //соответствует ли возраст спортсмена допустимому диапазону для участия в соревнованиях.
    public boolean isEligibleForCompetition(int minAge, int maxAge) {
        if (age >= minAge && age <= maxAge) {
            LOGGER.info("Возраст соответствует для участия соревнования {}", getName());
            return true;
        } else {
            LOGGER.error("Не соответствует для участия в соревнованиях {}", getName());
            return false;
        }
    }
}
