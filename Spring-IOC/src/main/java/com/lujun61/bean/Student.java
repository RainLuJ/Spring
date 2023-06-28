package com.lujun61.bean;

public class Student {
    private String name;
    private Integer age;

    public Student() {
        //System.out.println("==============Student无参构造==============");
        System.out.println("无参");
    }

    public Student(String name, Integer age) {
        //System.out.println("==============Student有参构造==============");
        this.name = name;
        this.age = age;
    }

    public void init() {
        System.out.println("初始化成功---name属性为：" + this.name);
    }

    public void destory() {
        // 只有在单例模式（singleton）下，destory方法才会生效
        System.out.println("单例对象即将被销毁---name属性为：" + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName方法执行了！！！！！");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge方法执行了！！！！！");
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
