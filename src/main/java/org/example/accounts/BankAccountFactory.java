package org.example.accounts;

import org.example.people.Owner;


public class BankAccountFactory {
    private BankAccountNumberValidator accValidator;
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankAccountFactory() {
        this.accValidator = new BankAccountNumberValidator();
        this.bankAccountNumberGenerator = new BankAccountNumberGenerator();
    }

    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.GenerateBankAccountNumber();
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.GenerateBankAccountNumber();
        return new StudentBankAccount(balance, owner, bankAccountNumber);
    }

    public SavingAccount createSavingBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.GenerateBankAccountNumber();
        return new SavingAccount(balance, owner, bankAccountNumber);
    }
}
