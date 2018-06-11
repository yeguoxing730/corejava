package com.designmodel.stragy.xml.impl;

import com.designmodel.stragy.xml.itf.Strategy;

public class WriteStrategy implements Strategy {
    @Override
    public void testStrategy() {
        System.out.println("我要写字！！！");
    }
}
