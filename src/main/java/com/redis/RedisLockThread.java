package com.redis;
import redis.clients.jedis.Jedis;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class RedisLockThread  implements Runnable{

    RedisLockUtil util = null;
    RedisLockThread(RedisLockUtil util){
        this.util = util;
    }

    @Override
    public void run() {
        final String key = "MY.LOCK";
        final int expire = 100;
        Jedis jedis = TestRedisLock.getJedis();
        util.tryLock(jedis, key, expire);
        try {
            System.out.println("我已经拿到锁了:" + Thread.currentThread().getName());
            //停留一秒代表处理业务处理逻辑
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        util.freeLock(jedis, key);
        System.out.println(Thread.currentThread().getName() + "：执行结束");
    }
}