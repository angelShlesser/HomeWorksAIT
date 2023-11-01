package de.ait.homeworks43;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляров BankAccount
        BankAccount account1 = new BankAccount("User1", 1000.0);
        BankAccount account2 = new BankAccount("User2", 100.0);

        // Проведение операций
        account1.deposit(200.0);
        account2.withdraw(300.0);
        account1.checkBalance();
        account2.checkBalance();

    }
}
