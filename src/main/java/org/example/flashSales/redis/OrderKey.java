package org.example.flashSales.redis;

/**
 * @description: 订单存储Redis的Key
 */
public class OrderKey extends BasePrefix {

    private static int SECKILL_ORDER_EXPIRE = 3600 * 24 * 1;

    public static OrderKey secKillOrderKey = new OrderKey(SECKILL_ORDER_EXPIRE, "secKillOrder");


    public OrderKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}