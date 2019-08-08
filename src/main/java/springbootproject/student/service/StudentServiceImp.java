package springbootproject.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootproject.student.model.Student;
import springbootproject.student.repository.StudentRepository;

import java.util.List;

/**
 * @User: 陈祖威
 * @Date: 2019/7/29
 * @Time: 17:03
 * @Version: 1.0
 */
@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findBySno(Integer sno) throws Exception {
        if (sno == null) {
            throw new IllegalAccessException("Parameter sno can't be null.");
        }
        return studentRepository.findBySno(sno);
    }

    public List<Student> findAll() throws Exception {

        return studentRepository.findAll();
    }

    public void deleteById(Integer id) throws Exception {
        studentRepository.deleteById(id);
    }

    public void save(Student student) throws Exception {
        studentRepository.save(student);
    }

    public Student saveAndFlush(Student student) throws Exception {
        studentRepository.saveAndFlush(student);
        return studentRepository.saveAndFlush(student);
    }
}
