package com.thread.beforeafter;

//主线程等待一个子线程结束而结束
public class MainAfterAChild {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread thread = new TestThread();
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}

