package com.designmodel.action.chain;

import java.util.ArrayList;
import java.util.List;

public class InterceptorChain {
    List<Interceptor> fs = new ArrayList<Interceptor>();
    int index = 0;

    public InterceptorChain addFilter(Interceptor f) {
        fs.add(f);
        return this;
    }

    public void doInterceptor(Request request, Response response) {
        if(index == fs.size()) return;
        Interceptor f = fs.get(index);
        index ++;
        f.doInterceptor(request, response, this);
    }
}
