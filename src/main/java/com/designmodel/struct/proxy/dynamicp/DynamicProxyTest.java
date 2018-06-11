package com.designmodel.struct.proxy.dynamicp;

public class DynamicProxyTest {
    public static void main(String[] args) {
        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();
    }
}
