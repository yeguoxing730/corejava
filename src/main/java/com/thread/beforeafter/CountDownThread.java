package com.thread.beforeafter;

import java.util.concurrent.CountDownLatch;

public class CountDownThread extends Thread {
    private CountDownLatch countDownLatch;
    public CountDownThread(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        System.out.println(this.getName() + "子线程开始");
        try {
            // 子线程休眠五秒
            System.out.println(this.getName() +"执行任务");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "子线程结束");
        countDownLatch.countDown();
    }
}
