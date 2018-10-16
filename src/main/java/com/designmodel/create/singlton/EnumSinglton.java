package com.designmodel.create.singlton;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
/**
 * 单例实现方式
 * 1.懒汉式 直接synchronized加锁
 * 2.双重检验锁 加锁前后校验是否创建对象 并且声明对象为volatile(防止指令重排)
 */

/**
 * 枚举实现了单例同时也保证了序列化
 */
public enum EnumSinglton {
    EnumSinglton;

    public static void main(String[] args) {
        EnumSinglton.sayHello();
    }

    public void sayHello() {
        System.out.println("say hello......");
    }
}
