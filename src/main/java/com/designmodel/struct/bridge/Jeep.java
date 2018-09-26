package com.designmodel.struct.bridge;

public class Jeep extends Car {

    public Jeep(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Jeep:");
        this.getEngine().installEngine();
    }
}
