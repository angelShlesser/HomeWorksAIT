package de.ait.test41_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    /*
    Поля:
    id: int – уникальный идентификатор пользователя.
    name: String – имя пользователя.
    friends: ArrayList<User> – список друзей пользователя.
     */
    private int id;
    private String name;
    private List<User> friends;

    public List<User> getFriends() {
        return friends;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.friends = new ArrayList<>();
    }
    //addFriend(User friend): добавляет друга в список друзей.
    public void addFriend(User friend) {
        if (friend != null && !friends.contains(friend)) {
            friends.add(friend);
        }
    }
    /*
    equals(Object obj): переопределите, чтобы сравнивать пользователей по id.
    hashCode(): переопределите в соответствии с equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
