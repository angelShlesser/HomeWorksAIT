package de.ait.socialnetwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Group {
    /*
    Поля:
    id: int – уникальный идентификатор группы.
    name: String – название группы.
    members: HashSet<User> – набор участников группы.
     */
    private int id;
    private String name;
    private Set<User> members;
    private static final Logger LOGGER = LoggerFactory.getLogger(Group.class);

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.members = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getMembers() {
        Set<User> userToReturn = new HashSet<>(members);
        return userToReturn;
    }

    //addMember(User user): добавляет участника в группу.
    public boolean addMember(User user) {
        if (user == null) {
            LOGGER.error("Пользователь равен null");
            return false;
        }
        if (!members.contains(user)) {
            LOGGER.info("Новый пользователь с id {} добавлен", user.getId());
            return members.add(user);
        } else {
            LOGGER.error("Пользователь с id {} уже существует", user.getId());
            return false;
        }

    }
    //equals(Object obj): переопределите, чтобы сравнивать группы по id.
    //hashCode(): переопределите в соответствии с equals.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean hasMember(User user) {
        return members.contains(user);
    }
}
