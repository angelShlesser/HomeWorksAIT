package de.ait.test41_5;

import java.util.HashSet;
import java.util.Map;
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

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.members = new HashSet<>();
    }
    //addMember(User user): добавляет участника в группу.
    public void addMember(User user) {
        if (user != null) {
            members.add(user);
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
