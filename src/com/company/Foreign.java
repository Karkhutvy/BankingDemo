package com.company;

public class Foreign implements OwnerStrategy {
    @Override
    public boolean isForeign() {
        return true;
    }

    @Override
    public int fee() {
        return 500;
    }

    @Override
    public String toString(){
        return "foreign";
    }
}
