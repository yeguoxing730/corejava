package com.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThreadContextClassLoaderTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //创建自定义classloader对象。
        DiskClassLoader diskLoader = new DiskClassLoader("D:\\IDEAWorkspace\\corejava\\target\\classes");
        new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " classloader: " + Thread.currentThread().getContextClassLoader().toString());
            try {
                //加载class文件
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                Class c = cl.loadClass("com.classloader.Test");

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
        }).run();
    }
}
