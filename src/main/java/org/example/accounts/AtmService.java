package org.example.accounts;

import com.google.inject.Singleton;
import org.example.accounts.exceptions.NoMoneyOnAccountException;

@Singleton
public class AtmService {

    public void withdrawMoney(BankAccount bankAccount, double amount) throws NoMoneyOnAccountException {
        if(bankAccount.getBalance() < amount){
            throw new NoMoneyOnAccountException("No money bro");
        }
        System.out.println("Balance before: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance()-amount);
        System.out.println("Balance after: " + bankAccount.getBalance());
    }
    public void depositMoney(BankAccount bankAccount, double amount){
        System.out.println("Balance before: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        System.out.println("Balance after: " + bankAccount.getBalance());
    }
}
