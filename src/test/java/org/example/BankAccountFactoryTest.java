package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.accounts.BankAccount;
import org.example.accounts.BankAccountFactory;
import org.example.people.Owner;
import org.example.people.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountFactoryTest {
    Injector i = Guice.createInjector(new BankInjector());

    private BankAccountFactory bankAccountFactory;
    private OwnerFactory ownerFactory;

    @BeforeEach
    public void setup(){
        this.bankAccountFactory = i.getInstance(BankAccountFactory.class);
        this.ownerFactory = i.getInstance(OwnerFactory.class);
    }

    @Test
    public void createBankAccount(){
        Owner owner = ownerFactory.createOwner("Karel", "Novák", "69");
        BankAccount bankAccount = bankAccountFactory.createBankAccount(owner, 1200);

        assertEquals(bankAccount.getBalance(), 1200);
        assertEquals(owner.getFirstname(), "Karel");
        assertEquals(owner.getLastname(), "Novák");
        assertEquals(owner.getPersonID(), "69");
        assertEquals(bankAccount.getOwner(), owner);
    }
}
