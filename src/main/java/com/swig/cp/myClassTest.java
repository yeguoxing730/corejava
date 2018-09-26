package com.swig.cp;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/26/17
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class myClassTest {
    static {
        //这里填上C++工程的名称，同时也是C++写的DLL的名称
        System.loadLibrary("myclass");
    }

    public static void main(String[] args) {
        IntVector intVector = new IntVector(12);
        intVector.set(1, 10);
        System.out.println("测试 C++对象方法调用=>" + intVector.get(1));
    }
}
