package com.company;

import java.util.Comparator;

public class AcctByMinBal implements Comparator<BankAccount> {
    @Override
    public int compare(BankAccount bankAccount, BankAccount t1) {
        int bal1 = bankAccount.getBalance();
        int bal2 = t1.getBalance();
        if (bal1 == bal2){
            return bankAccount.getAcctNum() - t1.getAcctNum();
        }
        return bal1 - bal2;
    }
}
