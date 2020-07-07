package com.twschool.practice;

import java.math.BigDecimal;

public class Multiply {
    private final Money money;
    private final BigDecimal times;

    public Multiply(Money money, BigDecimal times) {
        this.money = money;
        this.times = times;
    }

    public Money money() {
        return new Money(money.getValue().multiply(times), money.getCurrency());
    }
}
