package java.java8.test;

import java.java8.FunctionalInterfaceDemo;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class FunctionalInterfaceDemoTest {
    public  static  void main(String[] args){
        FunctionalInterfaceDemo<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }
}
