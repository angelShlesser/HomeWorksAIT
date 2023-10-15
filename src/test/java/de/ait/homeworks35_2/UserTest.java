package de.ait.homeworks35_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("Иван", 30);
    }

    @Test
    void testGetName() {
        assertEquals("Иван", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("Петр");
        assertEquals("Петр", user.getName());
    }

    @Test
    void testGetAge() {
        assertEquals(30, user.getAge());
    }

    @Test
    void testSetAge() {
        user.setAge(20);
        assertEquals(20, user.getAge());
    }

    @Test
    void testAddFriend() {
        user.addFriend("Маша");
        user.addFriend("Оля");
        List<String> expectedFriends = new ArrayList<>();
        expectedFriends.add("Маша");
        expectedFriends.add("Оля");
        assertEquals(expectedFriends, user.getFriends());
    }

    @Test
    void testRemoveFriend() {
        user.addFriend("Саша");
        user.addFriend("Маша");
        user.removeFriend("Саша");
        ArrayList<String> expectedFriends = new ArrayList<>();
        expectedFriends.add("Маша");
        assertEquals(expectedFriends, user.getFriends());
    }

}