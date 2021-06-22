package controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author shaozk
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping("/login")
    public String index() {
        return "user/login";
    }

    /**
     * 进入注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "user/register";
    }


    /**
     * 用户进行登录
     * @param user
     * @param model
     * @param session
     * @param code
     * @return
     */
    @RequestMapping("/doLogin")
    public String login(@ModelAttribute User user, Model model, HttpSession session, String code) {

        return userService.doLogin(user, model, session, code);

    }

    @RequestMapping("/doRegister")
    public String register(@ModelAttribute User user, Model model) {
        return userService.doRegister(user, model);
    }


    /**
     * 初始化管理员账号
     * @param user
     */
    @RequestMapping("/admin_account")
    public String initManagerAccount(@RequestBody User user) {
        System.out.println(user);
        return "test";
    }


}
