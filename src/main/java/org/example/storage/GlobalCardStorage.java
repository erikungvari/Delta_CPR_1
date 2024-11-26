package org.example.storage;

import com.google.inject.Singleton;
import org.example.accounts.BankAccount;

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
