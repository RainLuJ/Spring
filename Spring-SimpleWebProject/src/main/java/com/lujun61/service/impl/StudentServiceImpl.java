package com.lujun61.service.impl;

import com.lujun61.bean.Student;
import com.lujun61.dao.StudentDao;
import com.lujun61.service.StudentService;

import java.util.List;

/**
 * @description 在服务类中进行dao操作封装
 * @author Jun Lu
 * @date 2021-12-20 23:14:42
 */
public class StudentServiceImpl implements StudentService {
    //定义dao的属性；在服务类中进行dao操作
    private StudentDao studentDao;

    //定义set方法，使Spring能使用DI赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public int modifyStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public int removeStudent(Integer id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentDao.selectStudentById(id);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.selectAllStudent();
    }
}
