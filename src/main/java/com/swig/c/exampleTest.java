package com.swig.c;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 4/26/17
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class exampleTest {
    static {
        //这里填上C++工程的名称，同时也是C++写的DLL的名称
      // System.loadLibrary("example");
        System.loadLibrary("exampleNew");
    }

    public static void main(String[] args) {
       System.out.println("测试 C对象方法调用=>" + example.fact(2));
       System.out.println("测试 C对象方法调用=>" + example.my_mod(3,4));
    }
}
