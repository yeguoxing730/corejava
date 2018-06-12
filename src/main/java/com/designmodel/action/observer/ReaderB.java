package com.designmodel.action.observer;

public class ReaderB implements Observer{

    public ReaderB() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        System.out.println("我是读者B,收到了新书:"+object.toString());
    }
}
