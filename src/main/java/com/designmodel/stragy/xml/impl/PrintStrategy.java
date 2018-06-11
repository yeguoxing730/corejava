package com.designmodel.stragy.xml.impl;

import com.designmodel.stragy.xml.itf.Strategy;

public class PrintStrategy implements Strategy {
    @Override
    public void testStrategy() {
        System.out.print("我要打印！！");
    }
}
