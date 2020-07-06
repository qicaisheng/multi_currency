package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void should_return_true_when_compare_5_USD_with_another_5_USD() {
        Money fiveDollar1 = new Money(BigDecimal.valueOf(5), "USD");
        Money fiveDollar2 = new Money(BigDecimal.valueOf(5), "USD");

        Assert.assertEquals(fiveDollar1, fiveDollar2);
    }

    @Test
    public void should_return_true_when_compare_zero_dot_five_USD_with_another_zero_dot_five_USD() {
        Money fiveDollar1 = new Money(BigDecimal.valueOf(0.5), "USD");
        Money fiveDollar2 = new Money(BigDecimal.valueOf(0.5), "USD");

        Assert.assertEquals(fiveDollar1, fiveDollar2);
    }

    @Test
    public void should_return_false_when_compare_5_USD_with_another_5_CHF() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), "USD");
        Money fiveFranc = new Money(BigDecimal.valueOf(5), "CHF");

        Assert.assertNotEquals(fiveDollar, fiveFranc);
    }

    @Test
    public void should_return_true_when_compare_5_USD_with_10_CHF() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), "USD");
        Money tenFranc = new Money(BigDecimal.TEN, "CHF");

        Assert.assertEquals(fiveDollar, tenFranc);
    }

    @Test
    public void should_return_10_USD_when_5_USD_add_10_CHF() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), "USD");
        Money tenFranc = new Money(BigDecimal.TEN, "CHF");

        Money sumMoney = fiveDollar.add(tenFranc);
        
        Assert.assertEquals(new Money(BigDecimal.TEN, "USD"), sumMoney);
    }
}
