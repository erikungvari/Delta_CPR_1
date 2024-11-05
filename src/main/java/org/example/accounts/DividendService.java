package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;

@Singleton
public class DividendService {
    @Inject
    MoneyTransferService moneyTransferService;

    public void getDividends(InvestingAccount account){
        double amount = 0;
        for(Map.Entry<String, Share> entry : account.getShares().entrySet()){
            Share share = entry.getValue();
            amount += share.getBalance()/100*share.getDividend();
        }
        moneyTransferService.invest(account, amount);
    }
}
