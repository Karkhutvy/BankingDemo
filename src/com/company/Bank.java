package com.company;

import java.util.Date;
import java.util.HashMap;

public class Bank {
    private HashMap<Integer, BankAccount> accounts;
    private int nextAcct;

    public Bank(HashMap<Integer, BankAccount> accounts, int nextAcct) {
        this.accounts = accounts;
        this.nextAcct = nextAcct;
    }

    public int newAccount(int type, boolean isForeign) {
        int acctNum = nextAcct++;
        BankAccount ba;
        if (type == 1) {
            ba = new SavingsAccount(acctNum);
        } else {
            ba = new CheckingAccount(acctNum);
        }
        ba.setForeign(isForeign);
        accounts.put(acctNum, ba);
        return acctNum;
    }

    public int getBalance(int acctNum) {
        BankAccount ba = accounts.get(acctNum);
        return ba.getBalance();
    }


    public void deposit(int acctNum, int amt) {
        BankAccount ba = accounts.get(acctNum);
        if (ba.isForeign()) {
            System.out.println(acctNum + " " + amt + " " + new Date());
        }
        ba.deposit(amt);
    }

    public void setForeign(int acctNum, boolean isForeign) {
        BankAccount ba = accounts.get(acctNum);
        ba.setForeign(isForeign);
    }

    public boolean authorizeLoan(int acctNum, int loanAmt) {
        BankAccount ba = accounts.get(acctNum);
        return ba.hasEnoughCollateral(loanAmt);
    }


    public void addInterest() {
        for (BankAccount ba : accounts.values()) {
            if (ba instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) ba;
                sa.addInterest();
            }

        }


    }

    @Override
    public String toString() {
        String result = "The bank has " + accounts.size() + " accounts.";
        for (BankAccount ba : accounts.values()) {
            result += "\n\t Bank account " + ba.toString();
        }
        return result;
    }
}
