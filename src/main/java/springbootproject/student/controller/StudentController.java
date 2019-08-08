package springbootproject.student.controller;

/**
 * @User: 陈祖威
 * @Date: 2019/7/29
 * @Time: 17:00
 * @Version: 1.0
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springbootproject.common.BaseController;
import springbootproject.student.model.Student;
import springbootproject.student.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/stu_no")
    public ModelAndView students(Integer sno) throws Exception {
        return feedback(studentService.findBySno(sno));
    }

    @RequestMapping(value = "/students")
    public ModelAndView students() throws Exception {
        return feedback(studentService.findAll());
    }

    @RequestMapping(value = "/delete")
    public ModelAndView student(Integer id) throws Exception {
        studentService.deleteById(id);
        return feedback("success");
    }

    @RequestMapping(value = "/save")
    public ModelAndView students(String str) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(str);
        Student student = JSON.toJavaObject(jsonObject, Student.class);
        studentService.save(student);
        return feedback("success");
    }

    @RequestMapping(value = "/update")
    public ModelAndView student(String str) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(str);
        Student student = JSON.toJavaObject(jsonObject, Student.class);
        studentService.saveAndFlush(student);
        return feedback(studentService.saveAndFlush(student));
    }
}
