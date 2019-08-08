package springbootproject.student.service;


import springbootproject.student.model.Student;

import java.util.List;

/**
 * @User: 陈祖威
 * @Date: 2019/7/29
 * @Time: 17:02
 * @Version: 1.0
 */

public interface StudentService {
    Student findBySno(Integer sno) throws Exception;

    List<Student> findAll() throws Exception;

    void deleteById(Integer id) throws Exception;

    void save(Student student) throws Exception;

    Student saveAndFlush(Student student) throws Exception;
}
