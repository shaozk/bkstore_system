package service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import response.ResponseResult;
import service.UserService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void register() {
        // 用户名为空
        ResponseResult result = userService.register(new User());
        System.out.println(result);

        // 邮箱格式错误
        User userErrorEmail()


        // 用户名已经注册
        User userRepeat = new User();
        userRepeat.setUname("shaozk");
        ResponseResult result1 = userService.register(userRepeat);
        System.out.println(result1);
    }
}