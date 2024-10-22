package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class InterestService {
    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private InterestCalculator interestCalculator;

    public void interestAllAccounts(){
        for(BankAccount bankAccount : globalBankAccountStorage.bankAccountStorage){
            double interestAmount = interestCalculator.getInterest(bankAccount);
            moneyTransferService.depositMoney(bankAccount, interestAmount);
        }
    }
    public void interestSavingAccounts(){
        for(BankAccount bankAccount : globalBankAccountStorage.bankAccountStorage){
            if(!(bankAccount instanceof Interesting)){
                continue;
            }
            double interestAmount = interestCalculator.getInterest(bankAccount);
            moneyTransferService.depositMoney(bankAccount, interestAmount);
        }
    }
}
