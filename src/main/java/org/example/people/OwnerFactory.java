package org.example.people;

import org.example.accounts.AccountNumberGenerator;
import org.example.accounts.BankAccountNumberGenerator;

public class OwnerFactory {
    private PersonIDValidator idValidator;
    private AccountNumberGenerator bankAccountNumberGenerator;

    public OwnerFactory(AccountNumberGenerator bankAccountNumberGenerator, PersonIDValidator personIDValidator) {
        this.idValidator = personIDValidator;
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    public Owner createOwner(String name, String lastname, String personID){
        if(!this.idValidator.isPersonIdValid(personID)){
            System.out.println("Invalid person: " + personID);
        }
        System.out.println("Number like: " + bankAccountNumberGenerator.generateBankAccountNumber());
        return new Owner(name, lastname, personID);
    }
}
