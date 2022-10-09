package org.example.flashSales.redis;

/**
 * @description: 商品相关的Redis存储key
 */
public class GoodsKey extends BasePrefix {

    /**
     * 商品库存key
     */
    public static final GoodsKey goodsStockKey = new GoodsKey(0, "goodsStock");
    /**
     * 商品秒杀活动是否结束key
     */
    public static final GoodsKey goodsSecKillOverKey = new GoodsKey(0, "goodsSecKillIsOver");

    public GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}