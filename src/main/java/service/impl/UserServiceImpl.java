/*
 * Date: 2021/6/20
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.SettingDao;
import dao.UserDao;
import jdk.internal.org.objectweb.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import pojo.Setting;
import pojo.User;
import response.ResponseResult;
import response.ResponseState;
import service.UserService;
import utils.Constants;
import utils.IdMaker;
import utils.TextUtil;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Random;

/**
 * @author shaozk
 */
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private SettingDao settingDao;

    @Autowired
    private IdMaker idMaker;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ResponseResult initManagerAccount(User user) {
        // 检查是否有初始化
        Setting managerAccountState = settingDao.findOneByKey(Constants.Setting.HAS_MANAGER_ACCOUNT_STATE);

        if (managerAccountState != null) {
            // 管理员账号已经初始化
        }

        // 检查数据
        if (TextUtil.isEmpty(user.getName())) {
            // 用户名不能为空
        }
        if (TextUtil.isEmpty(user.getPassword())) {
            // 密码不能为空
        }
        if (TextUtil.isEmpty(user.getEmail())) {
            // 邮箱不能为空
        }

        // 补充数据
        user.setId(String.valueOf(idMaker.nextId()));
        user.setRoles(Constants.User.ROLE_ADMIN);
        user.setAvatar(Constants.User.DEFAULT_AVATAR);
        user.setState(Constants.User.DEFAULT_STATE);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        // 对密码进行加密
        String password = user.getPassword();
//        String encode = bCryptPasswordEncoder.encode(password);
//        user.setPassword(encode);

        // 保存到数据库
        userDao.save(user);

        // 更新已经添加的标记
        Setting setting = new Setting();
        setting.setId(idMaker.nextId() + "");
        setting.setKey(Constants.Setting.HAS_MANAGER_ACCOUNT_STATE);
        setting.setCreateTime(new Date());
        setting.setUpdateTime(new Date());
        setting.setValue("1");
        settingDao.save(setting);
        return ResponseResult.SUCCESS("初始化成功");
    }

    @Override
    public String doRegister(User user, Model model) {
        // 1.检查当前用户名是否已经注册
        String userName = user.getName();
        if (TextUtil.isEmpty(userName)) {
            // 用户名不能为空");
            model.addAttribute("msg", "用户名不能为空");
            return "error/error";
        }
        User userByName = userDao.findOneByName(userName);
        if (userByName != null) {
            // 该用户名已经注册");
            model.addAttribute("msg", "该用户名已注册");
            return "error/error";
        }
        // 2.检查邮箱格式是否正确
        String email = user.getEmail();
        if (TextUtil.isEmpty(email)) {
            // 邮箱地址不能为空");
            model.addAttribute("msg", "邮箱地址不能为空");
            return "error/error";
        }
        if (!TextUtil.isEmailAddressOk(email)) {
            // 邮箱格式不正确");
            model.addAttribute("msg", "邮箱地址格式不正确");
            return "error/error";
        }
        // 3.检查邮箱是否已经注册
        User userByEmail = userDao.findOneByEmail(email);
        if (userByEmail != null) {
            // 该邮箱地址已经注册");
            model.addAttribute("msg", "该邮箱已注册");
            return "error/error";

        }

        // 4.对密码进行加密
        String password = user.getPassword();
        if (TextUtil.isEmpty(password)) {
            // "密码不能为空");
            model.addAttribute("msg", "密码不能为空");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        // 5.补充数据
        user.setId(String.valueOf((new Random()).nextInt()));
        user.setName(user.getName());
        user.setState("1");
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        user.setAvatar("无");
        user.setRoles("用户");

        // 6.保存到数据库
        userDao.save(user);

        model.addAttribute("msg", "用户注册成功");
        return "user/registerSuccess";

    }

    @Override
    public String doLogin(User user, Model model, HttpSession session, String code) {
        return "user/loginSuccess";
    }


}
