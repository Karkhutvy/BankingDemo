package com.company;

public class Domestic implements OwnerStrategy {
    @Override
    public boolean isForeign() {
        return false;
    }

    @Override
    public int fee() {
        return 0;
    }

    @Override
    public String toString() {
        return "domestic";
    }
}
