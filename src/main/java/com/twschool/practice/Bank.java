package com.twschool.practice;

import java.math.BigDecimal;

public class Bank {
    public Money transformWith(Money money, String currency) {
        if (currency.equals(money.getCurrency())) {
            return money;
        }
        if (currency.equals("USD")) {
            if (money.getCurrency().equals("CHF")) {
                return new Money(money.getValue().divide(BigDecimal.valueOf(2), 2, BigDecimal.ROUND_FLOOR), "USD");
            }
        }
        if (currency.equals("CHF")) {
            if (money.getCurrency().equals("USD")) {
                return new Money(money.getValue().multiply(BigDecimal.valueOf(2)), "CHF");
            }
        }
        return null;
    }
}
