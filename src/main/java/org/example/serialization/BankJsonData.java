package org.example.serialization;

import org.example.accounts.BankAccount;
import org.example.people.Owner;

import java.util.List;
import java.util.Map;

public class BankJsonData {
    private List<Owner> owners;
    private List<BankAccount> bankAccounts;

    public List<Owner> getOwners() {
        return owners;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public BankJsonData(List<Owner> owners, List<BankAccount> bankAccounts) {
        this.owners = owners;
        this.bankAccounts = bankAccounts;
    }
}
