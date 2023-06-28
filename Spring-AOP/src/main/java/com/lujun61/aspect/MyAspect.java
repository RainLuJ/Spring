package com.lujun61.aspect;

import com.lujun61.entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @description 自定义切面类
 * @author Jun Lu
 * @date 2021-12-12 20:33:23
 */

/**
 * Aspect注解：
 *     来源：是aspectj框架中的注解
 *     作用：表示/标志当前类是【切面类】        （交叉业务逻辑）
 *          ---切面类：是用来给业务方法【增加功能】的类，在这个类中有切面的功能的代码
 *     属性：
 *     使用位置：在类定义的上面
 */
@Aspect
public class MyAspect {
    /**
     * Before注解：
     *      来源：是aspectj框架中的注解
     *      作用：前置通知
     *      属性：value，是【切入点表达式】，表示切面功能的执行的【位置】->接口实现类中的方法
     *      位置：在方法上面
     * 特点：
     *      1、在目标方法【之前】先执行的
     *      2、不会改变目标方法的执行结果
     *      3、不会影响目标方法的执行
     */
    //@Before(value = "execution(public void com.lujun61.aspect.intfs.imple.ServiceImpl.doService())")
    @Before(value = "execution(* *..intfs.imple.ServiceImpl.doService(..))")
    /**
     * 前置通知方法定义格式：这个方法是用来实现切面功能的
     * 方法的定义要求：
     *      1、公共方法public
     *      2、方法没有返回值
     *      3、方法名称自定义
     *      4、方法可以有参数，也可以没有参数
     *          -->如果有参数，参数不是自定义的，只能使用规定好了的【参数类型】
     *//**
     * 方法中的参数：JoinPoint
     * JoinPoint：指可以被切面织入的具体方法（【单数】）。通常业务接口中的方法均为连接点。
     *      作用是：可以在【通知(advice)方法】中获取方法执行时的信息。例如：方法名称，方法的形参……
     *      如果你的切面功能中需要用到【方法的信息】，就加上JoinPoint参数
     *      这个JoinPoint参数的值是由框架赋予的，而且必须是【第一个位置】的参数
     *      注意：如果有需要，在 【所有的通知方法】 中都可以使用这个参数
     */
    public void myBefore(JoinPoint jp){
        //获取方法的完整定义
        System.out.println("方法的签名（定义）：" + jp.getSignature());

        //获取方法的名称
        System.out.println("方法的名称：" + jp.getSignature().getName());

        //获取方法的实参
        Object[] args = jp.getArgs();
        for (Object arg :
                args) {
            System.out.println("参数：" + arg);
        }
        System.out.println("前置通知");
    }

    /**
     * AfterReturning注解：
     *    来源：是aspectj框架中的注解
     *    作用：后置通知
     *    属性：
     *      1、value：切入点表达式
     *      2、returning：自定义的变量，表示【目标方法】的【返回值】
     *          -->自定义变量名必须和【通知方法】的形参名一样
     *    位置：在方法定义的上面
     *    特点：
     *      1、在目标方法之后执行的
     *      2、能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
     *      3、可以修改这个返回值
     */
    //execution(* *..ServiceImpl.do*(..))
    @AfterReturning(value = "execution(* *..ServiceImpl.doAfterReturning(..))",
                    returning = "res")
    /**
     * 后置通知方法定义格式：这个方法是用来实现切面功能的
     * 方法的定义要求：
     *      1、公共方法public
     *      2、方法没有返回值
     *      3、方法名称自定义
     *      4、方法有参数
     *       --->参数类型推荐为Object；参数名自定义
     *       --->也可以使用JoinPoint获取方法信息
     */
    public void myAfterReturning(Object res){
        //Object res：是目标方法执行后的返回值，根据返回值做你的切面的处理功能
        System.out.println("后置通知；获取到的返回值是：" + res);

        //修改返回值
        Student stu = (Student) res;
        stu.setId(2);
        System.out.println("后置通知；返回值res是：" + res);
        System.out.println("后置通知；返回值stu是：" + stu);
    }


    /**
     * Around注解：
     *     来源：是aspectj框架中的注解
     *     作用：环绕通知
     *     属性：
     *          1、value：切入点表达式
     *     位置：在方法定义的上面
     *     特点：
     *          1、它是功能最强的通知
     *          2、在目标方法 之前、之后 都能增强功能
     *          3、能控制目标方法是否能被调用执行
     *          4、能修改原来目标方法的调用结果
     *
     *     （环绕通知就等同于JDK动态代理中的：InvocationHandler接口实现类）
     *     【环绕通知经常被用来做 事务 】
     */
    @Around(value = "myPointCutForDoAround()")
    /**
     * 环绕通知方法定义格式：这个方法是用来实现切面功能的
     * 方法的定义要求：
     *      1、公共方法public
     *      2、方法必须有一个返回值；类型推荐为Object
     *      3、方法名称自定义
     *      4、方法有参数
     *       --->固定的：ProceedingJoinPoint
     *           就等同于JDK动态代理中InvocationHandler接口实现类中的Method参数
     *           作用：执行目标方法
     */
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        String res = null;

                          /* 在目标方法之前执行 */
        System.out.println("环绕通知：在方法执行之前增强功能");

                        /* 控制目标方法能否被执行 */
        if ("LuJun".equals(pjp.getArgs()[0])) {
            //如果方法得到的第一个参数等于规定的值，就调用执行目标方法
            Object targetRes = pjp.proceed();

                          /* 修改目标方法执行后的返回结果 */
            res = (String) targetRes;
            if (res != null) {
                res = "修改了目标方法的返回值：hhhhhhhhhhh";
            }
        }

                          /* 在目标方法之后执行 */
        System.out.println("环绕通知：在方法执行之后增强功能");

        return res;
    }


    /**
     * AfterThrowing注解：
     *     来源：是aspectj框架中的注解
     *     作用：异常通知
     *     属性：
     *          1、value：切入点表达式
     *          2、throwing：自定义的变量，表示目标方法中抛出的异常对象
     *           --->变量名必须和通知方法的形参名一样
     *     位置：在方法定义的上面
     *     特点：
     *          1、在目标方法抛出异常时执行的
     *          2、可以做异常的监控程序，监控目标方法执行时是不是有异常
     *           --->如果有异常，可以发送通知信息
     */
    @AfterThrowing(value = "execution(* *..ServiceImpl.doThrowing(..))",
                   throwing = "exc")
    /**
     * 异常通知方法定义格式：这个方法是用来实现切面功能的
     * 方法的定义要求：
     *      1、公共方法public
     *      2、没有返回值
     *      3、方法名称自定义
     *      4、方法有参数
     *       --->固定的：Exception
     *           作用：获取目标方法抛出的异常对象
     *         如果还有参数，就是JoinPoint
     */
    public void myThrowing(Exception exc) {
        //System.out.println("异常");
        System.out.println("异常通知，发生异常时执行：" + exc.getMessage());
    }


    /**
     * After注解：
     *     来源：是aspectj框架中的注解
     *     作用：最终通知
     *     属性：
     *          1、value：切入点表达式
     *     位置：在方法定义的上面
     *     特点：
     *          1、一定会执行：有异常也会执行
     *          2、在目标方法之后执行
     *
     *    【一般用来做资源的关闭工作】
     */
    @After(value = "execution(* *..ServiceImpl.doAfter(..))")
    /**
     * 最终通知方法定义格式：这个方法是用来实现切面功能的
     * 方法的定义要求：
     *      1、公共方法public
     *      2、没有返回值
     *      3、方法名称自定义
     *      4、方法没有参数；但是可以写上JoinPoint
     */
    public void myAfter() {
        System.out.println("就算程序有异常，这里的增强功能也会被执行！");
    }


    /**
     * Pointcut注解：
     *     来源：是aspectj框架中的注解
     *     作用：定义和管理[切入点]，让项目中的【切入点表达式】不再冗余表示
     *     属性：
     *          1、value：切入点表达式
     *     位置：在方法定义的上面
     */
    @Pointcut(value = "execution(* *..ServiceImpl.doAround(..))")
    /**
     * 方法内部无需代码；方法名就代表了value中的切入点表达式
     * 方法一般是【private】的；因为只是内部的一个辅助功能代码，不需要被外界调用
     */
    private void myPointCutForDoAround() {

    }
}












