package lock;

import com.redis.lock.util.PlatformUtils;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/12/17
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class PlatformTest {

    @Test
    public void test() {
        System.out.println(PlatformUtils.MACAddress());
    }

}
