package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class InstrumentsTest {
    @Test
    public void should_get_total_price_with_USD_given_two_instruments() {
        Instrument ibmInstrument = new Instrument("IBM", 1000, Money.dollar(new BigDecimal("25.00")));
        Instrument novartisInstrument = new Instrument("Novartis", 400, Money.franc(new BigDecimal("150.00")));
        Instruments instruments = new Instruments(Arrays.asList(ibmInstrument, novartisInstrument));
        
        Money total = instruments.getTotalMoneyInUSD();

        Assert.assertEquals(Money.dollar(new BigDecimal("65000.00")), total);
    }
}
