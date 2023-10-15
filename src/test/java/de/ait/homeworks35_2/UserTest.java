package de.javalessons.homework35_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User vitali;
    private User alex;
    private User igor;
    @BeforeEach
    void setUp() {
        vitali = new User("Vitali", 36);
        alex = new User("Alex", 45);
        igor = new User("Igor", 32);
    }

    @Test
    void setName() {
        vitali.setName("lexa");
        Assertions.assertEquals("lexa",vitali.getName());
    }

    @Test
    void getAge() {
        Assertions.assertEquals(32,igor.getAge());
    }

    @Test
    void setAge() {
        vitali.setAge(38);
        Assertions.assertEquals(38,vitali.getAge());
    }

    @Test
    void addFriend() {
        vitali.addFriend("Liza");
        vitali.addFriend("Katrin");
        vitali.addFriend("Robert");
        ArrayList<String> friends = vitali.getFriends();
        // Проверяем, что размер списка друзей равен ожидаемому
        assertEquals(3, friends.size());
        // Проверяем, что список друзей содержит конкретных друзей
        assertTrue(friends.contains("Liza"));
        assertTrue(friends.contains("Katrin"));
        assertTrue(friends.contains("Robert"));
    }

    @Test
    void removeFriend() {
        vitali.addFriend("Alice");
        vitali.addFriend("Bob");
        vitali.addFriend("Charlie");

        ArrayList<String> friends = vitali.getFriends();
        assertFalse(friends.contains("Alice"));
        assertTrue(friends.contains("Bob"));
        assertTrue(friends.contains("Charlie"));
    }

    @Test
    void removeFriendFromEmptyList() {
        ArrayList<String> friends = vitali.getFriends();
        assertTrue(friends.isEmpty()); // Убеждаемся, что список друзей пустой
    }

    @Test
    void getFriends() {
        vitali.addFriend("Alice");
        vitali.addFriend("Bob");
        vitali.addFriend("Charlie");

        ArrayList<String> friends = vitali.getFriends();

        assertEquals(3, friends.size());
        assertTrue(friends.contains("Alice"));
        assertTrue(friends.contains("Bob"));
        assertTrue(friends.contains("Charlie"));
    }
}