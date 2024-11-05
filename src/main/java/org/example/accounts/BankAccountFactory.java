package org.example.accounts;

import com.google.inject.Singleton;
import com.google.inject.Inject;
import org.example.accounts.cards.BankCardFactory;
import org.example.people.Owner;

import java.util.Map;

@Singleton
public class BankAccountFactory {

    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;
    @Inject
    private BankAccountNumberValidator accValidator;
    @Inject
    private BankCardFactory bankCardFactory;


    public BankAccount createBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createBankAccount(Owner owner, double balance){
        return new BankAccount(balance, owner, this.bankAccountNumberGenerator.generateBankAccountNumber());
    }

    public StudentBankAccount createStudentBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new StudentBankAccount(balance, owner, bankAccountNumber);
    }
    public StudentBankAccount createStudentBankAccount(Owner owner, double balance){
        return new StudentBankAccount(balance, owner, this.bankAccountNumberGenerator.generateBankAccountNumber());
    }
    public SavingAccount createSavingBankAccount(double balance, Owner owner, String bankAccountNumber){
        if(!this.accValidator.isAccountValid(bankAccountNumber)){
            System.out.println("Invalid account: " + bankAccountNumber);
        }
        return new SavingAccount(balance, owner, bankAccountNumber);
    }
    public SavingAccount createSavingBankAccount(Owner owner, double balance){
        return new SavingAccount(balance, owner, this.bankAccountNumberGenerator.generateBankAccountNumber());
    }
    public InvestingAccount createInvestingAccount(Owner owner, double balance, Map<String, Share> shares){
        return new InvestingAccount(balance, owner, shares, this.bankAccountNumberGenerator.generateBankAccountNumber());
    }
}
