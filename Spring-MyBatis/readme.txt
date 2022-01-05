Spring集成MyBatis的步骤：

    1、新建一个Maven项目
    2、加入依赖
        1）Spring框架依赖
        2）MyBatis框架依赖
        3）MySql驱动依赖
        4）Spring处理事务的依赖
        5）Spring集成MyBatis的依赖：
            用来在Spring项目中创建MyBatis的SqlSessionFactory和dao对象
        6）junit测试单元依赖
    3、创建实体类
    4、创建dao接口和mapper文件
    5、创建MyBatis主配置文件
    6、创建Service接口和实现类--->实现类中有属性【dao】
    7、创建Spring配置文件：
        将与MyBatis相关的对象交给Spring管理创建
            1）数据源(DataSource)
            2）SqlSessionFactory
            3）Dao对象
            4）声明自定义的Service
    8、创建测试类，获取Service对象，通过Service调用dao完成对数据库的访问









