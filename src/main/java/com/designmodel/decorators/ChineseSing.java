package com.designmodel.decorators;

public class ChineseSing implements Singing {
    ChineseSing(){};
    @Override
    public void sing() {
        System.out.println("sing with chinese");
    }
}
