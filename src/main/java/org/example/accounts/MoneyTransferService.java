package org.example.accounts;

import org.example.accounts.exceptions.NoMoneyOnAccountException;
import org.example.print.AccountDetailPrinter;

public class MoneyTransferService {

    public TransferFeeCalculator transferFeeCalculator;
    public AccountDetailPrinter accountDetailPrinter;

    public MoneyTransferService(TransferFeeCalculator transferFeeCalculator, AccountDetailPrinter accountDetailPrinter) {
        this.transferFeeCalculator = transferFeeCalculator;
        this.accountDetailPrinter = accountDetailPrinter;
    }


    public void depositMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance + amount;

        newBalance -= this.transferFeeCalculator.calculateTransferFee(amount);

        bankAccount.setBalance(newBalance);
        accountDetailPrinter.printDetail(bankAccount);
    }

    public void withdrawMoney(BankAccount bankAccount, double amount) {
        double balance = bankAccount.getBalance();
        double newBalance = balance - amount;

        newBalance += this.transferFeeCalculator.calculateTransferFee(amount);

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
        double destinationBalance = to.getBalance();
        double newDestinationBalance = destinationBalance + amount;
        to.setBalance(newDestinationBalance);

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);
    }
}