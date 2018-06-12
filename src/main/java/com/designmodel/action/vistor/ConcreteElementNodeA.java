package com.designmodel.action.vistor;

public class ConcreteElementNodeA extends ElementNode {
    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }

    public String operationA() {
        return "ConcreteElementNodeA";
    }
}
