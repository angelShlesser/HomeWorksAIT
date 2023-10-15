package de.ait.homeworks35_2;

import java.util.ArrayList;
import java.util.List;

public class User {

    //TODO: 1. Отсутствуют комментарии
    // 2. Неправильное наименование переменных
    // 3. Неправильное наименование методов
    // 4. Не безопасный возврат списка друзей
    // 5. Неправильная инициализация конструкторв
    // 6. Неправиьный модификатор доступа списка друзей
    // 7. Использование ArrayList вместо List

    private String userName;
    private int age;
    private List<String> friendsList = new ArrayList<>();

    public User(String name, int age) {
        this.userName = name;
        this.age = age;
    }

    public String getName() {
        return userName;
    }

    public void setName(String newName) {
        this.userName = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public void addFriend(String friendName) {
        friendsList.add(friendName);
    }

    public void removeFriend(String friendName) {
        friendsList.remove(friendName);
    }

    public List<String> getFriends() {
        //Также, вы создали новый список друзей для возврата методом getFriends(),
        //чтобы предотвратить изменение исходного списка друзей при получении его.
        return new ArrayList<>(friendsList);
    }

}
