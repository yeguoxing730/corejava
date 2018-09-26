package com.designmodel.struct.decorators;

public class DecoratorTest {
    public static void main(String[] args) {
        Singing singing = new ChineseSing();
        singing.sing();
        singing = new SlowSing(singing);
        singing = new LoudSing(singing);
        singing.sing();
    }
}
