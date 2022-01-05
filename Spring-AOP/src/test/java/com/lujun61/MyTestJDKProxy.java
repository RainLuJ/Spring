package com.lujun61;

import com.lujun61.aspect.intfs.Service;
import com.lujun61.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTestJDKProxy {
    /**
     * @description 测试doService()
     * @author Jun Lu
     * @date 2021-12-14 22:54:22
     */
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext appC = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象（也是代理对象）
        Service proxy = (Service) appC.getBean("targetServiceImpl");
        System.out.println(proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时，功能得到增强
        proxy.doService("LJ", 18);
    }

    /**
     * @description 测试doAfterReturning()
     * @author Jun Lu
     * @date 2021-12-14 22:54:22
     */
    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext appC = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象（也是代理对象）
        Service proxy = (Service) appC.getBean("targetServiceImpl");
        System.out.println(proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时，功能得到增强
        Student lj = proxy.doAfterReturning("LJ", 18);
        System.out.println(lj);
    }


    /**
     * @description 测试doAround()
     * @author Jun Lu
     * @date 2021-12-19 15:00:33
     */
    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象（也是代理对象）
        Service proxy = (Service) applicationContext.getBean("targetServiceImpl");
        System.out.println(proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时，功能得到增强
        String luJun = proxy.doAround("LuJun", 666);
        System.out.println(luJun);
    }

    /**
     * @description 测试doThrowing()
     * @author Jun Lu
     * @date 2021-12-19 15:00:33
     */
    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象（也是代理对象）
        Service proxy = (Service) applicationContext.getBean("targetServiceImpl");
        System.out.println(proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时，功能得到增强
        proxy.doThrowing();
    }


    /**
     * @description 测试doAfter()
     * @author Jun Lu
     * @date 2021-12-19 15:00:33
     */
    @Test
    public void test05(){
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        //从容器中获取目标对象（也是代理对象）
        Service proxy = (Service) applicationContext.getBean("targetServiceImpl");
        System.out.println(proxy.getClass().getName());

        //通过代理对象执行方法，实现目标方法执行时，功能得到增强
        proxy.doAfter();
    }
}











