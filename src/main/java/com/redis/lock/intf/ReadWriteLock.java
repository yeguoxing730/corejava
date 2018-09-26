package com.redis.lock.intf;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/11/17
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ReadWriteLock {
    /**
     * 获取读锁
     *
     * @return
     */
    ReleaseLock readLock();

    /**
     * 获取写锁
     *
     * @return
     */
    ReleaseLock writeLock();
}
