package org.example.accounts;

public class SlovakiaBankAccountNumberGenerator implements AccountNumberGenerator {

    @Override
    public String generateBankAccountNumber() {
        return "An account from the land of drevokocurs";
    }
}
