package org.example.accounts;

import org.example.people.Owner;

import java.util.HashMap;
import java.util.Map;

public class InvestingAccount extends BankAccount{

    private Map<String, Share> shares = new HashMap<>();

    public InvestingAccount(double balance, Owner owner, String accountNumber) {
        super(balance, owner, accountNumber);
        this.shares.put("Samsung", new Share("samsung", 30, 0, 2));
        this.shares.put("Riot Games", new Share("riotGames", 60, 0, 3));
        this.shares.put("Meta", new Share("meta", 10, 0, 1));
    }

    public Map<String, Share> getShares() {
        return shares;
    }
}
