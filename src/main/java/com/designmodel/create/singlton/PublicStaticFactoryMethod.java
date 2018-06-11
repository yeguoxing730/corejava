package com.designmodel.create.singlton;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;

/**
 * 静态工厂方法能够保证单例 但是对于序列化需要 前后位同一对象 不仅要实现Serializable接口
 * 同时需要增加readResolve()方法
 */
public class PublicStaticFactoryMethod implements Serializable{
    private static final PublicStaticFactoryMethod instance = new PublicStaticFactoryMethod();
    private PublicStaticFactoryMethod(){}
    private PublicStaticFactoryMethod readResolve(){
        return instance;
    }
    private static PublicStaticFactoryMethod getInstance(){
            return instance;
    }
    public static void main(String[] args){
        PublicStaticFactoryMethod.getInstance().sayHello();
    }
    public void sayHello(){
        System.out.println("say hello......");
    }
}
