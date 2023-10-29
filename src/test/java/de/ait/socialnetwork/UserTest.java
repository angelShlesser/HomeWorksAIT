package de.ait.socialnetwork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User userAnna;
    private User userSergei;

    @BeforeEach
    void setUp() {
        userAnna = new User(1, "Анна");
        userSergei = new User(2, "Сергей");
    }

    @Test
    void testGetIdSuccess() {
        Assertions.assertEquals(1, userAnna.getId());
    }

    @Test
    void testGetFriendsSuccess() {
        Assertions.assertEquals(1, userAnna.getId());
    }

    @Test
    void testAddFriendSuccess() {
        assertTrue(userAnna.addFriend(userSergei));
    }

    @Test
    void testAddFriendFails() {
        userAnna.addFriend(userSergei);
        assertFalse(userAnna.addFriend(userSergei));
    }

    @Test
    void testAddFriendNull() {
        assertFalse(userAnna.addFriend(null));
    }

    @Test
    void testEquals() {
        User user1Copy = new User(1, "Alice");
        User user2Copy = new User(2, "Bob");

        // Проверка на равенство по id
        assertEquals(userAnna, user1Copy);
        assertEquals(userSergei, user2Copy);

        // Проверка на неравенство
        assertNotEquals(userAnna, userSergei);
        assertNotEquals(userAnna, null);
        assertNotEquals(userAnna, "Alice");
    }

    @Test
    void testHashCode() {
        User user1Copy = new User(1, "Alice");
        User user2Copy = new User(2, "Bob");

        // Проверка на равенство хэш-кодов
        assertEquals(userAnna.hashCode(), user1Copy.hashCode());
        assertEquals(userSergei.hashCode(), user2Copy.hashCode());
    }

    @Test
    void testGetFriends() {
        // Убедимся, что изначально список друзей пуст
        List<User> friendsList = userAnna.getFriends();
        assertTrue(friendsList.isEmpty());

        // Добавим друга
        userAnna.addFriend(userSergei);

        // Проверим, что список друзей теперь содержит этого друга
        friendsList = userAnna.getFriends();
        assertEquals(1, friendsList.size());
        assertTrue(friendsList.contains(userSergei));

        // Убедимся, что изменения в списке друзей не влияют на оригинальный список
        friendsList.add(new User(3, "Charlie"));
        friendsList = userAnna.getFriends();
        assertEquals(1, friendsList.size());
        assertFalse(friendsList.contains(new User(3, "Charlie")));
    }
}