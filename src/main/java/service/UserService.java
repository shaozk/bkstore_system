/*
 * Date: 2021/6/20
 * Author: <https://www.github.com/shaozk>
 */

package service;

import pojo.User;
import response.ResponseResult;

import javax.servlet.http.HttpServlet;

/**
 * @author shaozk
 */
public interface UserService {

    ResponseResult register(User user);
}
