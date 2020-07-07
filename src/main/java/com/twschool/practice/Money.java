package com.twschool.practice;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal value;
    private final Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money dollar(BigDecimal value) {
        return new Money(value, Currency.USD);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;

        Bank bank = new Bank();
        Money currentMoney = bank.transformWithUSD(this);
        Money comparedMoney = bank.transformWithUSD(money);
        
        return currentMoney.getValue().compareTo(comparedMoney.value) == 0 &&
                Objects.equals(currentMoney.getCurrency(), comparedMoney.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Money add(Money money) {
        Bank bank = new Bank();
        Money currentMoneyInUSD = bank.transformWithUSD(this);
        Money addMoneyInUSD = bank.transformWithUSD(money);
        
        return new Money(currentMoneyInUSD.getValue().add(addMoneyInUSD.getValue()), Currency.USD);
    }
}
