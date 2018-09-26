package com.designmodel.action.statue;

public class ConcreteStateFinish implements State {
    @Override
    public void handleState(String str) {
        System.out.println("State: finish, str=" + str);
    }
}
