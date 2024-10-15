package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.cards.BankCard;
import org.example.accounts.cards.BankCardFactory;
import org.example.people.Owner;

@Singleton
public class BankAccountFacade {
    @Inject
    BankAccountFactory bankAccountFactory;

    @Inject
    BankCardFactory bankCardFactory;

    @Inject
    GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    GlobalCardStorage globalCardStorage;

    public BankAccount createBankAccount(Owner owner, double balance){
        BankAccount account = bankAccountFactory.createBankAccount(owner, balance);
        BankCard card = bankCardFactory.createBankCard();
        account.addCard(card);
        globalBankAccountStorage.addBankAccount(account);
        globalCardStorage.addCard(card.getBankCardNumber(), account);
        return account;
    }
}
