package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class SavedBankInfo {
    private String fName;
    private Map<Integer,BankAccount> accounts = new HashMap<Integer, BankAccount>();
    private int nextAccount = 0;
    private ByteBuffer bb = ByteBuffer.allocate(16);

    public SavedBankInfo(String fName){
        this.fName = fName;
        if (!new File(fName).exists())
            return;
        try (InputStream is = new FileInputStream(fName)){
            readMap(is);
        }
        catch (IOException ex){
            throw new RuntimeException("file read exception");
        }
    }

    public Map<Integer, BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<Integer, BankAccount> accounts) {
        this.accounts = accounts;
    }

    public int nextAcctNum(){
        return nextAccount;
    }

    public void saveMap(Map<Integer, BankAccount> map, int nextAccount) throws IOException{
        try (OutputStream os = new FileOutputStream(fName)){
            writeMap(os, map, nextAccount);
        }
        catch (IOException ex){
            throw new RuntimeException("file write exception");
        }
    }

    public void writeMap(OutputStream os, Map<Integer, BankAccount> map, int nextAccount) throws IOException{
        writeInt(os, nextAccount);
        for (BankAccount ba: map.values())
            writeAccount(os, ba);
    }

    public void readMap(InputStream is) throws IOException{
        nextAccount = readInt(is);
        BankAccount ba = readAccount(is);
        while (ba!=null){
            accounts.put(ba.getAcctNum(), ba);
            ba = readAccount(is);
        }
    }

    private void writeInt(OutputStream os, int n) throws IOException {
        bb.putInt(0, n);
        os.write(bb.array(), 0, 4);
    }

    private int readInt(InputStream is) throws IOException {
        is.read(bb.array(), 0, 4);
        return bb.getInt(0);
    }

    private void writeAccount(OutputStream os, BankAccount ba) throws IOException {
        int type = (ba instanceof SavingsAccount) ? 1
                : (ba instanceof RegularChecking) ? 2: 3 ;
        bb.putInt(0, ba.getAcctNum());
        bb.putInt(4, type);
        bb.putInt(8, ba.getBalance());
        bb.putInt(12, ba.isForeign() ? 1 : 2);
        os.write(bb.array());
    }

    private BankAccount readAccount(InputStream is) throws IOException {
        int n = is.read(bb.array());
        if (n < 0)
            return null;
        int num = bb.getInt(0);
        int type = bb.get(4);
        int balance = bb.get(8);
        int isForeign = bb.get(12);

        BankAccount ba;

        if (type == 1)
            ba = new SavingsAccount(num);
        else if (type == 2)
            ba = new RegularChecking(num);
        else
            ba = new InterestChecking(num);
        ba.deposit(balance);
        ba.setForeign(isForeign == 1);
        return ba;
    }
}
