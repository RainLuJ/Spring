package com.lujun61;

import com.lujun61.aspect.cglib.Service;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTestCGLIB {
    @Test
    public void doBefore() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象（也是代理对象）
        Service proxy = (Service) applicationContext.getBean("targetService");
        System.out.println(proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时，功能得到增强
        /**
         * com.lujun61.aspect.cglib.Service$$EnhancerBySpringCGLIB$$22697ddf
         */
        proxy.doService("hard work!", 666);
    }
}
