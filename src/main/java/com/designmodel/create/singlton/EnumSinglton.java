package com.designmodel.create.singlton;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * 枚举实现了单例同时也保证了序列化
 */
public enum EnumSinglton {
    EnumSinglton;
    public static void main(String[] args){
        EnumSinglton.sayHello();
    }
    public void sayHello(){
        System.out.println("say hello......");
    }
}
