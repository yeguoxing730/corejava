package com.designmodel.create.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */

/**
 * 服务接口   Service
 * 服务提供接口       Provider
 * 服务提供者提供实现          ProviderImp
 * 服务管理者 提供服务提供者实现的注册 和 服务实例的生成维护 ProviderManager
 * <p>
 * JDBC接口就是以这种方式
 */
public class StaticFactoryMethodTest {
    public static void main(String[] args) {
        //以静态工厂方法实现的服务提供者框架
        ProviderManager.registerProvider(new ProviderImp());
        Service service = ProviderManager.getService();
        service.SayHello();
        //简单直观的通过静态工厂方法来创建实例 易于阅读代码
        StaticFactoryMethodObj staticFactoryMethodObj = StaticFactoryMethodObj.getStaticFactoryMethodObj();
        staticFactoryMethodObj.sayHi();
    }
}
