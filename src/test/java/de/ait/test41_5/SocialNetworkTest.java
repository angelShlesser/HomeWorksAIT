package de.ait.test41_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SocialNetworkTest {
    private SocialNetwork socialNetwork;
    private User user1;
    private User user2;
    private Group group1;

    @BeforeEach
    void setUp() {
        socialNetwork = new SocialNetwork();
        user1 = new User(1, "Alice");
        user2 = new User(2, "Bob");
        group1 = new Group(1, "Friends");

        socialNetwork.registerUser(1, "Alice");
        socialNetwork.registerUser(2, "Bob");
        socialNetwork.createGroup(1, "Friends");
    }

    @Test
    void testRegisterUser() {
        User newUser = socialNetwork.registerUser(3, "Charlie");

        // Попытка зарегистрировать пользователя с тем же ID
        User existingUser = socialNetwork.registerUser(1, "David");
        assertNull(existingUser);

        // Попытка зарегистрировать пользователя с null именем
        User userWithNullName = socialNetwork.registerUser(4, null);
        assertNull(userWithNullName);
    }

    @Test
    void testCreateGroup() {
        Group newGroup = socialNetwork.createGroup(2, "Colleagues");

        // Попытка создать группу с тем же ID
        Group existingGroup = socialNetwork.createGroup(1, "School Friends");
        assertNull(existingGroup);

        // Попытка создать группу с null названием
        Group groupWithNullName = socialNetwork.createGroup(3, null);
        assertNull(groupWithNullName);
    }

    @Test
    void testCreatePost() {
        Post post = socialNetwork.createPost(user1, "Hello, World!");
        assertNotNull(post);

        // Попытка создать пост с null автором
        Post postWithNullAuthor = socialNetwork.createPost(null, "Null author post");
        assertNull(postWithNullAuthor);

        // Попытка создать пост с null содержанием
        Post postWithNullContent = socialNetwork.createPost(user2, null);
        assertNull(postWithNullContent);
    }

    @Test
    void testGetFriends() {
        // Добавляем друзей
        user1.addFriend(user2);
        user2.addFriend(user1);

        List<User> user1Friends = socialNetwork.getFriends(user1);
        List<User> user2Friends = socialNetwork.getFriends(user2);

        assertNotNull(user1Friends);
        assertNotNull(user2Friends);
        assertEquals(1, user1Friends.size());
        assertEquals(1, user2Friends.size());
        assertTrue(user1Friends.contains(user2));
        assertTrue(user2Friends.contains(user1));

        // Попытка получить друзей для пользователя без друзей
        User user3 = new User(3, "Charlie");
        List<User> user3Friends = socialNetwork.getFriends(user3);
        assertNull(user3Friends);
    }

    @Test
    void testGetUserGroups() {
        // Добавляем пользователя в группу
        group1.addMember(user1);
        List<Group> user1Groups = socialNetwork.getUserGroups(user1);

        assertNotNull(user1Groups);
        assertEquals(0, user1Groups.size());
        assertFalse(user1Groups.contains(group1));

        // Попытка получить группы для пользователя без групп
        User user3 = new User(3, "David");
        List<Group> user3Groups = socialNetwork.getUserGroups(user3);
        assertNotNull(user3Groups);
        assertTrue(user3Groups.isEmpty());
    }
}
