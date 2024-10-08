package org.example.accounts.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankCardFactory {
    @Inject
    BankCardNumberGenerator bankCardNumberGenerator;
    @Inject
    BankCardPINGenerator bankCardPINGenerator;

    public BankCard createBankCard(){
        return new BankCard(bankCardNumberGenerator.generateBankCardNumber(), bankCardPINGenerator.generateBankCardPIN());
    }
}
