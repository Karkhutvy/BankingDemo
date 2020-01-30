package com.company;

public class RegularChecking extends CheckingAccount {

    public RegularChecking(int accnum) {
        super(accnum);
    }

    @Override
    protected String accountType() {
        return "Regular Checking";
    }

    @Override
    protected double interestRate() {
        return 0.0;
    }

    public void addInterest() {
        //stub
    }

    public String toString() {
        return "CheckingAccount{" +
                "acctnum=" + acctnum +
                ", balance=" + balance +
                ", isforeign=" + (isForeign ? "foreign " : "domestic ") +
                '}';
    }
}
