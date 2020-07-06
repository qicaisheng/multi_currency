package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class BankTest {

    @Test
    public void should_return_5_USD_when_transform_with_USD_given_5_USD() {
        Money fiveDollar = new Money(5, "USD");
        Bank bank = new Bank();
        
        Money transformedMoney = bank.transformWith(fiveDollar, "USD");
        Assert.assertEquals(5, transformedMoney.getValue());
        Assert.assertEquals("USD", transformedMoney.getCurrency());
    }

    @Test
    public void should_return_5_USD_when_transform_with_USD_given_10_CHF() {
        Money money = new Money(10, "CHF");
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, "USD");
        Assert.assertEquals(5, transformedMoney.getValue());
        Assert.assertEquals("USD", transformedMoney.getCurrency());
    }
}
