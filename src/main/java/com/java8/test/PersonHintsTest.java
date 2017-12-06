package com.java8.test;

import com.java8.Hint;
import com.java8.Hints;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 6/27/16
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Hints({@Hint("hint1"), @Hint("hint2")})
public class PersonHintsTest {
    public static void main(String[] args){
       Hint hint =  PersonHintsTest.class.getAnnotation(Hint.class);
       System.out.println(hint);
//       Hints hints1 = PersonHintsTest.class.getAnnotation(Hints.class);
//       System.out.println(hints1.value().length);  // 2
        Hint[] hints2 = PersonHintsTest.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);          // 2

    }
}
