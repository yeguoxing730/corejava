/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.swig.c;

public class example {
    public static void setMy_variable(double value) {
        exampleJNI.My_variable_set(value);
    }

    public static double getMy_variable() {
        return exampleJNI.My_variable_get();
    }

    public static int fact(int n) {
        return exampleJNI.fact(n);
    }

    public static int my_mod(int x, int y) {
        return exampleJNI.my_mod(x, y);
    }

}
