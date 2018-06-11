package com.designmodel.action.stragy.code.impls;

import com.designmodel.action.stragy.code.itf.Calculator;

public class AlipayCalculator implements Calculator {

    @Override
    public double calculatePrice(double price) {
        return price * 0.9;
    }
}
