package com.redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class RedisLockUtil {
    /**
     * 是否有正在等待竞争锁线程
     */
    private volatile boolean hasWaitThread = false;
    /**
     * 持有锁的线程
     */
    private volatile Thread holdLockThread;

    /**
     * 尝试获得锁的次数
     */
    private AtomicInteger tryTimes = new AtomicInteger(0);

    private final int MAX_TRY_TIMES = 100;

    /**
     * 获得redis锁
     *
     * @param key    锁的主键
     * @param expire 锁的过期时间
     * @author zcd
     * @since 2017年4月25日
     */
    public void tryLock(String key, int expire) {
        this.tryLock(null, key, expire);
    }

    /**
     * 获得redis锁
     *
     * @param jedis  redis连接
     * @param key    锁的主键
     * @param expire 锁的过期时间
     * @author zcd
     * @since 2017年4月25日
     */
    public void tryLock(Jedis jedis, String key, int expire) {
        boolean locked = (jedis == null ? getLock(key, expire) : getLock(jedis, key, expire));
        while (!locked) {
            try {
                //已经有正在等待的线程&持有锁的线程不为空
                if (hasWaitThread && holdLockThread != null) {
                    synchronized (holdLockThread) {
                        //等待持有锁的线程执行notifyAll
                        holdLockThread.wait(expire);
                    }
                } else {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            locked = (jedis == null ? getLock(key, expire) : getLock(jedis, key, expire));
            tryTimes.incrementAndGet();
        }
    }

    /**
     * 释放redis锁，通知通知其他等待线程
     *
     * @param key 锁的key
     * @return
     * @author zcd
     * @since 2017年4月25日
     */
    public boolean freeLock(String key) {
        Jedis jedis = TestRedisLock.getJedis();
        try {
            return jedis.del(key) > 0;
        } finally {
            doFinally(jedis);
        }
    }

    /**
     * 释放redis锁，同时释放jedis连接，通知通知其他等待线程
     *
     * @param jedis
     * @param key
     * @return
     * @author zcd
     * @since 2017年4月25日
     */
    public boolean freeLock(Jedis jedis, String key) {
        try {
            return jedis.del(key) > 0;
        } finally {
            doFinally(jedis);
        }
    }

    /**
     * 从redis获得含有有效时间的锁
     *
     * @param key    锁的主键
     * @param expire 过期时间
     * @return
     * @author zcd
     * @since 2017年4月25日
     */
    private boolean getLock(String key, int expire) {
        Jedis jedis = TestRedisLock.getJedis();
        try {
            return getLock(jedis, key, expire);
        } finally {
            jedis.close();
        }
    }

    /**
     * 从redis获得含有有效时间的锁
     *
     * @param jedis
     * @param key
     * @param expire
     * @return
     * @author zcd
     * @since 2017年4月25日
     */
    private boolean getLock(Jedis jedis, String key, int expire) {
        //失败:0, 成功:1
        long locked = jedis.setnx(key, String.valueOf(expire));
        //解决死锁
        solveDeadLock(jedis, key, expire);
        if (locked == 1) {
            //设置持有redis锁的线程&设置线程等待的标识
            this.holdLockThread = Thread.currentThread();
            this.hasWaitThread = true;
            tryTimes.set(0);
            jedis.expire(key, expire);
            return true;
        }
        return false;
    }

    /**
     * 解决用于redis服务器宕机发生的死锁现象,关闭jedis
     *
     * @param key
     * @param expire
     * @author zcd
     * @since 2017年4月25日
     */
    private void solveDeadLock(String key, int expire) {
        Jedis jedis = TestRedisLock.getJedis();
        try {
            this.solveDeadLock(jedis, key, expire);
        } finally {
            jedis.close();
        }
    }

    /**
     * 解决用于redis服务器宕机发生的死锁现象
     *
     * @param jedis  redis连接
     * @param key    锁的主键
     * @param expire 过期时间
     * @author zcd
     * @since 2017年4月25日
     */
    private void solveDeadLock(Jedis jedis, String key, int expire) {
        //判断尝试获得锁的次数
        if (tryTimes.get() < MAX_TRY_TIMES) {
            return;
        }
        if (jedis == null) {
            solveDeadLock(key, expire);
            return;
        }
        Long ttl = jedis.ttl(key);
        //锁的过期时间大于0 并且redis中的锁过期时间是 -1 或是小于0，那么说明此锁会产生死锁，直接删除
        if (ttl < 0 || expire > 0) {
            jedis.del(key);
            doReset();
        }
        tryTimes.set(MAX_TRY_TIMES);
    }

    /**
     * 执行finally中逻辑操作
     *
     * @param jedis
     * @author zcd
     * @since 2017年4月25日
     */
    private void doFinally(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
        doReset();
    }

    private void doReset() {
        hasWaitThread = false;
        holdLockThread = null;
        System.out.println(Thread.currentThread().getName() + " : 释放锁，通知等待线程");
        //唤醒所有等待锁的线程
        synchronized (Thread.currentThread()) {
            Thread.currentThread().notifyAll();
        }
    }
}
