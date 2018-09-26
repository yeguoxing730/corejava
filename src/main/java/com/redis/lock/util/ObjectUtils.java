package com.redis.lock.util;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/12/17
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectUtils {
    public static void requireNonNull(Object... obj) {
        if (obj.length % 2 != 0) {
            throw new IllegalArgumentException("arguments's length mod 2 must be 0.");
        }

        for (int i = 0; i < obj.length; i += 2) {
            if (obj[i] == null) {
                throw new NullPointerException(obj[i + 1].toString());
            }
        }
    }

    public static <T> T requiredNonNull(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return object;
    }
}
