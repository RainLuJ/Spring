package com.lujun61.test;

import com.lujun61.entity.Student;

/**
 * @description 测试传引用数据类型的值时，不同方式的修改将会导致不同的结果
 * @author Jun Lu
 * @date 2021-12-19 13:08:32
 */
public class Test {
    public static void main(String[] args) {
        Student s = new Student(222, "wyy");
        System.out.println("s1 = " + s);

        Student t = t(s);
        System.out.println("s2 = " + s);
        System.out.println(s == t);
    }

    public static Student t(Student stu){

        stu.setId(666);  //直接对原对象属性进行修改
        /*重新创建了一个对象，并将新的对象引用覆盖了原来所存放的对象的引用
            所以原对象中的属性不会改变
            stu = new Student(111, "lj");
        */
        return stu;
    }
}


