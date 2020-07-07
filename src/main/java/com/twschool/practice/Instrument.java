package com.twschool.practice;

import java.math.BigDecimal;

public class Instrument {
    private final String name;
    private final int shares;
    private final Money unitPrice;

    public Instrument(String name, int shares, Money unitPrice) {
        this.name = name;
        this.shares = shares;
        this.unitPrice = unitPrice;
    }


    public Money total() {
        return new Money(unitPrice.getValue().multiply(BigDecimal.valueOf(shares)), unitPrice.getCurrency());
    }
}
