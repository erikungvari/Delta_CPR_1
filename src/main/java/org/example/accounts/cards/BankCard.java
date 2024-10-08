package org.example.accounts.cards;

public class BankCard {
    private String bankCardNumber;
    private String bankCardPIN;

    public BankCard(String bankCardNumber, String bankCardPIN) {
        this.bankCardNumber = bankCardNumber;
        this.bankCardPIN = bankCardPIN;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public String getBankCardPIN() {
        return bankCardPIN;
    }
}
