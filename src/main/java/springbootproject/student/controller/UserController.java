package springbootproject.student.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springbootproject.common.BaseController;
import springbootproject.student.model.User;
import springbootproject.student.service.UserService;

/**
 * @User: 陈祖威
 * @Date: 2019/8/6
 * @Time: 11:25
 * @Version: 2.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    public ModelAndView register(String str) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(str);
        User user = JSON.toJavaObject(jsonObject, User.class);
        return feedback(userService.save(user));
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(String str) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(str);
        User user = JSON.toJavaObject(jsonObject, User.class);
        String email = user.getEmail();
        String pwd = user.getPwd();
        return feedback(userService.findByEmailAndPwd(email, pwd));
    }
}
