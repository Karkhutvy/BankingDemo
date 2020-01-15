package com.company;

public abstract class CheckingAccount extends AbstractBankAccount {

    protected CheckingAccount(int a) {
        super(a);
    }

    public boolean hasEnoughCollateral(int loanAmt) {
        return balance >= 2 * loanAmt / 3;
    }

    @Override
    public abstract void addInterest();

    @Override
    public abstract String toString();

}

