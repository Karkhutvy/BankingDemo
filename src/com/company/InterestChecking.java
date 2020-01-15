package com.company;

public class InterestChecking extends CheckingAccount {
    private double rate = 0.01;

    public InterestChecking(int acctnum){
        super(acctnum);
    }

    @Override
    public String toString() {
        return "Interest checking account" + acctnum
                + ": balance =" + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }

    public void addInterest(){
        int newBalance = (int)(getBalance() * rate);
        deposit(newBalance);
    }
}
