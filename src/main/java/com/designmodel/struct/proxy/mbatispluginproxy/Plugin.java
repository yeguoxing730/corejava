package com.designmodel.struct.proxy.mbatispluginproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yeguo on 2018/6/3.
 */
public class Plugin implements InvocationHandler {
    private Interceptor interceptor;
    private Object target;
    private Plugin(Object object, Interceptor interceptor){
        super();
        this.interceptor = interceptor;
        this.target = object;
    }
    public static Object wrap(Object target,Interceptor interceptor){
        Class<?> type = target.getClass();
        Class<?>[] intfacs = target.getClass().getInterfaces();
        return intfacs.length>0? Proxy.newProxyInstance(type.getClassLoader(),intfacs,new Plugin(target,interceptor)):target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.interceptor(new Invocation(target,method,args));
    }
    public static void main(String[] args) {
        Sourceable source = new Source();
        Interceptor interceptor =  (invocation)->{
            System.out.println("原方法开始执行");
            //执行原方法的逻辑
            Object x = invocation.proceed();
            System.out.println("原方法执行完毕");
            return new Double(Math.random() * 10).intValue()+(int)x;
        };
        Sourceable sourceable = (Sourceable) Plugin.wrap(source, interceptor);

        System.out.println("method1========="+sourceable.method1());
        System.out.println("method2========="+sourceable.method2(200));

    }
}
