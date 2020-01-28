package com.company;

public class RegularChecking extends CheckingAccount {

    public RegularChecking(int accnum) {
        super(accnum);
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
