package com.designmodel.proxy.config;

/**
 * Created by yeguo on 2018/6/3.
 */
public class Source implements Sourceable {
    @Override
    public int method1() {
        System.out.println("execute method one");
        return 200;
    }

    @Override
    public int method2(int x) {
        System.out.println("execute method two"+(233+x));
        return 233+x;
    }
}
