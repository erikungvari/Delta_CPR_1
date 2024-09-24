package org.example.accounts;

import org.example.people.Owner;

public class SavingAccount extends BankAccount implements Interesting{

    public SavingAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
    }

    public double GetInterest(){
        if(this.getBalance() <500000){
            return 4;
        }
        return 1;
    }

}
