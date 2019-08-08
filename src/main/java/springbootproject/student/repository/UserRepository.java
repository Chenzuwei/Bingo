package springbootproject.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootproject.student.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmailAndPwd(String email, String pwd);

    boolean existsByEmail(String email);

}
