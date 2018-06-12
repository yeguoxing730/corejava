package com.designmodel.action.vistor;

public class ConcreteVisitorA implements Vistor {
    @Override
    public void visit(ConcreteElementNodeA node) {
        System.out.println(node.operationA());
    }

    @Override
    public void visit(ConcreteElementNodeB node) {
        System.out.println(node.operationB());
    }
}
