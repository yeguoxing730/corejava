package lock;

import com.redis.lock.util.LockInfo;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/12/17
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class LockInfoTest {
    @Test
    public void test() {
        LockInfo li = new LockInfo();

        li.setCount(1);
        li.setExpires(Long.MAX_VALUE);
        li.setMac("127.0.0.1");
        li.setJvmPid(11);
        li.setThreadId(Thread.currentThread().getId());

        System.out.println(li.toString());
    }

}
