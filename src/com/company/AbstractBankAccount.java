package com.company;

public abstract class AbstractBankAccount implements BankAccount {
    protected int acctnum;
    protected int balance = 0;
    private OwnerStrategy owner = new Domestic();

    protected AbstractBankAccount(int acctnum){
        this.acctnum = acctnum;
    }

    public int getAcctNum() {
        return acctnum;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isForeign(){
        return owner.isForeign();
    }

    public int fee(){
        return owner.fee();
    }

    public void setForeign(boolean b) {
        owner = b ? new Foreign() : new Domestic();
    }

    public void deposit(int amt){
        balance += amt;
    }

    public int compareTo(BankAccount ba) {
        int bal1 = getBalance();
        int bal2 = ba.getBalance();
        if (bal1 == bal2) {
            return getAcctNum() - ba.getAcctNum();
        } else {
            return bal1 - bal2;
        }
    }

    public boolean equals(Object obj){
        if (!(obj instanceof BankAccount))
            return false;
        BankAccount ba = (BankAccount) obj;
        return getAcctNum() == ba.getAcctNum();
    }

    public boolean hasEnoughCollateral(int loanamt){
        double ratio = collateralRatio();
        return balance >= loanamt * ratio;
    }

    public String toString(){
        String accType = accountType();
        return accType +" account" + acctnum + " :balance=" + balance +", is"
                + owner.toString() + ", fee =" + fee();
    }

    public void addInterest(){
        balance += (int)(balance * interestRate());
    }

    protected abstract double collateralRatio();
    protected abstract double interestRate();
    protected abstract String accountType();


}
