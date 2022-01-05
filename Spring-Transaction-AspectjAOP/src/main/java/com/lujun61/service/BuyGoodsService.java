package com.lujun61.service;

public interface BuyGoodsService {
    /**
     * @param id 购买商品的编号
     * @param nums 购买的数量
     * @description 购买商品的方法
     * @author Jun Lu
     * @date 2021-12-23 20:08:16
     */
    void buyGood(Integer id, Integer nums);
}
