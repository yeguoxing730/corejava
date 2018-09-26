package com.designmodel.create.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 10:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProviderManager {
    private static Provider staticProvider;

    public static void registerProvider(Provider provider) {
        staticProvider = provider;
    }

    public static Service getService() {
        return staticProvider.newService();
    }
}
