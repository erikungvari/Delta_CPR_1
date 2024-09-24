package org.example.print;

import org.example.accounts.BankAccount;
import org.example.accounts.SavingAccount;
import org.example.accounts.StudentBankAccount;

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

}
