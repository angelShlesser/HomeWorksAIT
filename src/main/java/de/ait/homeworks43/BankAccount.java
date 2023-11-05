package de.ait.homeworks43;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BankAccount {
    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccount.class);
    private String owner; //владелец аккаунта
    private double balance; //текущий баланс

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        LOGGER.info("Баланс {}", balance);
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
    Добавьте метод deposit(double amount):

    Увеличьте balance на значение amount.
    Логируйте операцию на уровне INFO, указывая владельца аккаунта и сумму пополнения.
     */
    public boolean deposit(double amount) {
        if (balance > 0) {
            balance += amount;
            LOGGER.info("Пополнение баланса у владельца {}, на {}. Всего на счету {}.", owner, amount, balance);
            return true;
        } else {
            LOGGER.error("Ошибка пополнения баланса.");
            return false;
        }
    }

    /*
    Добавьте метод withdraw(double amount):
    Проверьте, достаточно ли средств на аккаунте. Если не достаточно, залогируйте это как ERROR, указывая владельца аккаунта и требуемую сумму.
    Если средств достаточно, уменьшите balance на amount и логируйте операцию на уровне INFO.
    */
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            LOGGER.info("Снятие средств с аккаунта для {} на сумму: {}", owner, amount);
            return true;
        } else {
            LOGGER.error("Ошибка: Недостаточно средств на аккаунте {} для снятия суммы: {}", owner, amount);
            return false;
        }
    }

    public double checkBalance() {
        LOGGER.warn("Запрос баланса для аккаунта {}", owner);
        return balance;
    }
}