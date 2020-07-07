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
            return transformWithCHF(money);
        }
        return null;
    }

    private Money transformWithCHF(Money money) {
        if (money.getCurrency() == Currency.USD) {
            BigDecimal value = money.getValue().multiply(BigDecimal.valueOf(2));
            return Money.franc(value);
        }
        return money;
    }

    public Money transformWithUSD(Money money) {
        if (money.getCurrency() == Currency.CHF) {
            BigDecimal value = money.getValue().divide(BigDecimal.valueOf(2), 2, BigDecimal.ROUND_FLOOR);
            return Money.dollar(value);
        }
        return money;
    }
}
