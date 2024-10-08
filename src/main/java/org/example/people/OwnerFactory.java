package org.example.people;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.AccountNumberGenerator;
import org.example.accounts.BankAccountNumberGenerator;

@Singleton
public class OwnerFactory {
    @Inject
    private PersonIDValidator idValidator;
    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;

    public Owner createOwner(String name, String lastname, String personID){
        if(!this.idValidator.isPersonIdValid(personID)){
            System.out.println("Invalid person: " + personID);
        }
        System.out.println("Number like: " + bankAccountNumberGenerator.generateBankAccountNumber());
        return new Owner(name, lastname, personID);
    }
}
