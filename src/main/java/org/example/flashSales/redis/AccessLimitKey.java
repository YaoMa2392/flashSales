package org.example.flashSales.redis;

/**
 * @description: 接口限流的Key
 */
public class AccessLimitKey extends BasePrefix {

    /**
     * 接口访问限流次数key
     */
    private static final String ACCESS_PREFIX = "access_limit_key";

    public static AccessLimitKey getAccessKeyWithExpire(int expireSeconds) {
        return new AccessLimitKey(expireSeconds, ACCESS_PREFIX);
    }


    private AccessLimitKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}