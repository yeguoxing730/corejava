package com.java8.test;

import com.java8.DefaultFormulaInterface;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultFormulaInterfaceTest {
    public static void main(String[] args) {
        DefaultFormulaInterface formula = new DefaultFormulaInterface() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(16));
    }
}
