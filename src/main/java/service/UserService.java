/*
 * Date: 2021/6/20
 * Author: <https://www.github.com/shaozk>
 */

package service;

import org.springframework.ui.Model;
import pojo.User;
import response.ResponseResult;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * @author shaozk
 */
public interface UserService {

    /**
     * 用户注册<br/>
     * 1.检查当前用户名是否被注册<br/>
     * 2.检查邮箱格式是否正确<br/>
     * 3.检查邮箱是否被注册<br/>
     * 4.对密码进行加密<br/>
     * 5.添加数据<br/>
     * 6.保存数据<br/>
     * @param user
     * @param model
     * @return
     */
    String doRegister(User user, Model model);

    /**
     * 用户登录<br/>
     * 1.
     * @param user
     * @param model
     * @param session
     * @param code
     * @return
     */
    String doLogin(User user, Model model, HttpSession session, String code);

    /**
     * 初始化管理员信息
     * @param user
     * @return
     */
    ResponseResult initManagerAccount(User user);

}
