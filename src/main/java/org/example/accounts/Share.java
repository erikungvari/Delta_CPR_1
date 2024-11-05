package org.example.accounts;

public class Share {
    private String name;
    private int part;
    private double balance;
    private double dividend;

    public Share(String name, int part, double balance, double dividend) {
        this.name = name;
        this.part = part;
        this.balance = balance;
        this.dividend = dividend;
    }

    public double getBalance() {
        return balance;
    }

    public int getPart() {
        return part;
    }

    public String getName() {
        return name;
    }

    public double getDividend() {
        return dividend;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
