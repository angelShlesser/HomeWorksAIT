package de.ait.homeworks48;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс, представляющий пользователя с учетными данными.
 */
public class User {
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    // Поля: username (String), password (String).
    private String username;
    private String password;

    /**
     * Конструктор класса User.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Получить имя пользователя.
     *
     * @return Имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Получить пароль пользователя.
     *
     * @return Пароль пользователя.
     */
    public String getPassword() {
        return password;
    }
}