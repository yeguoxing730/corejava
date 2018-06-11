package com.designmodel.action.chain;

public class SensitiveInterceptor implements Interceptor {
    @Override
    public void doInterceptor(Request request, Response response, InterceptorChain interceptorChain) {
        request.requestStr = request.requestStr.replace("被就业", "就业").replace("敏感", "**") + "--Sensitive--";
        interceptorChain.doInterceptor(request, response);
        response.responseStr += "--Sensitive--";
    }
}
