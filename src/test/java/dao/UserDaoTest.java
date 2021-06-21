package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void save() {
        User user = new User();
        user.setId("2");
        user.setRoles("user");
        user.setUname("shaozk");
        user.setEmail("12345@qq.com");
        user.setPassword("123456");
        user.setState("1");
        user.setAvatar("tmp");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int code = userDao.save(user);
        assert code == 1;
    }

    @Test
    public void findOneById() {
        User user = userDao.findOneById("1");
        System.out.println(user);
    }

    @Test
    public void findAll() {
        List<User> list = userDao.findAll();
        for(User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void deleteAllById() {
        int code = userDao.deleteAllById("2");
        assert code == 1;
    }

    @Test
    public void findOneByEmail() {
        User user = userDao.findOneByEmail("913667678@qq.com");
        System.out.println(user);
    }

    @Test
    public void findOneByName() {
        User user = userDao.findOneByName("shaozk");
        System.out.println(user);
    }

    @Test
    public void updateEmailById() {
        int code  = userDao.updateEmailById("1","913667678@qq.com");
        assert code == 1;
    }

    @Test
    public void updatePasswordByEmail() {
        int code = userDao.updatePasswordByEmail("913667678@qq.com", "971007");
        assert code == 1;
    }

    @Test
    public void deleteUserByState() {
    }
}