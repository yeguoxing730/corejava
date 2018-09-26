package com.designmodel.struct.proxy.mbatispluginproxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by yeguo on 2018/6/3.
 */
public class Invocation {
    private Method method;
    private Object[] args;
    private Object target;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return this.method.invoke(this.target, this.args);
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Invocation{" +
                "method=" + method +
                ", args=" + Arrays.toString(args) +
                ", target=" + target +
                '}';
    }
}
