package com.twschool.practice;

import java.util.Objects;

public class Money {
    private final int value;
    private final String currency;

    public Money(int value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        
        Money currentMoney = new Bank().transformWith(this, "USD");
        Money comparedMoney = new Bank().transformWith(money, "USD");
        
        return currentMoney.getValue() == comparedMoney.value &&
                Objects.equals(currentMoney.getCurrency(), comparedMoney.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    public int getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}
