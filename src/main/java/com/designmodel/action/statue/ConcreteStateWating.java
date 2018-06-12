package com.designmodel.action.statue;

public class ConcreteStateWating implements State {
    @Override
    public void handleState(String str) {
        System.out.println("State: wating, str="+str);
    }
}
