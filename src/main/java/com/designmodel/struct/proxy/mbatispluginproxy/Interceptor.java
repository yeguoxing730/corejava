package com.designmodel.struct.proxy.mbatispluginproxy;

/**
 * Created by yeguo on 2018/6/3.
 */
public interface Interceptor {
    Object interceptor(Invocation invocation) throws Throwable;
}
