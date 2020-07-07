package com.twschool.practice;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal value;
    private final Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value.setScale(2, BigDecimal.ROUND_FLOOR);
        this.currency = currency;
    }

    public static Money dollar(BigDecimal value) {
        return new Money(value, Currency.USD);
    }

    public static Money franc(BigDecimal value) {
        return new Money(value, Currency.CHF);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value) &&
                currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

}
