package com.twschool.practice;

public class Bank {
    public Money transformWith(Money money, String currency) {
        if (currency.equals(money.getCurrency())) {
            return money;
        }
        return null;
    }
}
