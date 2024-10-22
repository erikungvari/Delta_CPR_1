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
    @Inject
    MoneyTransferService moneyTransferService;

    public void withdrawMoney(String cardNumber, double amount) throws NoMoneyOnAccountException {
        BankAccount bankAccount = cardStorage.getBankAccount(cardNumber);
        moneyTransferService.withdrawMoney(bankAccount, amount);
    }
    public void depositMoney(String cardNumber, double amount){
        BankAccount bankAccount = cardStorage.getBankAccount(cardNumber);
        moneyTransferService.depositMoney(bankAccount, amount);
    }
}
