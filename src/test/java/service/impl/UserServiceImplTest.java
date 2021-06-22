package service.impl;

import base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import response.ResponseResult;
import service.UserService;

import static org.junit.Assert.*;


public class UserServiceImplTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void initManagerAccount() {
        User user = new User();
        user.setName("shozk");
        user.setRoles("用户");
        user.setPassword("123456");
        user.setEmail("123456@qq.com");
        ResponseResult result = userService.initManagerAccount(user);
        System.out.println(result);
    }

    @Test
    public void register() {
        User user = new User();
        user.setName("szk");
        user.setPassword("123456");
        user.setEmail("913667.@qq.com");

//        String hello = userService.doRegister(user);


    }
}