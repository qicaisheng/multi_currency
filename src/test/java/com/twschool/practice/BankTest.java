package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BankTest {

    @Test
    public void should_return_5_USD_when_transform_with_USD_given_5_USD() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), "USD");
        Bank bank = new Bank();
        
        Money transformedMoney = bank.transformWith(fiveDollar, "USD");
        Assert.assertEquals(BigDecimal.valueOf(5), transformedMoney.getValue());
        Assert.assertEquals("USD", transformedMoney.getCurrency());
    }

    @Test
    public void should_return_5_USD_when_transform_with_USD_given_10_CHF() {
        Money money = new Money(BigDecimal.TEN, "CHF");
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, "USD");
        Assert.assertEquals(new BigDecimal("5.00"), transformedMoney.getValue());
        Assert.assertEquals("USD", transformedMoney.getCurrency());
    }

    @Test
    public void should_return_zero_dot_five_USD_when_transform_with_USD_given_1_CHF() {
        Money money = new Money(BigDecimal.valueOf(1), "CHF");
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, "USD");
        Assert.assertEquals(new BigDecimal("0.50"), transformedMoney.getValue());
        Assert.assertEquals("USD", transformedMoney.getCurrency());
    }

    @Test
    public void should_return_10_USD_when_transform_with_CHF_given_5_USD() {
        Money money = new Money(BigDecimal.valueOf(5), "USD");
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, "CHF");
        Assert.assertEquals(BigDecimal.TEN, transformedMoney.getValue());
        Assert.assertEquals("CHF", transformedMoney.getCurrency());
    }
}
