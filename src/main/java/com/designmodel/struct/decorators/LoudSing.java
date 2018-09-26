package com.designmodel.struct.decorators;

public class LoudSing implements Singing {
    Singing originSing;

    LoudSing() {
    }

    ;

    LoudSing(Singing sing) {
        this.originSing = sing;
    }

    @Override
    public void sing() {
        System.out.println("with big loud");
        originSing.sing();
    }
}
