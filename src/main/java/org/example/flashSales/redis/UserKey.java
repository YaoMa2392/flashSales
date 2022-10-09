package org.example.flashSales.redis;

/**
 * @description: 用户登录信息存储在Redis中
 */
public class UserKey extends BasePrefix{

    /**
     * Session过期时间 1天
     */
    private static final int TOKEN_EXPIRE = 3600 * 24 * 1;

    /**
     * 用户登录key
     */
    public static final UserKey userKey = new UserKey(TOKEN_EXPIRE, "token");

    public UserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}