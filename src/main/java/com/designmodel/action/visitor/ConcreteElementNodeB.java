package com.designmodel.action.visitor;

public class ConcreteElementNodeB extends ElementNode {
    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }

    public String operationB() {
        return "ConcreteElementNodeB";
    }
}
