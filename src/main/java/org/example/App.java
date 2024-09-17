package org.example;

import org.example.accounts.BankAccount;
import org.example.accounts.MoneyTransferService;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.Owner;

public class App {
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }

    void runBank() throws NoMoneyOnAccountException {
        Owner owner1 = new Owner("Karel", "Jedna");
        Owner owner2 = new Owner("Franta", "Dva");

        BankAccount account1 = new BankAccount(600, owner1, "4651976");
        BankAccount account2 = new BankAccount(1700, owner2, "9619651");

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        moneyTransferService.transferMoneyBetweenAccounts(account1, account2, 100);
    }
}