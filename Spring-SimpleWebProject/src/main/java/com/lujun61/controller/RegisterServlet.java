package com.lujun61.controller;

import com.lujun61.bean.Student;
import com.lujun61.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String strId = request.getParameter("id");
        String strName = request.getParameter("name");
        String strEmail = request.getParameter("email");
        String strAge = request.getParameter("age");

        /* 1、传统的容器创建写法不适合在Servlet中使用：重复创建容器，导致内存占用太多
        //创建Spring的容器对象
        String config = "applicationContext.xml";
        ApplicationContext ctxt = new ClassPathXmlApplicationContext(config);
        System.out.println("容器中的对象信息：" + ctxt);*/


        /* 2、不使用工具类创建容器 */
        WebApplicationContext ctx = null;
        /*String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        Object attr = getServletContext().getAttribute(key);
        if (attr != null) {
            ctx = (WebApplicationContext) attr;
        }*/


        /* 3、使用工具类创建容器 */
        ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());


        System.out.println("容器对象名称：" + ctx);

        //获取service
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student stu = new Student();
        stu.setAge(Integer.valueOf(strAge));
        stu.setName(strName);
        stu.setEmail(strEmail);
        stu.setId(Integer.valueOf(strId));
        service.addStudent(stu);

        //注册完毕，返回一个页面
        request.getRequestDispatcher("/result.html").forward(request, response);
    }
}













