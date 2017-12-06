package com.designmodel.createobj.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * 静态工厂方法 提供的是类似构造器的功能 创建这个对象 不过是以一种方便阅读的方式来创建对象
 * 给人的感觉是看其意思即知道他要创建对象 而不是用构造函数那样创建对象 不够直观
 *
 * 服务提供者框架 就是用静态工厂方法类实现更加开放的对象的使用 与对象创建和实现的分离
 * jdbc 就是服务提供者框架的一个实现
 */
public class StaticFactoryMethodObj {
    private StaticFactoryMethodObj(){}
    public static StaticFactoryMethodObj getStaticFactoryMethodObj(){
        return  new StaticFactoryMethodObj();
    }
    public static StaticFactoryMethodObj getInstance(){
        return  new StaticFactoryMethodObj();
    }
    public void sayHi(){
        System.out.println("hi,every body.");
    }
}
