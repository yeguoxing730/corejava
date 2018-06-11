package com.designmodel.action.chain;

public class HtmlInterceptor implements Interceptor {
    @Override
    public void doInterceptor(Request request, Response response, InterceptorChain interceptorChain) {
        request.requestStr = request.requestStr.replace("<", "[").replace(">", "]") + "--HTML--";
        interceptorChain.doInterceptor(request, response);
        response.responseStr += "--HTML--";
    }
}
