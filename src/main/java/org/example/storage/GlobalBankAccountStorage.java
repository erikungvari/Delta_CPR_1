package org.example.storage;

import com.google.inject.Singleton;
import org.example.accounts.BankAccount;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class GlobalBankAccountStorage {
    public List<BankAccount> bankAccountStorage = new ArrayList<>();

    public List<BankAccount> getBankAccountStorage() {
        return bankAccountStorage;
    }

    public void addBankAccount(BankAccount bankAccount){
        bankAccountStorage.add(bankAccount);
    }

}
