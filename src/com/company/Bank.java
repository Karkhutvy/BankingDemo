package com.company;

import java.util.HashMap;
import java.util.Set;

public class Bank {
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private double rate = 0.01;
    private int nextAcct = 0;

    public int newAccount(boolean isForeign) {
        int acctNum = nextAcct++;
        BankAccount ba = new BankAccount(acctNum);
        ba.setIsforeign(isForeign);
        accounts.put(acctNum, ba);
        return acctNum;
    }

    public int getBalance(int acctNum){
        BankAccount ba = accounts.get(acctNum);
        return ba.getBalance();
    }


    public void deposit(int acctNum, int amt) {
        BankAccount ba = accounts.get(acctNum);
        int balance = ba.getBalance();
        ba.setBalance(balance + amt);
    }

    public void setForeign(int acctNum, boolean isForeign){
        BankAccount ba = accounts.get(acctNum);
        ba.setIsforeign(isForeign);
    }

    public boolean authorizeLoan(int acctNum, int loanAmt) {
        BankAccount ba = accounts.get(acctNum);
        int balance = ba.getBalance();
        return  balance >= loanAmt / 2;
    }


    public void addInterest() {
        for (BankAccount ba : accounts.values()) {
            int balance = ba.getBalance();
            int newBalance = (int) (balance * (1 + rate));
            ba.setBalance(newBalance);
        }
    }

    @Override
    public String toString() {
        String result = "The bank has " + accounts.size() + " accounts.";
        for (BankAccount ba: accounts.values()) {
            result += "\n\t Bank account " + ba.getAcctnum() +
                     ": balance=" + ba.getBalance() +
            ", is " + (ba.isIsforeign() ? "foreign" : "domestic");
        }
        return result;
    }
}
