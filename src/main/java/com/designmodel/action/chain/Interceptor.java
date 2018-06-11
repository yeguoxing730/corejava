package com.designmodel.action.chain;

public interface Interceptor {
    void doInterceptor(Request request, Response response, InterceptorChain interceptorChain);
}
