package org.example;

import org.example.accounts.*;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.Owner;
import org.example.people.OwnerFactory;
import org.example.accounts.BankAccountFactory;

public class App {
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }

    void runBank() throws NoMoneyOnAccountException {
        OwnerFactory ownerFactory = new OwnerFactory();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        Owner owner1 = ownerFactory.createOwner("Pepa", "Svacina", "485174865");
        Owner owner2 = ownerFactory.createOwner("Franta", "Nevida", "8946519846");

        BankAccount account1 = bankAccountFactory.createBankAccount(600, owner1);
        BankAccount account2 = bankAccountFactory.createStudentBankAccount(1700, owner2);
        BankAccount account3 = bankAccountFactory.createSavingBankAccount(500, owner1);


        if(account2 instanceof StudentBankAccount){
            String expire = ((StudentBankAccount) account2).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }
        if(account3 instanceof Interesting){
            double interest = ((Interesting)account3).GetInterest();
            System.out.println(interest);
        }

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        moneyTransferService.transferMoneyBetweenAccounts(account1, account2, 100);


    }
}