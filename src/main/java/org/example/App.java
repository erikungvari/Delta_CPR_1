package org.example;

import com.google.inject.Inject;
import org.example.accounts.*;
import org.example.accounts.cards.BankCard;
import org.example.accounts.cards.BankCardFactory;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.people.Owner;
import org.example.people.OwnerFactory;
import org.example.people.PersonSerializationService;


public class App {
    public void run() throws NoMoneyOnAccountException {
        runBank();
    }

    @Inject
    private PersonSerializationService personSerializationService;

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private AtmService atmService;

    @Inject
    private BankAccountFacade bankAccountFacade;


    void runBank() throws NoMoneyOnAccountException {

        //DAOs
        Owner owner1 = ownerFactory.createOwner("Pepa", "Svacina", "485174865");
        Owner owner2 = ownerFactory.createOwner("Franta", "Nevida", "8946519846");
        BankAccount account1 = bankAccountFactory.createBankAccount(owner1, 600);
        BankAccount account2 = bankAccountFactory.createStudentBankAccount(owner2, 1700);
        BankAccount account3 = bankAccountFactory.createSavingBankAccount(owner1, 3960);

        BankAccount account4 = bankAccountFacade.createBankAccount(owner2, 670);

        if(account2 instanceof StudentBankAccount){
            String expire = ((StudentBankAccount) account2).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }
        if(account3 instanceof Interesting){
            double interest = ((Interesting)account3).GetInterest();
            System.out.println(interest);
        }

        moneyTransferService.transferMoneyBetweenAccounts(account1, account2, 100);
        moneyTransferService.depositMoney(account3, 450);

        System.out.println(personSerializationService.serializeOwner(owner1));
        System.out.println(personSerializationService.serializeOwner(owner2));

        atmService.withdrawMoney(account4.getCardNumber(account4.getCard()), 350);
    }
}