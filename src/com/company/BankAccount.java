package com.company;

public class BankAccount {
    private int acctnum;
    private int balance = 0;
    private boolean isforeign = false;
    private double rate = 0.01;

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

    public void deposit(int amt){
        balance += amt;
    }

    public boolean hasEnoughCollateral(int loanAmt){
        return balance >= loanAmt / 2;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "acctnum=" + acctnum +
                ", balance=" + balance +
                ", isforeign=" + isforeign +
                '}';
    }

    public void addInterest(){
        balance+=(int) (balance*rate);
    }
}
