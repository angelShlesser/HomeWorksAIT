package de.ait.test41_5;

import java.util.Objects;

public class Post {
    /*
    Поля:
    id: int – уникальный идентификатор поста.
    content: String – текст поста.
    author: User – автор поста.
     */
    private int id;
    private String content;
    private User author;

    public Post(int id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
    /*
    equals(Object obj): переопределите, чтобы сравнивать посты по id.
    hashCode(): переопределите в соответствии с equals.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
