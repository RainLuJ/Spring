package com.lujun61;

import com.lujun61.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        BuyGoodsService service = (BuyGoodsService) applicationContext.getBean("buyGoodsService");
        System.out.println("service类型：" + service.getClass().getName());
        service.buyGood(1001, 1000000);




    }
}
