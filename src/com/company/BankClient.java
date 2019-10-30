package com.company;

import java.util.Scanner;

public class BankClient {
    private int current = -1;
    private Scanner scanner;
    private boolean done = false;
    private Bank bank;

    public BankClient(Scanner scanner, Bank bank){
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run() {
        while (!done) {
            System.out.println("Enter command (0-quit, 1-new," +
                    " 2-select, 3-deposit, 4-loan, 5-show, 6-interest 7-set foreign):");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    private void processCommand(int cmd) {
        if (cmd == 0) quit();
        else if (cmd == 1) newAccount();
        else if (cmd == 2) select();
        else if (cmd == 3) deposit();
        else if (cmd == 4) authorizeLoan();
        else if (cmd == 5) showAll();
        else if (cmd == 6) addInterest();
        else if (cmd == 7) setForeign();
        else
            System.out.println("illegal command");

    }

    private void newAccount() {
        boolean isForeign = requestForeign();
        int type = requestType();
        current = bank.newAccount(type, isForeign);
        System.out.println("Your new account number is "
                + current);
    }

    private void select() {
        System.out.print("Enter acct#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account "
                + current + " is " + balance);

    }

    private void deposit() {
        System.out.print("Enter deposit amt: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);

    }

    private void authorizeLoan() {
        System.out.print("Enter loan amt: ");
        int loanAmt = scanner.nextInt();
        if (bank.authorizeLoan(current, loanAmt))
            System.out.println("Your loan is approved");
        else
            System.out.println("Your loan is denied");
    }

    private void showAll() {
        System.out.println(bank);
    }

    private void addInterest() {
        bank.addInterest();
    }

    private void quit() {
        done = true;
        System.out.println("Bye");
    }

    private void setForeign() {
        bank.setForeign(current, requestForeign());
    }

    private boolean requestForeign() {
        System.out.print("Enter 1 for foreign," +
                " 2 for domestic: ");
        int val = scanner.nextInt();
        return (val == 1);
    }

    private int requestType() {
        System.out.print("Enter 1 for Savings," +
                " 2 for Checking: ");
        int val = scanner.nextInt();
        return val;
    }


}
