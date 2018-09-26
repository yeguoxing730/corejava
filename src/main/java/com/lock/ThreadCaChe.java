package com.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadCaChe {

    private static Map<String, Object> cacheMap = new HashMap<String, Object>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String obj = (String) getData("andy");
                    System.out.println(obj);
                }
            }).start();

        }

    }


    public static Object getData(String key) {

        ReadWriteLock rwlLock = new ReentrantReadWriteLock();
        // 先加读锁
        rwlLock.readLock().lock();
        Object value = null;
        try {
            value = cacheMap.get(key);
            // 若不存在cache中
            if (value == null) {
                // 若果value为空 则释放掉读锁，让该线程获取写锁，而其他线程只能等待该写锁释放，才能在进读锁
                rwlLock.readLock().unlock();
                // 加写锁
                rwlLock.writeLock().lock();

                try {
                    if (value == null) {
                        // 从数据中获取数据
                        value = "andy is shuai ge" + (new Random()).nextInt(100);// 查询数据库
                        // 存入缓存中
                        cacheMap.put(key, value);
                    }
                } finally {
                    rwlLock.writeLock().unlock();
                }

                rwlLock.readLock().lock();
            }

        } finally {
            // 释放第一次获取的读锁
            rwlLock.readLock().unlock();
        }

        return value;
    }
}
