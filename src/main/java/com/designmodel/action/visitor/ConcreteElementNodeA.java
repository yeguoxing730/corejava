package com.designmodel.action.visitor;

public class ConcreteElementNodeA extends ElementNode {
    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }

    public String operationA() {
        return "ConcreteElementNodeA";
    }
}
