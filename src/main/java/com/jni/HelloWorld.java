package com.jni;

public class HelloWorld  {


    public static native String sayHello(String name);
    public static void main(String[] args) {
        String text = sayHello("yangxin");
        System.out.println(text);
    }

    static {
        System.out.println(System.getProperty("java.library.path"));

        String libpath = System.getProperty("java.library.path");
        libpath = "C:\\dll;"+libpath;
        System.setProperty("java.library.path",libpath);
        System.out.println(System.getProperty("java.library.path"));
        System.loadLibrary("HelloWorldTest");
    }

}
