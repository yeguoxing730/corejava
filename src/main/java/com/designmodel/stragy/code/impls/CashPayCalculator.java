package com.designmodel.stragy.code.impls;

import com.designmodel.stragy.code.itf.Calculator;

public class CashPayCalculator implements Calculator {
    @Override
    public double calculatePrice(double price) {
        return price * 0.96;
    }
}
