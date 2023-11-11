package de.ait.homeworks46;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class UserRegistration {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistration.class);

    public static void main(String[] args) {
        boolean isRegistrationSuccessful = false;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите имя пользователя или 'exit' для выхода:");
            String username = scanner.nextLine();

            if (!username.equals("exit")) {
                isRegistrationSuccessful = registerUser(username, scanner);
            }

        } catch (Exception e) {
            LOGGER.error("Произошла ошибка", e);
        }

        if (isRegistrationSuccessful) {
            System.out.println("Учётная запись успешно создана.");
        }
    }

    private static boolean registerUser(String username, Scanner scanner) {
        try {
            if (username.isEmpty()) {
                throw new IllegalArgumentException("Имя пользователя не может быть пустым.");
            }

            System.out.println("Введите пароль:");
            String password = scanner.nextLine();
            validatePassword(password);

            LOGGER.info("Успешная регистрация пользователя: {}", username);
            return true;

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
            LOGGER.error("Ошибка при регистрации пользователя: {}", username, e);
            return false;
        }
    }

    private static void validatePassword(String password) {
        if (password.length() < 8 || !containsCharacterCategory(password)) {
            throw new IllegalArgumentException("Пароль должен быть не менее 8 символов и содержать хотя бы " +
                    "по одному символу из каждой категории: верхний регистр, нижний регистр, цифры и специальные символы.");
        }
    }

    private static boolean containsCharacterCategory(String str) {
        return str.matches(".*[A-Z].*") && // хотя бы один символ в верхнем регистре
                str.matches(".*[a-z].*") && // хотя бы один символ в нижнем регистре
                str.matches(".*\\d.*") &&   // хотя бы одна цифра
                str.matches(".*[@!#].*");   // хотя бы один специальный символ
    }
}