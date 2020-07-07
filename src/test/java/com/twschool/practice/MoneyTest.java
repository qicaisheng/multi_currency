package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void should_return_true_when_compare_5_USD_with_another_5_USD() {
        Money fiveDollar1 = new Money(BigDecimal.valueOf(5), Currency.USD);
        Money fiveDollar2 = new Money(BigDecimal.valueOf(5), Currency.USD);

        Assert.assertEquals(fiveDollar1, fiveDollar2);
    }

    @Test
    public void should_return_true_when_compare_zero_dot_five_USD_with_another_zero_dot_five_USD() {
        Money fiveDollar1 = new Money(BigDecimal.valueOf(0.5), Currency.USD);
        Money fiveDollar2 = new Money(BigDecimal.valueOf(0.5), Currency.USD);

        Assert.assertEquals(fiveDollar1, fiveDollar2);
    }

    @Test
    public void should_return_false_when_compare_5_USD_with_another_5_CHF() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), Currency.USD);
        Money fiveFranc = new Money(BigDecimal.valueOf(5), Currency.CHF);

        Assert.assertNotEquals(fiveDollar, fiveFranc);
    }

    @Test
    public void should_return_true_when_compare_5_USD_with_10_CHF() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), Currency.USD);
        Money tenFranc = new Money(BigDecimal.TEN, Currency.CHF);

        Assert.assertEquals(fiveDollar, tenFranc);
    }
    
    @Test
    public void should_return_5_USD_when_with_dollar_five() {
        Money money = Money.dollar(BigDecimal.valueOf(5));
        
        Assert.assertEquals(new Money(BigDecimal.valueOf(5), Currency.USD), money);
    }

    @Test
    public void should_return_5_CHF_when_with_franc_five() {
        Money money = Money.franc(BigDecimal.valueOf(5));

        Assert.assertEquals(new Money(BigDecimal.valueOf(5), Currency.CHF), money);
    }
}
