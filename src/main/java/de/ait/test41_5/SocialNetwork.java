package de.ait.test41_5;

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
    private Map<Integer, User> users =new HashMap<>();
    private Map<Integer, Group> groups =new HashMap<>();
    private List<Post> posts = new ArrayList<>();
    private int nextPostId = 1;
    //registerUser(int id, String name): регистрирует нового пользователя,
    //добавляет пользователя в users и возвращает созданного пользователя.
    public User registerUser(int id, String name){
        User userNew = new User(id,name);
        users.put(id,userNew);
        return userNew;
    }
    //createGroup(int id, String name): создает новую группу, добавляет группу в
    //groups и возвращает созданную группу.
    public Group createGroup(int id, String name) {
        Group newGroup = new Group(id, name);
        groups.put(id, newGroup);
        return newGroup;
    }
    //createPost(User author, String content): создает новый пост от имени
    //пользователя и добавляет его в posts.
    public Post createPost(User author, String content) {
        int idGenerating = generateUniquePostId();
        Post newPost = new Post(idGenerating,content,author);
        posts.add(newPost);
        return newPost;
    }
    //для генерации постов id
    private int generateUniquePostId(){
    return nextPostId++;
    }
    public List<User> getFriends(User user) {
        List<User> friendsList = new ArrayList<>();
        if (!user.getFriends().isEmpty()) {
            friendsList.addAll(user.getFriends());
        } else {
            System.out.println("Список пуст");
        }
        return friendsList;
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
