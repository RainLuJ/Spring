package com.lujun61.aspect.intfs.imple;

import com.lujun61.aspect.intfs.Service;
import com.lujun61.entity.Student;

public class ServiceImpl implements Service {
    @Override
    public void doService(String s, Integer i) {
        System.out.println("服务类方法执行了");
    }

    @Override
    public Student doAfterReturning(String s, Integer i) {
        return new Student(i, s);
    }

    @Override
    public String doAround(String s, Integer i) {
        System.out.println(s + i);
        return s + i;
    }

    @Override
    public void doThrowing() {
        System.out.println("正常");
        System.out.println("模拟异常：" + (10/0));
    }

    @Override
    public void doAfter() {
        System.out.println("正常");
        System.out.println("模拟异常：" + (10/0));
    }
}