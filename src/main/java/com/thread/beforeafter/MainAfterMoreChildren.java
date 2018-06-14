package com.thread.beforeafter;

import java.util.ArrayList;
import java.util.List;

public class MainAfterMoreChildren {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> list = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new TestThread();
            thread.start();
            list.add(thread);
        }
        try {
            for (Thread thread : list) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长：" + (end - start));
    }
}
