package com.designmodel.action.chain;

public class FilterChainTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String msg = "测试，<script>，被就业，敏感信息";
        FilterChain fc = new FilterChain();
        fc.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("response");
        fc.doFilter(request, response,fc);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
