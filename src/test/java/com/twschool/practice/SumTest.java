package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class SumTest {

    @Test
    public void should_return_10_USD_when_5_USD_add_10_CHF() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), Currency.USD);
        Money tenFranc = new Money(BigDecimal.TEN, Currency.CHF);

        Money sumMoney = new Sum(fiveDollar, tenFranc).dollar();

        Assert.assertEquals(new Money(BigDecimal.TEN, Currency.USD), sumMoney);
    }

}
