package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SumTest {

    @Test
    public void should_return_10_USD_when_5_USD_add_15_CHF_given_USD_and_CHF_rate_is_3() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), Currency.USD);
        Money tenFranc = new Money(new BigDecimal("15.00"), Currency.CHF);
        
        Bank bank = new Bank();
        bank.setRate(Currency.USD, Currency.CHF, new BigDecimal("3.00"));

        Money sumMoney = new Sum(fiveDollar, tenFranc).dollar(bank);

        Assert.assertEquals(new Money(BigDecimal.TEN, Currency.USD), sumMoney);
    }

}
