/*
 * Date: 2021/6/20
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import pojo.User;
import response.ResponseResult;
import response.ResponseState;
import service.UserService;
import utils.TextUtil;

import java.util.Date;

/**
 * @author shaozk
 */
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseResult register(User user) {
        // 1.检查当前用户名是否已经注册
        String userName = user.getUname();
        if (TextUtil.isEmpty(userName)) {
            return ResponseResult.FAILED("用户名不能为空");
        }
        User userByName = userDao.findOneByName(userName);
        if (userByName != null) {
            return ResponseResult.FAILED("该用户名已经注册");
        }
        // 2.检查邮箱格式是否正确
        String email = user.getEmail();
        if (TextUtil.isEmpty(email)) {
            return ResponseResult.FAILED("邮箱地址不能为空");
        }
        if (!TextUtil.isEmailAddressOk(email)) {
            return ResponseResult.FAILED("邮箱格式不正确");
        }
        // 3.检查邮箱是否已经注册
        User userByEmail = userDao.findOneByEmail(email);
        if (userByEmail != null) {
            return ResponseResult.FAILED("该邮箱地址已经注册");
        }

        // 4.对密码进行加密
        String password = user.getPassword();
        if (TextUtil.isEmpty(password)) {
            return ResponseResult.FAILED("密码不能为空");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setState("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        user.setAvatar("无");
        user.setRoles("用户");

        // 8.保存到数据库
        userDao.save(user);

        // 9.返回结果
        return ResponseResult.GET(ResponseState.JOIN_IN_SUCCESS);

    }
}
