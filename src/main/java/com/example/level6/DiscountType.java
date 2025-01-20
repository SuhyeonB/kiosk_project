package com.example.level6;

public enum DiscountType {
    VETERAN(10),
    SOLDIER(5),
    STUDENT(3),
    GENERAL(0);

    private final int rate;

    DiscountType(int rate) {
        this.rate = rate;
    }

    public int getRate(){ return rate; }
}
