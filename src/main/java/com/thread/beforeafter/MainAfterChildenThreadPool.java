package com.thread.beforeafter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainAfterChildenThreadPool {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int size = 5;
        ExecutorService thredPool = Executors.newFixedThreadPool(size);
        for (int i = 0; i < size; i++) {
            Thread thread = new TestThread();
            thredPool.execute(thread);
        }
        thredPool.shutdown();
        try {
            // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔10秒循环一次
            while (!thredPool.awaitTermination(10, TimeUnit.SECONDS)) ;
            //while (!thredPool.isTerminated()) //the other way
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}
