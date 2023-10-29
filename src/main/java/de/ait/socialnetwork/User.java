package de.ait.socialnetwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.friends = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<User> getFriends() {
        List<User> usersToReturn = new ArrayList<>(friends);
        return usersToReturn;
    }

    //addFriend(User friend): добавляет друга в список друзей.
    public boolean addFriend(User newFriend) {
        if (newFriend == null) {
            LOGGER.error("Пользователь равен null");
            return false;
        }

        for (User userFriends : friends)
            if (userFriends.getId() == newFriend.getId()) {
                LOGGER.error("Пользователь с id {} существует в списке друзей", userFriends.getId());
                return false;
            }

        LOGGER.info("Новый пользователь с id {} добавлен в список друзей", newFriend.getId());
        return friends.add(newFriend);
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
