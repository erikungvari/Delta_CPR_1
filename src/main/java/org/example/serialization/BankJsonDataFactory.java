package org.example.serialization;

import com.google.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.people.Owner;

import java.util.List;

@Singleton
public class BankJsonDataFactory {

    public BankJsonData createBankJsonData(List<Owner> owners, List<BankAccount> bankAccounts){
        return new BankJsonData(owners, bankAccounts);
    }
}
