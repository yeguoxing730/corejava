package com.java8.test;

import com.java8.LoaclVariableLambda;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoaclVariableLambdaTest {
    static int outerStaticNumber;
    int outerNum;

    public LoaclVariableLambdaTest() {
    }

    public  static  void main(String[] args){
        int num = 1;
        LoaclVariableLambda<Integer, String> converter = (from) -> String.valueOf(from + num);
        String converted = converter.convert(123);

        System.out.println(converted);    // 123
        LoaclVariableLambdaTest loaclVariableLambdaTest = new LoaclVariableLambdaTest();
        loaclVariableLambdaTest.testScope();
    }
    void testScope(){
        LoaclVariableLambda<Integer, String> converter = (from) -> {
            outerNum = 23;
            return String.valueOf(from+outerNum);
        };
        System.out.println(converter.convert(100));
        LoaclVariableLambda<Integer, String> converter1 = (from) -> {
            outerStaticNumber = 44;
            return String.valueOf(from+outerStaticNumber);
        };
        System.out.println(converter.convert(100));
        System.out.println(converter1.convert(100));
    }
}
