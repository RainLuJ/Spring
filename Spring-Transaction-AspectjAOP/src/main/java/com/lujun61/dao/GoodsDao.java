package com.lujun61.dao;

import com.lujun61.entity.Goods;

public interface GoodsDao {
    /* 更新库存 */
    //goods表示用户购买的商品信息
    int updateGoods(Goods goods);

    /* 查询商品的信息 */
    Goods selectGoods(Integer id);
}