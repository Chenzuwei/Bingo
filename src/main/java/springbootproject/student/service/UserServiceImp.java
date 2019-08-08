package springbootproject.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootproject.student.model.User;
import springbootproject.student.repository.UserRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @User: 陈祖威
 * @Date: 2019/8/6
 * @Time: 11:23
 * @Version: 2.0
 */
@Service
public class UserServiceImp implements UserService {
    private static final Pattern EMAIL_CHECKER = Pattern.compile("^([a-z0-9A-Z]+[-|\\._]?)+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    private static final Pattern MOBILE_CHECKER = Pattern.compile("^1[3,4,5,7,8]\\d{9}$");
    @Autowired
    private UserRepository userRepository;

    public Enum save(User user) throws Exception {
        Matcher matcher = EMAIL_CHECKER.matcher(user.getEmail());
        Matcher matcher2 = MOBILE_CHECKER.matcher(user.getTel());
        if (!matcher.matches()) {
            return Staus.邮件格式不正确;
        } else if (userRepository.existsByEmail(user.getEmail())) {
            return Staus.该用户已注册;
        } else if (!matcher2.matches()) {
            return Staus.号码格式不正确;
        } else {
            userRepository.save(user);
            return Staus.success;
        }
    }

    public Enum findByEmailAndPwd(String email, String pwd) throws Exception {
        Matcher matcher3 = EMAIL_CHECKER.matcher(email);
        if (!matcher3.matches()) {
            return Staus.邮件格式不正确;
        } else if (!userRepository.existsByEmail(email)) {
            return Staus.该账户未注册;
        } else {
            if (!userRepository.existsByEmailAndPwd(email, pwd)) {
                return Staus.输入密码不正确;
            } else
                return Staus.success;
        }
    }

    private enum Staus {
        邮件格式不正确,
        该用户已注册,
        该账户未注册,
        号码格式不正确,
        输入密码不正确,
        success
    }
}
