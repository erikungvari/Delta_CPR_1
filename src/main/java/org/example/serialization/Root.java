package org.example.serialization;
import org.example.accounts.BankAccount;
import org.example.people.Owner;

import java.util.List;

public class Root {
    List<Owner> owners;
    List<BankAccount> bankAccounts;
}
