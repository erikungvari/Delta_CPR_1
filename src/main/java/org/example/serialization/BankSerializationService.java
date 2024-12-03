package org.example.serialization;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.inject.Inject;
import org.example.accounts.BankAccount;
import org.example.people.Owner;
import org.example.storage.FileSystemStorage;
import org.example.storage.GlobalBankAccountStorage;
import org.example.storage.GlobalOwnerStorage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


public class BankSerializationService {
    @Inject
    private BankJsonDataFacade bankJsonDataFacade;

    @Inject
    private BankJsonDataSerializationService bankJsonDataSerializationService;

    @Inject
    private FileSystemStorage fileSystemStorage;

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    public static final String filePath = "bank.json";

    public String serialize() {
        BankJsonData data = bankJsonDataFacade.createBankJsonDataFromGlobalStorages();

        return bankJsonDataSerializationService.serializeBank(data);
    }

    public void serializeAndWriteToFile() {
        String data = serialize();

        fileSystemStorage.write(filePath, data);
    }
    public void loadDataFromFile(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filePath));

        Root root = gson.fromJson(reader, Root.class);
        List<Owner> owners = root.owners;
        List<BankAccount> bankAccounts = root.bankAccounts;

        for(Owner owner : owners){
            this.globalOwnerStorage.addOwner(owner);
        }
        for(BankAccount bankAccount : bankAccounts){
            this.globalBankAccountStorage.addBankAccount(bankAccount);
        }
    }
}
