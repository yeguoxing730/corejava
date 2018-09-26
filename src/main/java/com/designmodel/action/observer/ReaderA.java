package com.designmodel.action.observer;

public class ReaderA implements Observer {

    public ReaderA() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        System.out.println("我是读者A,收到了新书:" + object.toString());
    }

}
