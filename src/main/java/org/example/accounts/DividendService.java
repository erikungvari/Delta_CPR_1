package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;

@Singleton
public class DividendService {
    @Inject
    MoneyTransferService moneyTransferService;
    @Inject
    GlobalBankAccountStorage globalBankAccountStorage;

    public void getDividends(InvestingAccount account){
        double amount = 0;
        for(Map.Entry<String, Share> entry : account.getShares().entrySet()){
            Share share = entry.getValue();
            amount += share.getBalance()/100*share.getDividend();
        }
        moneyTransferService.invest(account, amount);
    }
    public void getDividends(){
        for(BankAccount account : globalBankAccountStorage.bankAccountStorage){
            if(account instanceof InvestingAccount){
                getDividends((InvestingAccount) account);
            }
        }
    }
}
