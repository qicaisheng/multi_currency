package com.twschool.practice;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Instruments {
    private final List<Instrument> instruments;

    public Instruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Money getTotalMoneyInUSD() {
        Bank bank = new Bank();
        bank.setRate(Currency.USD, Currency.CHF, new BigDecimal("1.50"));
        List<Money> moneyList = instruments.stream().map(instrument -> bank.transformWithUSD(instrument.total())).collect(Collectors.toList());
        
        return moneyList.stream().reduce(Money.dollar(BigDecimal.ZERO), ((money1, money2) -> new Sum(money1, money2).dollar()));
    }
}
