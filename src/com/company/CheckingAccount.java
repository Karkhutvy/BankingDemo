package com.company;

public abstract class CheckingAccount extends AbstractBankAccount {

    protected CheckingAccount(int a) {
        super(a);
    }

    @Override
    public double collateralRatio(){
        return 2.0 / 3.0;
    }

    protected abstract String accountType();
    protected abstract double interestRate();




}

