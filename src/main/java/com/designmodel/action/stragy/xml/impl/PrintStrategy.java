package com.designmodel.action.stragy.xml.impl;

import com.designmodel.action.stragy.xml.itf.Strategy;

public class PrintStrategy implements Strategy {
    @Override
    public void testStrategy() {
        System.out.print("我要打印！！");
    }
}
