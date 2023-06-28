package com.lujun61;

import com.lujun61.cycle.BeanCycle;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    @Test
    public void testLifeCycle() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("Spring-BeanCycle.xml");

        BeanCycle beanForLifeCycle = (BeanCycle) applicationContext.getBean("beanForLifeCycle");

        System.out.println("使用Bean：" + beanForLifeCycle);

        //如果要调用销毁方法必须用子类来声明，而不是ApplicationContext，因为ApplicationContext没有close()
        applicationContext.close();
    }
}
