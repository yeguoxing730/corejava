package com.designmodel.create.singlton;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 5/19/16
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class PublicStaticObject {
    public static final PublicStaticObject instance = new PublicStaticObject();
    private PublicStaticObject(){}
    public static void main(String[] args){
            PublicStaticObject.instance.sayHello();
    }
    public void sayHello(){
       System.out.println("say hello......");
    }
}
