package com.designmodel.struct.proxy.cglibp;

import net.sf.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

public class BookFacadeCGLIB implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback((Callback) this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, net.sf.cglib.proxy.MethodProxy methodProxy) throws Throwable {
        System.out.println("事物开始");
        Object proxyObj = methodProxy.invokeSuper(o, objects);
        System.out.println("事物结束");
        return proxyObj;
    }
}
