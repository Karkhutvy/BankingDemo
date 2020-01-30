package com.company;

public class InterestChecking extends CheckingAccount {
    private double rate = 0.01;

    public InterestChecking(int acctnum) {
        super(acctnum);
    }

    @Override
    protected String accountType() {
        return "Interest Checking";
    }

    @Override
    protected double interestRate() {
        return rate;
    }
}
