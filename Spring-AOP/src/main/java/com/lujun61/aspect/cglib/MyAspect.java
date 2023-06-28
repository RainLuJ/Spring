package com.lujun61.aspect.cglib;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    //@Before(value = "execution(* *..Service.doService(..) throws NullPointerException)")
    @Before(value = "execution(* *..Service.doService(..) throws NullPointerException)")
    public void doBeforeCGLIB() {
        System.out.println("前置通知！");
    }
}