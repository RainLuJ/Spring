不使用AOP时：

    交叉业务与主业务深度耦合在一起。当交叉业务逻辑
    较多时，在主业务代码中会出现大量的交叉业务逻辑代码调用语句，大大影响了主业务逻辑
    的可读性，降低了代码的可维护性，同时也增加了开发难度。
    所以，可以采用动态代理方式。在不修改主业务逻辑的前提下，扩展和增强其功能。



---------------------------------------------------------------------------------------------------------------------



使用aop的目的是给已经存在的一些类和方法，增加额外的功能。前提是->不改变原来的类中的代码


使用【aspectj框架】实现AOP的基本步骤：
    1、新建一个Maven项目
    2、加入依赖
        1）Spring框架依赖
        2）aspectj框架依赖
        3）junit测试单元依赖
    3、创建目标类：接口和它的实现类
       【要做的就是给类中的方法增加功能】
    4、创建切面类：普通类
        1）在类的上面加上@Aspect注解
        2）在类中定义方法，方法就是切面要执行的功能代码
        3）在方法的上面加上aspectj框架中的【通知注解】；并根据需要指定【切入点表达式execution()】
    5、创建Spring的配置文件，将对象交给Spring管理
        1）声明【目标对象】
        2）声明【切面类对象】
        3）声明aspectj框架中的【自动代理生成器】标签
        ----自动代理生成器：用来完成代理对象的自动创建功能的
    6、创建测试类：从Spring容器中获取【代理对象】；通过这个代理对象执行功能增强的方法-->实现AOP中的功能增强