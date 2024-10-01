package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.*;
import org.example.people.*;
import org.example.print.AccountDetailPrinter;

@Singleton
public class DIContainer {
    private AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
    private PersonIDValidator personIDValidator = new PersonIDValidator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);

    @Inject
    private BankAccountFactory bankAccountFactory;

    private OwnerFactory ownerFactory = new OwnerFactory(bankAccountNumberGenerator, personIDValidator);
    private PersonSerializationService personSerializationService = new OwnerGsonPersonalizationService();

    public AccountNumberGenerator getBankAccountNumberGenerator() {
        return bankAccountNumberGenerator;
    }

    public TransferFeeCalculator getTransferFeeCalculator() {
        return transferFeeCalculator;
    }

    public AccountDetailPrinter getAccountDetailPrinter() {
        return accountDetailPrinter;
    }

    public PersonIDValidator getPersonIDValidator() {
        return personIDValidator;
    }

    public MoneyTransferService getMoneyTransferService() {
        return moneyTransferService;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public OwnerFactory getOwnerFactory() {
        return ownerFactory;
    }

    public PersonSerializationService getPersonSerializationService() {
        return personSerializationService;
    }
}
