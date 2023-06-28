package com.lujun61.service.impl;

import com.lujun61.dao.GoodsDao;
import com.lujun61.dao.SaleDao;
import com.lujun61.entity.Goods;
import com.lujun61.entity.Sale;
import com.lujun61.exception.NoEnoughGoodsException;
import com.lujun61.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    /**
     * 加上rollbackFor属性之后，Spring管理事务的处理逻辑：
     *     1）Spring会首先检查方法抛出的异常是不是在rollbackFor属性中；
     *        如果异常在rollbackFor的列表之中，且只要是Throwable的子类异常，一定会回滚！不管是受检还是非受检
     *     2）如果抛出的异常不在rollbackFor列表之中，
     *        Spring会判断异常是不是RuntimeException或者Error；如果是，一定rollback。
     *        如果是受检异常，则直接提交。（王八的屁股！！！）
     */
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            readOnly = false,
            rollbackFor = {
                    NoEnoughGoodsException.class, NullPointerException.class, IOException.class
            }
    )

    /* @Transactional注解默认使用的默认值：
    *     propagation：默认的传播行为是REQUIRED，
    *     isolation：默认的隔离级别是DEFAULT
    *     rollbackFor：默认在抛出RuntimeException时，回滚事务
    *  */
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
