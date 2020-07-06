package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class MoneyTest {

    @Test
    public void should_return_true_when_compare_5_USD_with_another_5_USD() {
        Money fiveDollar1 = new Money(5, "USD");
        Money fiveDollar2 = new Money(5, "USD");

        Assert.assertEquals(fiveDollar1, fiveDollar2);
    }

    @Test
    public void should_return_false_when_compare_5_USD_with_another_5_CHF() {
        Money fiveDollar = new Money(5, "USD");
        Money fiveFranc = new Money(5, "CHF");

        Assert.assertNotEquals(fiveDollar, fiveFranc);
    }

    @Test
    public void should_return_true_when_compare_5_USD_with_10_CHF() {
        Money fiveDollar = new Money(5, "USD");
        Money tenFranc = new Money(10, "CHF");

        Assert.assertEquals(fiveDollar, tenFranc);
    }
}
