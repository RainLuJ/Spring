package com.lujun61.service;

import com.lujun61.bean.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    int modifyStudent(Student student);
    int removeStudent(Integer id);
    Student findStudentById(Integer id);
    List<Student> findAllStudent();
}
