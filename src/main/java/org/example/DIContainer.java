package org.example;

import org.example.accounts.*;
import org.example.people.OwnerFactory;
import org.example.people.PersonIDValidator;
import org.example.print.AccountDetailPrinter;

public class DIContainer {
    private AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private AccountDetailPrinter accountDetailPrinter = new AccountDetailPrinter();
    private PersonIDValidator personIDValidator = new PersonIDValidator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);
    private BankAccountFactory bankAccountFactory = new BankAccountFactory(bankAccountNumberGenerator);
    private OwnerFactory ownerFactory = new OwnerFactory(bankAccountNumberGenerator, personIDValidator);

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
}
