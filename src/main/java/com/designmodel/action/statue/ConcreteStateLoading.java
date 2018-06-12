package com.designmodel.action.statue;

public class ConcreteStateLoading implements State {
    @Override
    public void handleState(String str) {
        System.out.println("State: loading, str="+str);
    }
}
