package springbootproject.student.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import springbootproject.student.model.Student;


/**
 * @User: 陈祖威
 * @Date: 2019/7/29
 * @Time: 17:02
 * @Version: 1.0
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findBySno(Integer sno);
}
