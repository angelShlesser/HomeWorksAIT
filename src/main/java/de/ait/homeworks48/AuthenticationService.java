package de.ait.homeworks48;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Сервис аутентификации пользователей.
 */
public class AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);
    private List<User> registeredUsers = new ArrayList<>();

    /**
     * Проверить, соответствуют ли предоставленные учетные данные зарегистрированному пользователю.
     *
     * @param username Имя пользователя.
     * @param password Пароль пользователя.
     * @throws AuthenticationException Выбрасывается, если учетные данные неверны.
     */
    public void authenticate(String username, String password) throws AuthenticationException {
        User authenticatedUser = null;
        try {
            for (User user : registeredUsers) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    authenticatedUser = user;
                    break;
                }
            }
            if (authenticatedUser == null) {
                throw new AuthenticationException("Invalid username or password.");
            } else {
                LOGGER.info("Пользователь успешно аутентифицирован: {}", username);
            }
        } catch (AuthenticationException exception) {
            LOGGER.error("Ошибка имени или пароля", exception);
        }
    }

    /*
     * Зарегистрировать нового пользователя.
     *
     * @param user Пользователь для регистрации.
     */
    public void registerUser(User user) {
        registeredUsers.add(user);
        LOGGER.info("Пользователь успешно зарегистрирован: {}", user.getUsername());
    }
}