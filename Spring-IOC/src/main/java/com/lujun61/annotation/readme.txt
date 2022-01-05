src/main/java/com/lujun61/annotation包中存放着：【基于注解的DI实体类】

实现步骤：
    1、加入依赖
    2、创建类，在类中加入注释
    3、在Spring配置文件中声明【组件扫描器对象】
        目的是：扫描指定包中的所有类，找到类中的所有注解；按照注解的功能创建对象、给对象赋值
    4、创建容器ApplicationContext，来使用注解DI创建对象