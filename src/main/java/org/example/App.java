package org.example;

import org.example.accounts.*;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.Owner;
import org.example.people.OwnerFactory;
import org.example.accounts.BankAccountFactory;
import org.example.accounts.BankAccountNumberGenerator;
import org.example.people.PersonIDValidator;
import org.example.print.AccountDetailPrinter;

public class App {
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }

    void runBank() throws NoMoneyOnAccountException {
        //services
        DIContainer serviceContainer = new DIContainer();

        //DAOs
        Owner owner1 = serviceContainer.getOwnerFactory().createOwner("Pepa", "Svacina", "485174865");
        Owner owner2 = serviceContainer.getOwnerFactory().createOwner("Franta", "Nevida", "8946519846");
        BankAccount account1 = serviceContainer.getBankAccountFactory().createBankAccount(600, owner1);
        BankAccount account2 = serviceContainer.getBankAccountFactory().createStudentBankAccount(1700, owner2);
        BankAccount account3 = serviceContainer.getBankAccountFactory().createSavingBankAccount(500, owner1);


        if(account2 instanceof StudentBankAccount){
            String expire = ((StudentBankAccount) account2).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }
        if(account3 instanceof Interesting){
            double interest = ((Interesting)account3).GetInterest();
            System.out.println(interest);
        }

        serviceContainer.getMoneyTransferService().transferMoneyBetweenAccounts(account1, account2, 100);
        serviceContainer.getMoneyTransferService().depositMoney(account3, 450);

    }
}