package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class InstrumentTest {

    @Test
    public void should_get_total_given_instrument_share_and_price() {
        
        Instrument instrument = new Instrument("IBM", 1000, Money.dollar(new BigDecimal("25.00")));
        
        Money total = instrument.total();

        Assert.assertEquals(Money.dollar(new BigDecimal("25000.00")), total);
    }
}
