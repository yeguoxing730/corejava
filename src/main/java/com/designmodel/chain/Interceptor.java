package com.designmodel.chain;

public interface Interceptor {
    void doInterceptor(Request request, Response response, InterceptorChain interceptorChain);
}
