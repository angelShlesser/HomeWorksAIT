package de.ait.homeworks48;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    LogCaptor logCaptor = LogCaptor.forClass(BankAccount.class);
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("1uF4", "Sergei", 33.0);
    }

    @Test
    void testDepositLogs() {
        logCaptor.setLogLevelToInfo();
        double initialBalance = account.getBalance();
        account.deposit(100);

        assertTrue(logCaptor.getInfoLogs().contains("Пополнение баланса на 100.0"));
        assertEquals(initialBalance + 100, account.getBalance());
    }

    @Test
    void testWithdrawLogs() {
        logCaptor.setLogLevelToInfo();
        double initialBalance = account.getBalance();

        account.withdraw(10);
        assertTrue(logCaptor.getInfoLogs().contains("Остаток баланса " + (initialBalance - 10)));

        account.withdraw(100);
        assertFalse(logCaptor.getInfoLogs().contains("Текущий баланс " + initialBalance + ". Попытка снять 100.0"));
    }

    @Test
    void testGetBalance() {
        double balance = account.getBalance();
        assertEquals(33.0, balance);
    }
}
