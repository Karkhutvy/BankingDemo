package com.company;

public class CheckingAccount implements BankAccount {
    private int acctnum;
    private int balance = 0;
    private boolean isforeign = false;

    public CheckingAccount(int a) {
        this.acctnum = a;
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
        return balance >= 2 * loanAmt / 3;
    }

    @Override
    public void addInterest() {
        // do nothing
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "acctnum=" + acctnum +
                ", balance=" + balance +
                ", isforeign=" + (isforeign ? "foreign " : "domestic ") +
                '}';
    }

    @Override
    public int compareTo(BankAccount bankAccount) {
        int bal1 = getBalance();
        int bal2 = bankAccount.getBalance();
        if (bal1 == bal2)
            return getAcctNum() - bankAccount.getAcctNum();
        else
            return bal1 - bal2;
    }
}
