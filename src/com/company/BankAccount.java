package com.company;

public interface BankAccount extends Comparable<BankAccount>{
    public abstract int getAcctNum();

    public abstract int getBalance();

    public abstract boolean isForeign();

    public abstract void setForeign(boolean isforeign);

    public abstract void deposit(int amnt);

    public abstract boolean hasEnoughCollateral(int loanamt);

    void addInterest();

    static  BankAccount createSavingsWithDeposit(int acctnum, int n) {
        BankAccount ba = new SavingsAccount(acctnum);
        ba.deposit(n);
        return ba;
    }

    default boolean isEmpty(){
        return getBalance() == 0;
    }

    public abstract String toString();
}
