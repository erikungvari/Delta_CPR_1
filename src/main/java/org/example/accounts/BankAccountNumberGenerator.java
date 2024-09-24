package org.example.accounts;

import java.util.Random;

public class BankAccountNumberGenerator {
    private String bankAccountNumber;

    public String GenerateBankAccountNumber(){
        Random rnd = new Random();
        long bankAccountNumber = 1000000000L + (long)(rnd.nextDouble() * 9000000000L);

        return Long.toString(bankAccountNumber);
    }
}
