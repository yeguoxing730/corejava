package com.designmodel.struct.decorators;

public class SlowSing implements Singing {
    Singing originSing;
    SlowSing(){};
    SlowSing(Singing sing){
        this.originSing = sing;
    }
    @Override
    public void sing() {
        System.out.println("with slow");
        originSing.sing();
    }
}
