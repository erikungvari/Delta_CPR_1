package org.example.accounts;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.example.people.Owner;

@Singleton
public class BankAccountFactory {

    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;
    private BankAccountNumberValidator accValidator;


    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();
        return new BankAccount(balance, owner, bankAccountNumber);
    }
    public StudentBankAccount createStudentBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new StudentBankAccount(balance, owner, bankAccountNumber);
    }
    public StudentBankAccount createStudentBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();
        return new StudentBankAccount(balance, owner, bankAccountNumber);
    }
    public SavingAccount createSavingBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new SavingAccount(balance, owner, bankAccountNumber);
    }
    public SavingAccount createSavingBankAccount(double balance, Owner owner){
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();
        return new SavingAccount(balance, owner, bankAccountNumber);
    }
}
