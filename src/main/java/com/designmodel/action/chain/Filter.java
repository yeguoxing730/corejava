package com.designmodel.action.chain;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
