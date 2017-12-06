package java.redis.lock;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/6/17
 * Time: 8:33 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Releasable {
    /**
     * 释放持有的所有资源
     */
    void release();
}
