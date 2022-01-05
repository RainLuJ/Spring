package com.lujun61.dao;

import com.lujun61.bean.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(Integer id);
    List<Student> selectAllStudent();
    Student selectStudentById(Integer id);
}
