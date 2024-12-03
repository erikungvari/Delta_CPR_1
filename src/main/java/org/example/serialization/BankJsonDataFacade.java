package org.example.serialization;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.people.Owner;
import org.example.storage.GlobalBankAccountStorage;
import org.example.storage.GlobalOwnerStorage;

import java.io.FileNotFoundException;
import java.util.List;

@Singleton
public class BankJsonDataFacade {
    @Inject
    private BankJsonDataFactory bankJsonDataFactory;
    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;
    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    public BankJsonData createBankJsonDataFromGlobalStorages(){
        List<Owner> owners = globalOwnerStorage.getOwnerStorage();
        List<BankAccount> bankAccounts = globalBankAccountStorage.getBankAccountStorage();
        BankJsonData bankJsonData = bankJsonDataFactory.createBankJsonData(owners, bankAccounts);
        return bankJsonData;
    }

    public void createBankJsonDataFromJsonData(BankJsonData bankJsonData) throws FileNotFoundException {

    }
}
