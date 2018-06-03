package com.designmodel.proxy.config;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by yeguo on 2018/6/3.
 */
@Intercepts(methods = {"method1"})
public class AnnotationInteceptor implements Interceptor {
    @Override
    public Object interceptor(Invocation invocation) throws Throwable {
        Intercepts annotation = this.getClass().getAnnotation(Intercepts.class);
        if (Objects.nonNull(annotation)) {
            List<String> methods = Arrays.asList(annotation.methods());
            if (methods.contains(invocation.getMethod().getName())) {
                System.out.println(invocation.getMethod().getName() + " ：该方法可以执行拦截代理");
                System.out.println("原方法开始执行");
                //执行原方法的逻辑
                Object x = invocation.proceed();
                System.out.println("原方法执行完毕");
                return new Double(Math.random() * 10).intValue()+(int)x;
            } else {
                System.out.println(invocation.getMethod().getName() + " ：该方法不能执行代理");
                 return    invocation.proceed();
            }
        }
        return null;
    }
    public static void main(String[] args){
        Sourceable source = new Source();
        //lambda表达式貌似不能加注解，所以换成传统实现类
        Interceptor interceptor = new AnnotationInteceptor();
        Sourceable sourceable = (Sourceable) Plugin.wrap(source, interceptor);
        System.out.println("method1========="+ sourceable.method1());
        System.out.println("method2========="+ sourceable.method2(666));
    }
}
