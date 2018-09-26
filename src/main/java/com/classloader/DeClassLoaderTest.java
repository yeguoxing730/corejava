package com.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeClassLoaderTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //异或class文件
        FileUtils.test("D:\\IDEAWorkspace\\corejava\\target\\classes\\com\\classloader\\Test.class");
        //创建自定义classloader对象。
        DeClassLoader diskLoader = new DeClassLoader("D:\\IDEAWorkspace\\corejava\\target\\classes");

        try {
            //通过我们自定义的加载器加载class文件
            Class c = diskLoader.loadClass("com.classloader.Test");

            if (c != null) {
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say", null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
