package org.example.people;

import org.example.accounts.BankAccountNumberGenerator;

public class OwnerFactory {
    private PersonIDValidator idValidator;
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public OwnerFactory(BankAccountNumberGenerator bankAccountNumberGenerator) {
        this.idValidator = new PersonIDValidator();
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
