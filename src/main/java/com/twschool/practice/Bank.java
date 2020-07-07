package com.twschool.practice;

import javafx.util.Pair;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    
    private Map<Pair<Currency, Currency>, BigDecimal> rates = new HashMap<>();

    public Bank() {
        this.rates.put(new Pair<>(Currency.USD, Currency.CHF), new BigDecimal("2.00"));
        this.rates.put(new Pair<>(Currency.CHF, Currency.USD), new BigDecimal("0.50"));
    }

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
            BigDecimal value = money.getValue().divide(rates.get(new Pair<>(Currency.USD, Currency.CHF)), 2, BigDecimal.ROUND_FLOOR);
            return Money.dollar(value);
        }
        return money;
    }

    public void setRate(Currency from, Currency to, BigDecimal rate) {
        rates.put(new Pair<>(from, to), rate);
    }

    public BigDecimal rate(Currency from, Currency to) {
        return rates.get(new Pair<>(from, to));
    }
}
