package org.example.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.print.AccountDetailPrinter;

import java.util.Map;

@Singleton
public class MoneyTransferService {

    @Inject
    private TransferFeeCalculator transferFeeCalculator;
    @Inject
    private AccountDetailPrinter accountDetailPrinter;

    public void depositMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        accountDetailPrinter.printDetail(bankAccount);
        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void withdrawMoney(BankAccount bankAccount, double amount) throws NoMoneyOnAccountException {
        double balance = bankAccount.getBalance();
        if(balance < amount){
            throw new NoMoneyOnAccountException("No money bro");
        }
        double newBalance = balance - amount;

        accountDetailPrinter.printDetail(bankAccount);
        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }
    public void transferMoneyBetweenAccounts(BankAccount from, BankAccount to, double amount) throws NoMoneyOnAccountException {
        if(from.getBalance() < amount){
            throw new NoMoneyOnAccountException("No money bro");
        }

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);

        double sourceBalance = from.getBalance();
        double newSourceBalance = sourceBalance - amount;
        from.setBalance(newSourceBalance);

        if(to instanceof InvestingAccount){
            invest((InvestingAccount) to, amount);
        }
        else{
            double destinationBalance = to.getBalance();
            double newDestinationBalance = destinationBalance + amount;
            to.setBalance(newDestinationBalance);
        }

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);
    }
    public void invest(InvestingAccount account, double amount) {
        for(Map.Entry<String, Share> entry : account.getShares().entrySet()){
            Share share = entry.getValue();
            share.setBalance(share.getBalance()+ (amount/100*share.getPart()));
        }
        this.accountDetailPrinter.printInvesting(account);

    }
}