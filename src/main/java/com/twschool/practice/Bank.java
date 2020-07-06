package com.twschool.practice;

import java.math.BigDecimal;

public class Bank {
    public Money transformWith(Money money, Currency currency) {
        if (currency == money.getCurrency()) {
            return money;
        }
        if (currency == Currency.USD) {
            return transformWithUSD(money);
        }
        if (currency == Currency.CHF) {
            if (money.getCurrency() == Currency.USD) {
                return new Money(money.getValue().multiply(BigDecimal.valueOf(2)), Currency.CHF);
            }
        }
        return null;
    }

    public Money transformWithUSD(Money money) {
        if (money.getCurrency() == Currency.CHF) {
            return new Money(money.getValue().divide(BigDecimal.valueOf(2), 2, BigDecimal.ROUND_FLOOR), Currency.USD);
        }
        return money;
    }
}
