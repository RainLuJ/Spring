Spring项目实现步骤：
    1、创建Maven项目
    2、加入依赖：
           加入Maven基本依赖
           加入Spring依赖
           加入junit单元测试依赖
    3、在resources包中创建Spring主配置文件（.xml）


                ***** DI是ioc的技术实现，DI（Dependency Injection）:依赖注入 *****
在Spring主配置文件中给对象赋值（DI——>依赖注入-表示创建对象，并给对象赋值）：
    方法一：在Spring配置文件中，依赖【标签】和【标签属性】完成，叫做基于XML的DI实现
    方法二：使用Spring中的【注解】，完成属性赋值，叫做基于注解的DI实现

    使用场景：
        需要经常改动的属性就用XML做DI实现
        不需要经常改动的属性就用注解做DI实现

DI实现的语法分类：
    1、set注入（常用）：Spring通过调用类的set方法，在set方法中可以实现属性的赋值
    2、构造注入：Spring通过调用类的有参数构造方法，创建对象；并在构造方法中完成属性的赋值