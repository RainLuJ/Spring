package com.lujun61.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description 创建这个Bean的目的是为了研究Bean的生命周期。
 * @author Jun Lu
 * @date 2022-11-04 09:35:48
 */
public class BeanCycle implements InitializingBean, DisposableBean, ApplicationContextAware {
    private String name;
    private Integer age;

    public BeanCycle() {
        System.out.println("缺省构造器 starting……");
    }

    public BeanCycle(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("set 注入 starting……");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostConstruct
    public void init2() {
        System.out.println("@PostConstruct");
    }

    @PreDestroy
    public void destory2() {
        System.out.println("@PreDestroy");
    }

    public void init() {
        //System.out.println("初始化成功---name属性为：" + this.name);
        System.out.println("init-method");
    }

    public void destory() {
        // 只有在单例模式（singleton）下，destory方法才会生效
        //System.out.println("单例对象即将被销毁---name属性为：" + this.name);
        System.out.println("destory-mothod");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }
}
