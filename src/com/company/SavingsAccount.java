package com.company;

public class SavingsAccount extends AbstractBankAccount {
    private double rate = 0.1;


    public SavingsAccount(int a) {
        super(a);
    }

    @Override
    protected double collateralRatio() {
        return 1.0 / 2.0;
    }

    @Override
    protected double interestRate() {
        return 0.01;
    }

    @Override
    protected String accountType() {
        return "Savings";
    }

}
