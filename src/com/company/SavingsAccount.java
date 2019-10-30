package com.company;

public class SavingsAccount implements BankAccount {
    private int acctnum;
    private int balance = 0;
    private boolean isforeign = false;
    private double rate = 0.1;

    public SavingsAccount(int a) {
        acctnum = a;
    }

    public int getAcctNum() {
        return acctnum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amt) {
        this.balance = amt;
    }

    public boolean isForeign() {
        return isforeign;
    }

    public void setForeign(boolean b) {
        this.isforeign = b;
    }

    public void deposit(int amt) {
        balance += amt;
    }

    public boolean hasEnoughCollateral(int loanAmt) {
        return balance >= loanAmt / 2;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "acctnum=" + acctnum +
                ", balance=" + balance +
                ", isforeign=" + (isforeign ? "foreign " : "domestic ") +
                '}';
    }

    public void addInterest() {
        balance += (int) (balance * rate);
    }
}
