package com.designmodel.action.stragy.code;

import com.designmodel.action.stragy.code.bean.Item;
import com.designmodel.action.stragy.code.impls.*;
import com.designmodel.action.stragy.code.itf.Calculator;

public class StrategyTest {
    public static void main(String[] args) {
        Item meat = new Item("1001", "猪肉", 100L);
        Calculator alipayCalculator = new AlipayCalculator();
        Calculator weixinPayCalculator = new WeixinPayCalculator();
        Calculator cashCalculator = new CashPayCalculator();

        meat.setCalculator(alipayCalculator);
        System.out.println("支付宝支付价格：" + meat.getFinalPrice());
        meat.setCalculator(weixinPayCalculator);
        System.out.println("微信支付价格：" + meat.getFinalPrice());
        meat.setCalculator(cashCalculator);
        System.out.println("现金支付价格：" + meat.getFinalPrice());
    }
}
