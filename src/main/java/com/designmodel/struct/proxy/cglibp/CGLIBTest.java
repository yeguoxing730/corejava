package com.designmodel.struct.proxy.cglibp;

public class CGLIBTest {
    public static void main(String[] args) {
        CGLibProxy cglibProxy = new CGLibProxy();
        HelloImpl he = cglibProxy.getProxy(HelloImpl.class);
        he.sayHello();
    }
}
