package com.designmodel.template;

public class BaseShape implements Shape {
    @Override
    public float getArea() {
        System.out.println("pre log");
        float rs = doGeatArea()*1000;
        System.out.println("execute result:"+rs);
        System.out.println("after log");
        return rs;
    }
    public  float doGeatArea(){
        return 0.0f;
    }
}
