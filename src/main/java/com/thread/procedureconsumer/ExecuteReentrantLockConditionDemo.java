package com.thread.procedureconsumer;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 10/19/17
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExecuteReentrantLockConditionDemo {
    public static void main(String[] args) {
        final ReentrantLockConditionDemo rd = new ReentrantLockConditionDemo();
        // 创建1个消费者线程
        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        rd.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        // 创建10个生产者线程
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        rd.put("bread");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
