package com.lujun61.service.impl;

import com.lujun61.dao.GoodsDao;
import com.lujun61.dao.SaleDao;
import com.lujun61.entity.Goods;
import com.lujun61.entity.Sale;
import com.lujun61.exception.NoEnoughGoodsException;
import com.lujun61.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    @Override
    public void buyGood(Integer goodsId, Integer nums) {
        //记录销售信息，向sale表中添加记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSaleRecords(sale);

        //更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if (goods == null) {
            throw new NoEnoughGoodsException("编号是：" + goodsId + "的商品不存在");
        } else if(goods.getAmount() < nums) {
            throw new NoEnoughGoodsException("编号是：" + goodsId + "的商品库存不足");
        }

        //修改库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);
    }

    public BuyGoodsServiceImpl() {
    }

    public BuyGoodsServiceImpl(SaleDao saleDao, GoodsDao goodsDao) {
        this.saleDao = saleDao;
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }
}
