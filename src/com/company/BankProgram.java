package com.company;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class BankProgram {
    public static void main(String[] args) throws IOException {
        SavedBankInfo info = new SavedBankInfo("bank.info");
        Map<Integer, BankAccount> accounts = info.getAccounts();
        int nextAccount = info.nextAcctNum();
        Bank bank = new Bank(accounts, nextAccount);
        Scanner scanner = new Scanner(System.in);
        BankClient program = new BankClient(scanner, bank);
        program.run();
        info.saveMap(accounts, info.nextAcctNum());
    }
}


