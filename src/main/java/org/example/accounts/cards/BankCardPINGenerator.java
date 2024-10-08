package org.example.accounts.cards;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class BankCardPINGenerator {
    public String generateBankCardPIN(){
        Random rnd = new Random();
        long bankCardPIN = 1000L + (long)(rnd.nextDouble() * 9000L);

        return Long.toString(bankCardPIN);
    }
}
