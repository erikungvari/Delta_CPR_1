package org.example.print;

import org.example.accounts.*;

import java.util.Map;

public class AccountDetailPrinter {
    public void printDetail(BankAccount bankAccount) {
        System.out.println(this.getPrefix(bankAccount) + "Bank account balance: " + bankAccount.getBalance());
    }
    private String getPrefix(BankAccount bankAccount){
        if(bankAccount instanceof StudentBankAccount){
            return "Student ";
        } else if (bankAccount instanceof SavingAccount) {
            return "Saving ";
        }
        return "";
    }
    public void printInvesting(InvestingAccount account){
        for(Map.Entry<String, Share> entry : account.getShares().entrySet()){
            Share share = entry.getValue();
            System.out.println(entry.getKey() + ": " + share.getBalance());
        }
    }
}
