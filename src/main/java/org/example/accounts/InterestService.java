package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class InterestService {
    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private MoneyTransferService moneyTransferService;


    public void interestAllAccounts(){
        for(BankAccount bankAccount : globalBankAccountStorage.bankAccountStorage){
            double interestAmount = bankAccount.getInterest();
            moneyTransferService.depositMoney(bankAccount, interestAmount);
        }
    }
    public void interestSavingAccounts(){
        for(BankAccount bankAccount : globalBankAccountStorage.bankAccountStorage){
            if(bankAccount instanceof SavingAccount){
                double interestAmount = bankAccount.getInterest();
                moneyTransferService.depositMoney(bankAccount, interestAmount);
            }
        }
    }
}
