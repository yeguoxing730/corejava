package com.designmodel.chain;

public class HTMLFilter implements Filter {


    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        request.requestStr = request.requestStr.replace("<", "[").replace(">", "]") + "--HTML--";
        chain.doFilter(request, response, chain);
        response.responseStr += "--HTML--";
    }
}
