package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.cards.BankCard;
import org.example.accounts.cards.BankCardFactory;
import org.example.accounts.cards.BankCardNumberGenerator;
import org.example.accounts.cards.BankCardPINGenerator;
import org.example.people.Owner;

@Singleton
public class BankAccountFacade {
    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private GlobalCardStorage globalCardStorage;

    public BankAccount createBankAccount(Owner owner, double balance){
        BankAccount account = bankAccountFactory.createBankAccount(owner, balance);
        BankCard card = bankCardFactory.createBankCard();
        account.addCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getBankCardNumber(), account);
        return account;
    }
    public StudentBankAccount createStudentBankAccount(Owner owner, double balance){
        StudentBankAccount account = bankAccountFactory.createStudentBankAccount(owner, balance);
        BankCard card = bankCardFactory.createBankCard();
        account.addCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getBankCardNumber(), account);
        return account;
    }
    public SavingAccount createSavingBankAccount(Owner owner, double balance){
        SavingAccount account = bankAccountFactory.createSavingBankAccount(owner, balance);
        BankCard card = bankCardFactory.createBankCard();
        account.addCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getBankCardNumber(), account);
        return account;
    }
    public InvestingAccount createInvestingBankAccount(Owner owner, double balance){
        InvestingAccount account = bankAccountFactory.createInvestingAccount(owner, balance);
        BankCard card = bankCardFactory.createBankCard();
        account.addCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getBankCardNumber(), account);
        return account;
    }
    public BankCard createBankCard(BankAccount bankAccount){
        BankCard bankCard = bankCardFactory.createBankCard();
        globalCardStorage.addCard(bankCard.getBankCardNumber(),bankAccount);
        return bankCard;
    }
}
