package org.example;

import com.google.inject.AbstractModule;
import org.example.accounts.AccountNumberGenerator;
import org.example.accounts.SlovakiaBankAccountNumberGenerator;
import org.example.people.OwnerGsonSerializationService;
import org.example.people.OwnerJsonSerializationService;
import org.example.people.PersonSerializationService;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure(){
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
        this.bind(PersonSerializationService.class).to(OwnerJsonSerializationService.class);
    }
}
