package com.designmodel.action.observer;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Library library = new Library();
        Observer readerAObserver = new ReaderA();
        Observer readerBObserver = new ReaderB();
        //添加读者A
        library.addObserver(readerAObserver);
        //添加读者B
        library.addObserver(readerBObserver);
        //添加一本新书
        Book book = new Book("朝花夕拾", "鲁迅");
        library.addBook(book);
    }
}
/**
 * 状态模式是策略模式的孪生兄弟，是因为它们的UML图是一样的，但意图却完全不一样，
 * 策略模式是让用户指定更换的策略算法，而状态模式是状态在满足一定条件下的自动更换，
 * 用户无法指定状态，最多只能设置初始状态
 *
 */
