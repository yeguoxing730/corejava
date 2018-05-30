package com.designmodel.chain;

public class InterceptorChainTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String msg = "测试，<script>，被就业，敏感信息";
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addFilter(new HtmlInterceptor()).addFilter(new SensitiveInterceptor());
        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("response");
        interceptorChain.doInterceptor(request, response);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
