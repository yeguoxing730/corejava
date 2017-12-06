package com.redis.lock;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
public class IDGenerator implements Releasable{
    private static BigInteger id = BigInteger.valueOf(0);

    private final Lock lock;

    private static final BigInteger INCREMENT = BigInteger.valueOf(1);

    public IDGenerator(Lock lock) {
        this.lock = lock;
    }

    public String getAndIncrement() {
        if (lock.tryLock(3, TimeUnit.SECONDS)) {
            try {
                // TODO 这里获取到锁, 访问临界区资源
                System.out.println(Thread.currentThread().getName() + " get lock");
                String rs =     getAndIncrement0();
                DBUtil.insert(Long.valueOf(rs),Thread.currentThread().getName(),33,22);
                return rs;
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } finally {
                lock.unlock();
            }
        }
        return null;
        //return getAndIncrement0();
    }

    public void release() {
        lock.release();
    }

    private String getAndIncrement0() {
        String s = id.toString();
        id = id.add(INCREMENT);
        return s;
    }
}
