package org.example.accounts.cards;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class BankCardNumberGenerator {
    public String generateBankCardNumber(){
        Random rnd = new Random();
        long bankCardNumber = 1000000000000000L + (long)(rnd.nextDouble() * 9000000000000000L);

        return Long.toString(bankCardNumber);
    }
}
