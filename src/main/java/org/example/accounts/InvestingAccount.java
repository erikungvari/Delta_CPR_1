package org.example.accounts;

import com.google.inject.Inject;
import org.example.people.Owner;

import java.util.HashMap;
import java.util.Map;

public class InvestingAccount extends BankAccount{

    private Map<String, Share> shares;

    public InvestingAccount(double balance, Owner owner, Map<String, Share> shares, String accountNumber) {
        super(balance, owner, accountNumber);
        this.shares = shares;
    }

    public Map<String, Share> getShares() {
        return shares;
    }
}
