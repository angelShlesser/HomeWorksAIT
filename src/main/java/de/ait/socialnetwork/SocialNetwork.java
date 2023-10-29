package de.ait.socialnetwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetwork {
    /*
    Поля:
    users: HashMap<Integer, User> – соответствие между идентификатором и
    пользователем.
    groups: HashMap<Integer, Group> – соответствие между идентификатором и
    группой.
    posts: ArrayList<Post> – список всех постов.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SocialNetwork.class);
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Group> groups = new HashMap<>();
    private List<Post> posts = new ArrayList<>();
    private int nextPostId = 1;

    //registerUser(int id, String name): регистрирует нового пользователя,
    //добавляет пользователя в users и возвращает созданного пользователя.
    public User registerUser(int id, String name) {
        //name null
        if (name == null) {
            LOGGER.error("Имя {} не доcтупно", name);
            return null;
        }
        //проверка уникального пользователя
        for (Map.Entry<Integer, User> user : users.entrySet()) {
            if (user.getKey().equals(Integer.valueOf(id))) {
                LOGGER.error("Пользователь с id {} уже есть", id);
                return null;
            }
        }
        User user = new User(id, name);
        LOGGER.info("Зарегистрирован пользователь с именем {} и id {}", name, id);
        return users.put(id, user);
    }

    //createGroup(int id, String name): создает новую группу, добавляет группу в
    //groups и возвращает созданную группу.
    public Group createGroup(int id, String name) {
        //Проверим на null
        if (name == null) {
            LOGGER.error("Не допустимое название группы {}", name);
            return null;
        }
        //проверим нет ли уже с таким id группы
        for (Map.Entry<Integer, Group> group : groups.entrySet()) {
            if (group.getKey().equals(Integer.valueOf(id))) {
                LOGGER.error("Группа с таким id {} уже есть", id);
                return null;
            }
        }
        Group newGroup = new Group(id, name);
        LOGGER.info("Зарегистрирована группа с именем {} и id {}", name, id);
        return groups.put(id, newGroup);
    }

    //createPost(User author, String content): создает новый пост от имени
    //пользователя и добавляет его в posts.
    public Post createPost(User author, String content) {
        //Проверим на null
        if (author == null || content == null) {
            LOGGER.error("Недопустимое значение автора или содержания поста.");
            return null;
        }
        Post postResult = new Post(generateUniquePostId(), content, author);
        posts.add(postResult);
        LOGGER.info("Пост создан {}", postResult.getId());
        return postResult;
    }

    //для генерации постов id
    private int generateUniquePostId() {
        return nextPostId++;
    }

    public List<User> getFriends(User user) {
        if (!user.getFriends().isEmpty()) {
            List<User> friendsList = new ArrayList<>();
            friendsList.addAll(user.getFriends());
            LOGGER.info("Список друзей:");
            return friendsList;

        }
        LOGGER.info("Список друзей c id {} пуст", user.getId());
        return null;
    }

    public List<Group> getUserGroups(User user) {
        List<Group> userGroups = new ArrayList<>();
        for (Group group : groups.values()) {
            if (group.hasMember(user)) {
                userGroups.add(group);
            }
        }
        return userGroups;
    }
}
