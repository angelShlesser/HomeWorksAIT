package de.ait.homeworks48;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private LogCaptor logCaptor;
    private User user;
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        logCaptor = LogCaptor.forClass(AuthenticationService.class);
        authenticationService = new AuthenticationService();
        user = new User("Vitali", "Trd54");
    }

    @Test
    void testAuthenticateSuccessful() {
        authenticationService.registerUser(user);

        authenticationService.authenticate("Vitali", "Trd54");

        assertTrue(logCaptor.getInfoLogs().contains("Пользователь успешно аутентифицирован: Vitali"));
        assertTrue(authenticationService.getRegisteredUsers().contains(user));
    }

    @Test
    void testAuthenticateInvalidCredentials() {
        authenticationService.authenticate("fdfd","fdfw");
        assertTrue(logCaptor.getErrorLogs().contains("Ошибка имени или пароля"));
    }

    @Test
    void testRegisterUser() {
        authenticationService.registerUser(user);

        assertTrue(logCaptor.getInfoLogs().contains("Пользователь успешно зарегистрирован: Vitali"));
        assertTrue(authenticationService.getRegisteredUsers().contains(user));
    }
}
