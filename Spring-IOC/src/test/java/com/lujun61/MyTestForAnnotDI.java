package com.lujun61;

import com.lujun61.annotation.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description 基于【注解】的DI
 * @author Jun Lu
 * @date 2021-12-11 17:10:15
 */
public class MyTestForAnnotDI {
    @Test
    public void test01(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        People peo1 = (People) applicationContext.getBean("myPeople");
        System.out.println(peo1);
    }
}













