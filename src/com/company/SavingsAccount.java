package com.company;

import java.util.Objects;

public class SavingsAccount extends AbstractBankAccount {
    private double rate = 0.1;


    public SavingsAccount(int a) {
        super(a);
    }

    public boolean hasEnoughCollateral(int loanAmt) {
        return balance >= loanAmt / 2;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "acctnum=" + acctnum +
                ", balance=" + balance +
                ", isforeign=" + (isForeign ? "foreign " : "domestic ") +
                '}';
    }

    public void addInterest() {
        balance += (int) (balance * rate);
    }

}
