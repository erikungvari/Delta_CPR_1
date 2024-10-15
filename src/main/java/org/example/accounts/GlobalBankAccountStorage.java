package org.example.accounts;

import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GlobalBankAccountStorage {
    public List<BankAccount> bankAccountStorage = new ArrayList<>();

    public void addBankAccount(BankAccount bankAccount){
        bankAccountStorage.add(bankAccount);
    }
}
