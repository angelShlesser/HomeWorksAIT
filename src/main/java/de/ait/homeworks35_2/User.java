package de.javalessons.homework35_2;

import java.util.ArrayList;

public class User {
    private String userName;
    private int age;
    private ArrayList<String> friendsList;
    public User(String name, int age) {
        this.userName = name;
        this.age = age;
        this.friendsList = new ArrayList<>();
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
        age = newAge;
    }
    public void addFriend(String friendName) {
        friendsList.add(friendName);
    }
    public void removeFriend(String friendName) {
        friendsList.remove(friendName);
    }
    public ArrayList<String> getFriends() {
        return friendsList;
    }
}

//Todo 1. делаем имя user_name более правильно без _
// 2. вносим в конструкт лист друзей пустой при создании юзера
// 3. исправляем в конструкте age на ввод возраста this.age = name;
// 4. начало метода пишется с маленько буквы
// 5. отсутствие комментариев
// 6. права доступа