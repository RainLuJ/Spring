在Web项目中使用Spring，完成学生信息的注册：

实现步骤：
    1、创建maven->Web项目
    2、加入依赖：
        将 spring-mybatis 项目中以下内容复制到当前项目中：
        （1）Service 层、Dao 层全部代码
        （2）配置文件 applicationContext.xml 及 jdbc.properties，mybatis.xml
        （3）pom.xml
        （4）加入 servlet ,jsp 依赖
    3、创建一个jsp发起请求，有参数id，name，email，age
    4、创建Servlet，接收请求参数，调用Service、dao来完成注册
    5、创建一个jsp作为显示结果页面