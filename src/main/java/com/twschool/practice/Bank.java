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
        BigDecimal value = money.getValue().divide(rate(currency, money.getCurrency()), 2, BigDecimal.ROUND_FLOOR);
        return new Money(value, currency);
    }

    private Money transformWithCHF(Money money) {
        BigDecimal value = money.getValue().divide(rate(Currency.CHF, money.getCurrency()), 2, BigDecimal.ROUND_FLOOR);
        return Money.franc(value);
    }

    public Money transformWithUSD(Money money) {
        BigDecimal value = money.getValue().divide(rate(Currency.USD, money.getCurrency()), 2, BigDecimal.ROUND_FLOOR);
        return Money.dollar(value);
    }

    public void setRate(Currency from, Currency to, BigDecimal rate) {
        rates.put(new Pair<>(from, to), rate);
    }

    public BigDecimal rate(Currency from, Currency to) {
        if (from == to) {
            return new BigDecimal("1.00");
        }
        return rates.get(new Pair<>(from, to));
    }
}
