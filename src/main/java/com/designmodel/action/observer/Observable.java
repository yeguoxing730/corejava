package com.designmodel.action.observer;

import java.util.Vector;

public abstract class Observable {

    //定义一个观察这数组
    private Vector<Observer> obVector = new Vector<>();

    //添加一个观察者
    public void addObserver(Observer observer) {
        this.obVector.add(observer);
    }

    //删除一个观察者
    public void delObserver(Observer observer) {
        this.obVector.remove(observer);
    }

    //通知所有观察者
    public void notifyObservers(Book book) {
        for (Observer observer : obVector) {
            observer.update(book);
        }
    }
}
