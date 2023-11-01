package de.ait.homeworks43;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
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
        bankAccountLiza.setBalance(500.0);
        assertEquals(500.0, bankAccountLiza.getBalance());
    }

    @Test
    void deposit() {
        assertTrue(bankAccountAlex.deposit(500));
        bankAccountLiza.setBalance(-100);
        assertFalse(bankAccountLiza.deposit(10));
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