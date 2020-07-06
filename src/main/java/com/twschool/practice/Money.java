package com.twschool.practice;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal value;
    private final String currency;

    public Money(BigDecimal value, String currency) {
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

    public String getCurrency() {
        return currency;
    }

    public Money add(Money money) {
        Money currentMoneyInUSD = new Bank().transformWith(this, "USD");
        Money addMoneyInUSD = new Bank().transformWith(money, "USD");
        
        return new Money(currentMoneyInUSD.getValue().add(addMoneyInUSD.getValue()), "USD");
    }
}
