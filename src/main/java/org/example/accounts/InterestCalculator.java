package org.example.accounts;

import com.google.inject.Singleton;

@Singleton
public class InterestCalculator {
    private double interestPercentage = 5;

    public double getInterest(BankAccount bankAccount){
        return bankAccount.getBalance()/100*interestPercentage;
    }
}
