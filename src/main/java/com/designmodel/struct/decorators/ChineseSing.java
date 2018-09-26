package com.designmodel.struct.decorators;

public class ChineseSing implements Singing {
    ChineseSing() {
    }

    ;

    @Override
    public void sing() {
        System.out.println("sing with chinese");
    }
}
