package com.javarush.task.task14.task1417;

public class Hryvnia extends Money {
    Hryvnia(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "UAH";
    }
}
