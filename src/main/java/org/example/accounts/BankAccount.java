package org.example.accounts;

import org.example.accounts.cards.BankCard;
import org.example.people.Owner;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private double balance;

    private Owner owner;

    private String accountNumber;

    private Map<String, BankCard> cards = new HashMap<>();

    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankCard getCard(String bankCardNumber){
        return cards.get(bankCardNumber);
    }


    public void addCard(BankCard bankCard){
        cards.put(bankCard.getBankCardNumber(), bankCard);
    }


}