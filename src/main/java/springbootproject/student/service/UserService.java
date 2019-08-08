package springbootproject.student.service;

import springbootproject.student.model.User;

public interface UserService {
    Enum save(User user) throws Exception;

    Enum findByEmailAndPwd(String email, String pwd) throws Exception;

}
