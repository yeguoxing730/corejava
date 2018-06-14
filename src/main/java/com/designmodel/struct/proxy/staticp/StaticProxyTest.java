package com.designmodel.struct.proxy.staticp;

public class StaticProxyTest {
    public static void main(String[] args) {
        com.designmodel.proxycp.CountImpl countImpl = new com.designmodel.proxycp.CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();

    }
}
