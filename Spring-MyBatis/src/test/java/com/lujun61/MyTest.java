package com.lujun61;

import com.lujun61.bean.Student;
import com.lujun61.dao.StudentDao;
import com.lujun61.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /**
     * @description 获取容器中对象接口的名称
     * @author Jun Lu
     * @date 2021-12-21 19:28:18
     */
    @Test
    public void test01() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name :
                beanDefinitionNames) {
            System.out.println("容器中的对象名称：" + name +
                    "；对象的全限定名称：" +applicationContext.getBean(name));
        }
    }


    /**
     * @description 利用dao类创建对象
     * @author Jun Lu
     * @date 2021-12-21 19:28:56
     */
    @Test
    public void test02() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");

/*        List<Student> students = studentDao.selectAllStudent();
        for (Student student :
                students) {
            System.out.println(student);
        }*/

        /*System.out.println(studentDao.selectStudentById(2));*/

        /*studentDao.deleteStudent(2);*/

        /*int wyy = studentDao.insertStudent(new Student("wyy", 18, "666", 2));
        System.out.println(wyy);*/

        studentDao.updateStudent((new Student("cjw", 19, "666", 3)));
    }

    /**
     * @description 利用service类创建对象
     * @author Jun Lu
     * @date 2021-12-21 19:28:56
     */
    @Test
    public void test03() {
        String config = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");

        /*
        List<Student> students = studentService.findAllStudent();
        for (Student student :
                students) {
            System.out.println(student);
        }*/

        /*System.out.println(studentService.findStudentById(2));  */

        /*studentService.removeStudent(2);*/

        /*int wyy = studentService.addStudent(new Student("wyy", 18, "666", 2));
        System.out.println(wyy);*/

        studentService.modifyStudent((new Student("cjw", 19, "6666", 3)));
    }
}
