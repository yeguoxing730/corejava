package com.thread.beforeafter;

import java.util.concurrent.CountDownLatch;

public class MainAfterChildenCountDownLatch {
    public static void main(String[] args) {
        int size = 5;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            CountDownThread thread = new CountDownThread(countDownLatch);
            thread.start();
        }
        try {
            // 阻塞当前线程，直到倒数计数器倒数到0
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}
