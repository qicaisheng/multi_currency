package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BankTest {

    @Test
    public void should_return_5_USD_when_transform_with_USD_given_5_USD() {
        Money fiveDollar = new Money(BigDecimal.valueOf(5), Currency.USD);
        Bank bank = new Bank();
        
        Money transformedMoney = bank.transformWith(fiveDollar, Currency.USD);
        Assert.assertEquals(BigDecimal.valueOf(5), transformedMoney.getValue());
        Assert.assertEquals(Currency.USD, transformedMoney.getCurrency());

        Money transformedMoneyWithUSD = bank.transformWithUSD(fiveDollar);
        Assert.assertEquals(BigDecimal.valueOf(5), transformedMoneyWithUSD.getValue());
    }
    
    @Test
    public void should_return_5_USD_when_transform_with_USD_given_10_CHF() {
        Money money = new Money(BigDecimal.TEN, Currency.CHF);
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, Currency.USD);
        Assert.assertEquals(new BigDecimal("5.00"), transformedMoney.getValue());
        Assert.assertEquals(Currency.USD, transformedMoney.getCurrency());

        Money transformedMoneyWithUSD = bank.transformWithUSD(money);
        Assert.assertEquals(new BigDecimal("5.00"), transformedMoneyWithUSD.getValue());
    }

    @Test
    public void should_return_zero_dot_five_USD_when_transform_with_USD_given_1_CHF() {
        Money money = new Money(BigDecimal.valueOf(1), Currency.CHF);
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, Currency.USD);
        Assert.assertEquals(new BigDecimal("0.50"), transformedMoney.getValue());
        Assert.assertEquals(Currency.USD, transformedMoney.getCurrency());

        Money transformedMoneyWithUSD = bank.transformWithUSD(money);
        Assert.assertEquals(new BigDecimal("0.50"), transformedMoneyWithUSD.getValue());
    }

    @Test
    public void should_return_zero_dot_five_USD_when_transform_with_USD_given_1_dot_1_CHF() {
        Money money = new Money(new BigDecimal("1.01"), Currency.CHF);
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, Currency.USD);
        Assert.assertEquals(new BigDecimal("0.50"), transformedMoney.getValue());
        Assert.assertEquals(Currency.USD, transformedMoney.getCurrency());

        Money transformedMoneyWithUSD = bank.transformWithUSD(money);
        Assert.assertEquals(new BigDecimal("0.50"), transformedMoneyWithUSD.getValue());

    }

    @Test
    public void should_return_10_USD_when_transform_with_CHF_given_5_USD() {
        Money money = new Money(BigDecimal.valueOf(5), Currency.USD);
        Bank bank = new Bank();

        Money transformedMoney = bank.transformWith(money, Currency.CHF);
        Assert.assertEquals(BigDecimal.TEN, transformedMoney.getValue());
        Assert.assertEquals(Currency.CHF, transformedMoney.getCurrency());
    }

    @Test
    public void should_return_5_USD_when_transform_with_USD_given_15_CHF_and_USD_CHF_rate_is_3() {
        Money money = Money.franc(BigDecimal.valueOf(15));
        Bank bank = new Bank();
        bank.setRate(Currency.USD, Currency.CHF, BigDecimal.valueOf(3));

        Money transformedMoney = bank.transformWithUSD(money);
        Assert.assertEquals(new BigDecimal("5.00"), transformedMoney.getValue());
        Assert.assertEquals(Currency.USD, transformedMoney.getCurrency());
    }

    @Test
    public void should_return_2_when_get_rate_from_USD_to_CHF() {
        Bank bank = new Bank();

        BigDecimal rate = bank.rate(Currency.USD, Currency.CHF);
        
        Assert.assertEquals(new BigDecimal("2.00"), rate);
    }

    @Test
    public void should_return_zero_dot_five_when_get_rate_from_CHF_to_USD() {
        Bank bank = new Bank();

        BigDecimal rate = bank.rate(Currency.CHF, Currency.USD);

        Assert.assertEquals(new BigDecimal("0.50"), rate);
    }

    @Test
    public void should_return_1_when_get_rate_from_USD_to_USD() {
        Bank bank = new Bank();

        BigDecimal rate = bank.rate(Currency.USD, Currency.USD);

        Assert.assertEquals(new BigDecimal("1.00"), rate);
    }

}
