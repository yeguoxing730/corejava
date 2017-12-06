package com.designmodel.createobj.staticfactory;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class ProviderImp implements Provider {
    @Override
    public Service newService() {
        return new Service(){
            @Override
            public void SayHello() {
                System.out.println("provider provide Service instance implement.Say hi to everyone.");
            }
        };
    }
}
