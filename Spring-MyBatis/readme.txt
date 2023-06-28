Spring集成MyBatis的步骤：

    1、加入依赖
        1）Spring框架依赖
        2）MyBatis框架依赖
        3）MySql驱动依赖
        4）Spring处理事务的依赖
        5）Spring集成MyBatis的依赖：
            用来在Spring项目中创建MyBatis的SqlSessionFactory和dao对象
        6）junit测试单元依赖
    2、创建MyBatis主配置文件
    3、创建Spring配置文件：
        将【与MyBatis相关的对象】交给Spring管理创建---使用到的技术是：IOC
            1）数据源(DataSource)
            2）SqlSessionFactory
            3）Dao对象
            4）声明自定义的Service









