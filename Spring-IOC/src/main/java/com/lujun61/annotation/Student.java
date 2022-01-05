package com.lujun61.annotation;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myStudent")
public class Student {
    @Value("XiaoLu")
    private String name;

    @Value("15")
    private Integer age;

    public Student() {
        //System.out.println("==============Student无参构造==============");
    }

    public Student(String name, Integer age) {
        //System.out.println("==============Student有参构造==============");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //System.out.println("setName方法执行了！！！！！");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        //System.out.println("setAge方法执行了！！！！！");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
