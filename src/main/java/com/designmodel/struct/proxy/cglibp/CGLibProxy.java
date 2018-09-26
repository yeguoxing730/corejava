package com.designmodel.struct.proxy.cglibp;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {

        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }


    public void before() {
        System.out.println("before....");
    }

    public void after() {
        System.out.println("after...");
    }
}
