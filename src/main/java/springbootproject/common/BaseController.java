package springbootproject.common;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @User: 陈祖威
 * @Date: 2019/7/29
 * @Time: 17:01
 * @Version: 2.0
 */
public class BaseController {
    protected ModelAndView feedback(Object obj) {
        Object result = obj != null ? obj : "success";
        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        return new ModelAndView(new JsonView(data));
    }

}
