package com.designmodel.action.chain;

public class SensitiveFilter implements Filter {


    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        request.requestStr = request.requestStr.replace("被就业", "就业").replace("敏感", "**") + "--Sensitive--";
        chain.doFilter(request, response, chain);
        response.responseStr += "--Sensitive--";
    }
}
