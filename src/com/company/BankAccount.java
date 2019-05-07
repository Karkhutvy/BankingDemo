package com.company;

public class BankAccount {
    private int acctnum;
    private int balance = 0;
    private boolean isforeign = false;

    public BankAccount(int a){
        acctnum = a;
    }

    public int getAcctnum() {
        return acctnum;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amt) {
        this.balance = amt;
    }

    public boolean isIsforeign() {
        return isforeign;
    }

    public void setIsforeign(boolean b) {
        this.isforeign = b;
    }
}
