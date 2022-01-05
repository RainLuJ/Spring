package com.lujun61.aspect.intfs;

import com.lujun61.entity.Student;

public interface Service {
    void doService(String s, Integer i);
    Student doAfterReturning(String s, Integer i);
    String doAround(String s, Integer i);
    void doThrowing();
    void doAfter();
}
