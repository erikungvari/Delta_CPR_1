package org.example;

import com.google.inject.AbstractModule;
import org.example.accounts.AccountNumberGenerator;
import org.example.accounts.SlovakiaBankAccountNumberGenerator;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure(){
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
    }
}
