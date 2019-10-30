package com.company;

public interface BankAccount {
    public abstract int getAcctNum();

    public abstract int getBalance();

    public abstract boolean isForeign();

    public abstract void setForeign(boolean isforeign);

    public abstract void deposit(int amnt);

    public abstract boolean hasEnoughCollateral(int loanamt);

    public abstract String toString();
}
