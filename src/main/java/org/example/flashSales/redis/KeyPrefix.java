package org.example.flashSales.redis;

/**
 * @description: Redis存储key前缀接口，包含两个方法，分别获取过期时间和key前缀
 */
public interface KeyPrefix {

    /**
     * 获取过期时间
     * @return
     */
    int expireSeconds();

    /**
     * 获取key的前缀，用于标识不同的业务的key
     * @return
     */
    String getPrefix();
}