package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MultiplyTest {
    
    @Test
    public void should_return_15_USD_given_5_USD_multiple_3() {
        Multiply multiply = new Multiply(Money.dollar(new BigDecimal("5.00")), new BigDecimal("3.00"));
        
        Money money = multiply.money();

        Assert.assertEquals(Money.dollar(new BigDecimal("15.00")), money);
    }
}
