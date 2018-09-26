package com.designmodel.struct.proxy.mbatispluginproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yeguo on 2018/6/3.
 */
public class DynamicProxy implements InvocationHandler {
    Object target;

    DynamicProxy(Object object) {
        target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object val = null;
        if ("method1".equals(method.getName())) {
            System.out.println("before dynamicProxy1!");
            val = method.invoke(target, args);
            System.out.println("before dynamicProxy1!");
        } else if ("method2".equals(method.getName())) {
            System.out.println("before dynamicProxy2!");
            val = method.invoke(target, args);
            System.out.println("before dynamicProxy2!");
        }
        return val;
    }

    public static void main(String[] args) {
        Sourceable source = new Source();
        DynamicProxy dynamicProxy = new DynamicProxy(source);
        Sourceable sourceable = (Sourceable) Proxy.newProxyInstance(Source.class.getClassLoader(), Source.class.getInterfaces(), dynamicProxy);
        System.out.println("method1=========" + sourceable.method1());
        System.out.println("method2=========" + sourceable.method2(100));
    }
}
