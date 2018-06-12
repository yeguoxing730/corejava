package com.designmodel.action.statue;

public class ConcreteStateError implements State {
    @Override
    public void handleState(String str) {
        System.out.println("State: error, str="+str);
    }
}
