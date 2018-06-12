package com.designmodel.action.expression;

public class Variable implements Expression {
    @Override
    public int interpret(Context context) {
        return context.LookupValue(this);
    }
}
