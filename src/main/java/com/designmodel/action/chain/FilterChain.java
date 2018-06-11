package com.designmodel.action.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
    List<Filter> fs = new ArrayList<Filter>();
    int index = 0;


    public FilterChain addFilter(Filter f) {
        fs.add(f);
        return this;
    }


    @Override
    public void doFilter(Request request, Response response,FilterChain chain) {
        if(index == fs.size()) return;
        Filter f = fs.get(index);
        index ++;
        f.doFilter(request, response, chain);
    }

}
