package org.example.accounts;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.exceptions.NoMoneyOnAccountException;

@Singleton
public class AtmService {
    @Inject
    GlobalCardStorage cardStorage;
    @Inject
    GlobalBankAccountStorage bankAccountStorage;

    public void withdrawMoney(String cardNumber, double amount) throws NoMoneyOnAccountException {
        BankAccount bankAccount = cardStorage.getBankAccount(cardNumber);
        System.out.println("Balance before: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance()-amount);
        System.out.println("Balance After: " + bankAccount.getBalance());
    }
    public void depositMoney(String cardNumber, double amount){
        BankAccount bankAccount = cardStorage.getBankAccount(cardNumber);
        System.out.println("Balance before: " + bankAccount.getBalance());
        bankAccount.setBalance(bankAccount.getBalance()+amount);
        System.out.println("Balance After: " + bankAccount.getBalance());
    }
}
