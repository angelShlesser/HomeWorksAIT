package de.ait.homeworks48;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс, представляющий банковский аккаунт.
 */
public class BankAccount {
    // Поля: accountNumber (String), ownerName (String), balance (double).
    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccount.class);
    private String accountNumber;
    private String ownerName;
    private double balance;

    /**
     * Конструктор класса BankAccount.
     *
     * @param accountNumber Номер банковского счета.
     * @param ownerName     Имя владельца счета.
     * @param balance       Текущий баланс счета.
     */
    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Пополнить баланс на указанную сумму.
     *
     * @param amount Сумма для пополнения.
     */
    private void deposit(double amount) {
        balance += amount;
        LOGGER.info("Пополнение баланса на {}", amount);
    }

    /**
     * Снять указанную сумму со счета.
     *
     * @param amount Сумма для снятия.
     * @throws InsufficientFundsException Если сумма снятия больше баланса.
     */
    private void withdraw(double amount) {
        try {
            if (amount > balance) {
                throw new InsufficientFundsException("Попытка снять больше, чем на балансе!");
            }
            balance -= amount;
        } catch (InsufficientFundsException exception) {
            LOGGER.error("Текущий баланс {}. Попытка снять {}", balance, amount);
        }
    }

    /**
     * Получить текущий баланс счета.
     *
     * @return Текущий баланс.
     */
    public double getBalance() {
        LOGGER.info("Баланс {}", balance);
        return balance;
    }
}