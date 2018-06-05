package com.designmodel.template;

public class TemplateTest {
    public static void main(String[] args){
        Shape shape = new Cycle();
        shape.getArea();
        shape = new Square();
        shape.getArea();
    }
}
