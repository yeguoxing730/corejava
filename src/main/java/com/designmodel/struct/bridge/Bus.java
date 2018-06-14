package com.designmodel.struct.bridge;

public class Bus extends Car {

    public Bus(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Bus:");
        this.getEngine().installEngine();
    }
}
