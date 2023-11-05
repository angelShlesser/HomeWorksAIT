package de.ait.homeworks43;

import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    LogCaptor logCaptor = LogCaptor.forClass(BankAccount.class);
    private BankAccount bankAccountAlex;
    private BankAccount bankAccountLiza;


    @BeforeEach
    void setUp() {
        bankAccountAlex = new BankAccount("Lio", 400.0);
        bankAccountLiza = new BankAccount("Liza", 3000.0);
    }

    @Test
    void testGetOwner() {
        assertEquals("Lio", bankAccountAlex.getOwner());
    }

    @Test
    void testGetBalance() {
        assertEquals(3000.0, bankAccountLiza.getBalance());
    }

    @Test
    void setBalance() {
        logCaptor.setLogLevelToInfo();
        bankAccountLiza.setBalance(500.0);
        assertEquals(500.0, bankAccountLiza.getBalance());
        String resultMassage = "Баланс 500.0";
        assertTrue(logCaptor.getInfoLogs().contains(resultMassage));
            }

    @Test
    void deposit() {
        logCaptor.setLogLevelToInfo();
        assertTrue(bankAccountAlex.deposit(500));
        String result = "Пополнение баланса у владельца Lio, на 500.0. Всего на счету 900.0.";
        assertTrue(logCaptor.getInfoLogs().contains(result));
        bankAccountLiza.setBalance(-100);
        result = "Ошибка пополнения баланса.";
        assertFalse(bankAccountLiza.deposit(10));
        assertFalse(logCaptor.getInfoLogs().contains(result));
    }

    @Test
    void withdraw() {
        assertTrue(bankAccountAlex.withdraw(100));
        assertFalse(bankAccountLiza.withdraw(6000));
    }

    @Test
    void checkBalance() {
        double balance = bankAccountLiza.checkBalance();
        assertEquals(3000.0, balance);
    }
}