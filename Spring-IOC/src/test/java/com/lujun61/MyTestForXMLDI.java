package com.lujun61;

import com.lujun61.bean.People;
import com.lujun61.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Arrays;
import java.util.Date;


/**
 * @description 基于【XML文件】的DI
 * @author Jun Lu
 * @date 2021-12-11 17:10:15
 */
public class MyTestForXMLDI {
    /**
     * @description 在Spring项目中使用容器对象：ApplicationContext 获取对象
     * @author Jun Lu
     * @date 2021-12-07 16:43:13
     */
    @Test
    public void test01(){
        //使用spring中的容器创建对象：
        //从【类路径】下获取spring配置文件
        ApplicationContext applicationContext = /* 在这里，【所有】对象就已经被Spring创建好了 */
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /* 从【磁盘】中获取spring配置文件
            ApplicationContext application = new FileSystemXmlApplicationContext();
        */



        // 返回的类型为Object：需要强转
        /* 获取自定的对象 */
        Object stuGet = applicationContext.getBean("student");
        Student stu = null;
        if(stuGet instanceof Student){
            stu = (Student) stuGet;
        }
        System.out.println(stu);



        /* 获取非自定的对象 */
        Object dateGet = applicationContext.getBean("myDate");
        Date date = null;
        if(stuGet instanceof Student){
            date = (Date) dateGet;
        }
        System.out.println(date);
    }


    /**
     * @description 获取Spring容器中所包含的对象的信息
     * @author Jun Lu
     * @date 2021-12-07 17:59:26
     */
    @Test
    public void test02(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //获取容器中对象的个数
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println(count);

        //获取容器中所有对象的名称
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));
    }


    /**
     * @description 设置注入（DI-DependencyInjection）————>给属性赋值：Spring通过【set】方法
     * @author Jun Lu
     * @date 2021-12-07 18:55:32
     */
    @Test
    public void test03(){
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /**
         * Spring主配置文件中【简单数据类型】的set注入
         */
        Student stu = (Student) appContext.getBean("studentDiSet");
        System.out.println("简单数据类型属性：" + stu);

        /**
         * Spring主配置文件中【引用数据类型】的set注入
         */
        People people = (People) appContext.getBean("peopleDiSet");
        System.out.println("引用数据类型属性：" + people);
    }


    /**
     * @description 设置注入（DI-DependencyInjection）————>给属性赋值：Spring通过【构造】方法
     * @author Jun Lu
     * @date 2021-12-07 21:41:28
     */
    @Test
    public void test04(){
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        /**
         * Spring主配置文件中【引用数据类型】的【构造方法】注入
         */
        People people1 = (People) appContext.getBean("peopleDiConstructorUseNameParam");
        People people2 = (People) appContext.getBean("peopleDiConstructorUseIdParam");

        System.out.println("people1：" + people1);
        System.out.println("people2：" + people2);


        /**
         * Spring主配置文件中【构造方法】使用小例子
         */
        File file = (File) appContext.getBean("file");
        System.out.println(file.getName());
        System.out.println(file.length());
    }


    /**
     * @description Spring对【引用类型属性】的自动注入
     * @author Jun Lu
     * @date 2021-12-08 14:41:09
     */
    @Test
    public void test05(){
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //byName标签属性
        People people1 = (People) appContext.getBean("peopleDiAutoByName");
        //byType标签属性
        People people2 = (People) appContext.getBean("peopleDiAutoByType");

        System.out.println("peopleDiAutoByName" + people1);
        System.out.println("peopleDiAutoByType" + people2);
    }
}