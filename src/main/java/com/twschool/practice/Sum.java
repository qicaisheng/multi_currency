package com.twschool.practice;

public class Sum {
    private final Money augend;
    private final Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    public Money dollar() {
        Bank bank = new Bank();
        Money augendInUSD = bank.transformWithUSD(augend);
        Money addendInUSD = bank.transformWithUSD(addend);
        return Money.dollar(augendInUSD.getValue().add(addendInUSD.getValue()));
    }
}
