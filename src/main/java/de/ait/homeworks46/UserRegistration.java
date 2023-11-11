package de.ait.homeworks46;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class UserRegistration {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistration.class);

    public static void main(String[] args) {

        boolean validateResult = false;

        System.out.println("Введите имя пользователя или 'exit' для выхода:");

        Scanner scanner = new Scanner(System.in);
        String username = null;
        boolean usernameValide = false;
        while (!validateResult) {
            try {
                if (!usernameValide) {
                    username = scanner.nextLine();
                    username.charAt(0);
                    System.out.println("Username: " + username);
                    usernameValide = true;
                    if (username.equals("exit")) {
                        break;
                    }
                }
                System.out.println("Введите пароль: ");
                String password = scanner.next();
                boolean result = validatePassword(password);
                // boolean result = isPasswordValid(password);
                if (result) {
                    System.out.println("Учётная запись успешно создана.");
                    LOGGER.info("User account was created {}", username);
                    validateResult = result;
                } else {
                    System.out.println("Введите пароль: ");
                    password = scanner.next();
                    validateResult = validatePassword(password);
                    if (validateResult) {
                        System.out.println("Учётная запись успешно создана.");
                        LOGGER.info("User account was created {}", username);

                    }
                }
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Имя пользователя не может быть пустым ");
                LOGGER.error("Username ist empty", exception);
                System.out.println("Введите имя пользователя или 'exit' для выхода:");
            }

        }
        scanner.close();
    }

    private static boolean validatePassword(String password) {
        // !password.matches("\\") ведет к PatternSyntaxException

        try {
            if (password.length() < 8 || !(password.contains("@")
                    || password.contains("!") || password.contains("#"))
                    || !password.matches(".*\\d.*")) {
                throw new WrongArgumentsException("Password length must be 8 symbols and include" +
                        " one number and include one special character ");
            } else {
                return true;
            }
        } catch (WrongArgumentsException | PatternSyntaxException exception) {
            LOGGER.error("Password is wrong:  {}", password, exception);
            System.out.println("Ошибка: Пароль должен быть не менее 8 символов и " +
                    "содержать хотя бы одну цифру и один специальный символ.");
            return false;
        }

    }

    public static boolean isPasswordValid(String password) {
        try {
            System.out.println("Вы зашли");
            if (password.length() < 8) {
                throw new ArithmeticException("Вы ушли");
            }
            boolean res = (password.contains("@") || password.contains("!") || password.contains("#"));
            System.out.println(res);
            return res;
        } catch (ArithmeticException exception) {
            LOGGER.info("Неверный пароль, повторите попытку");
            return false;
        }
    }

}

