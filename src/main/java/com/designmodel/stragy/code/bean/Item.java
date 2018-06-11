package com.designmodel.stragy.code.bean;

import com.designmodel.stragy.code.itf.Calculator;

public class Item {
    private Calculator calculator;
    private double itemPrice;
    private String itemId;
    private String itemName;
    public Item(String itemId, String itemName, double itemPrice){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    public double getFinalPrice(){
        return calculator.calculatePrice(this.itemPrice);
    }
    public Calculator getCalculator() {
        return calculator;
    }
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
