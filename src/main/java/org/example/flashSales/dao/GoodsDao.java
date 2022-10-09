package org.example.flashSales.dao;

import org.example.flashSales.domain.SecKillGoods;
import org.example.flashSales.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @description: 商品dao
 */
@Mapper
public interface GoodsDao {

    /**
     * 查询所有的秒杀商品列表
     * @return
     */
    @Select("SELECT g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date FROM goods g RIGHT JOIN miaosha_goods mg ON g.id = mg.goods_id")
    List<GoodsVO> getGoodsVOs();

    /**
     * 查询单个秒杀商品详情
     * @param goodsId
     * @return
     */
    @Select("SELECT g.*, mg.miaosha_price, mg.stock_count, mg.start_date, mg.end_date FROM goods g INNER JOIN miaosha_goods mg ON g.id = mg.goods_id AND g.id = #{goodsId}")
    GoodsVO getGoodsDetailById(@Param("goodsId") Long goodsId);

    /**
     * 更新库存，解决商品超卖问题的关键所在
     * @param g
     * @return
     */
    @Update("UPDATE miaosha_goods SET stock_count = stock_count - 1 WHERE goods_id = #{goodsId} AND stock_count > 0")
    int updateStock(SecKillGoods g);
}