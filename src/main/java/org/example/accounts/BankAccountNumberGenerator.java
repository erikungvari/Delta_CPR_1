package org.example.accounts;

import java.util.Random;

public class BankAccountNumberGenerator implements AccountNumberGenerator{
    private String bankAccountNumber;

    public String generateBankAccountNumber(){
        Random rnd = new Random();
        long bankAccountNumber = 1000000000L + (long)(rnd.nextDouble() * 9000000000L);

        return Long.toString(bankAccountNumber);
    }
}
