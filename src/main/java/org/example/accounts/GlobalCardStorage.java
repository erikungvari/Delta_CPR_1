package org.example.accounts;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class GlobalCardStorage {
    public Map<String, BankAccount> cardStorage = new HashMap<>();

    public void addCard(String bankCardNumber, BankAccount bankAccount){
        cardStorage.put(bankCardNumber, bankAccount);
    }
    public BankAccount getBankAccount(String bankCardNumber){
        return cardStorage.get(bankCardNumber);
    }
}
