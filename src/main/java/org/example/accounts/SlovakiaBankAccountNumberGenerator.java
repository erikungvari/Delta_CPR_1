package org.example.accounts;

import com.google.inject.Singleton;

@Singleton
public class SlovakiaBankAccountNumberGenerator implements AccountNumberGenerator {

    @Override
    public String generateBankAccountNumber() {
        return "An account from the land of drevokocurs";
    }
}
