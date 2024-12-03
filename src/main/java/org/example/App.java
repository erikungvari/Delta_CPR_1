package org.example;

import com.google.inject.Inject;
import org.example.accounts.*;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.Owner;
import org.example.people.OwnerFacade;
import org.example.people.OwnerFactory;
import org.example.people.PersonSerializationService;
import org.example.serialization.BankJsonDataFacade;
import org.example.serialization.BankSerializationService;
import org.example.storage.GlobalOwnerStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public void run() throws NoMoneyOnAccountException, IOException {
        runBank();
    }

    @Inject
    private PersonSerializationService personSerializationService;

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private OwnerFacade ownerFacade;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private AtmService atmService;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private InterestService interestService;

    @Inject
    private DividendService dividendService;

    @Inject
    private BankSerializationService bankSerializationService;

    @Inject
    private BankJsonDataFacade bankJsonDataFacade;

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    void runBank() throws NoMoneyOnAccountException, FileNotFoundException, IOException {

        File file = new File("C:\\Programming\\CPR\\01_Lecture\\bank.json");
        if(!file.exists()){
            //DAOs
            Owner owner1 = ownerFacade.createOwner("Pepa", "Svacina", "485174865");
            Owner owner2 = ownerFacade.createOwner("Franta", "Nevida", "8946519846");
            BankAccount account1 = bankAccountFacade.createBankAccount(owner1, 600);
            BankAccount account2 = bankAccountFacade.createStudentBankAccount(owner2, 1700);
            BankAccount account3 = bankAccountFacade.createSavingBankAccount(owner1, 3960);

            BankAccount account4 = bankAccountFacade.createBankAccount(owner2, 670);
            BankAccount account5 = bankAccountFacade.createInvestingBankAccount(owner1, 0);

            account4.addCard(bankAccountFacade.createBankCard(account4));
            moneyTransferService.transferMoneyBetweenAccounts(account1, account2, 100);
            moneyTransferService.depositMoney(account3, 450);

            System.out.println(personSerializationService.serializeOwner(owner1));
            System.out.println(personSerializationService.serializeOwner(owner2));

            atmService.withdrawMoney(account4.getLastCard().getBankCardNumber(), 350);

            System.out.println("Interesting: ");
            interestService.interestAllAccounts();

            System.out.println("Investing: ");
            moneyTransferService.invest((InvestingAccount) account5, 2000);
            dividendService.getDividends((InvestingAccount) account5);

            bankSerializationService.serializeAndWriteToFile();
        }
        else{
            bankSerializationService.loadDataFromFile(file.getPath());
            System.out.println("Interesting: ");
            for(Owner owner : globalOwnerStorage.getOwnerStorage()){
                System.out.println(personSerializationService.serializeOwner(owner));
            }
            interestService.interestAllAccounts();


            bankSerializationService.serializeAndWriteToFile();
        }




    }
}