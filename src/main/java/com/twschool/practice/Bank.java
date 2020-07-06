package com.twschool.practice;

public class Bank {
    public Money transformWith(Money money, String currency) {
        if (currency.equals(money.getCurrency())) {
            return money;
        }
        if (currency.equals("USD")) {
            if (money.getCurrency().equals("CHF")) {
                return new Money(money.getValue() / 2, "USD");
            }
        }
        return null;
    }
}
