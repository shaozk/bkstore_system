/*
 * Date: 2021/6/20
 * Author: <https://www.github.com/shaozk>
 */

package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.User;

import java.util.List;

/**
 * @author shaozk
 * 用户dao层，对用户表的增删改差
 * 还有其他一些常见操作
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * 保存用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 通过id查找用户
     * @param userId
     * @return
     */
    User findOneById(String userId);

    /**
     * 列出所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 通过id删除用户
     * @param userId
     * @return
     */
    int deleteAllById(String userId);

    /**
     * 通过email查找用户信息
     * @param email
     * @return
     */
    User findOneByEmail(String email);

    /**
     * 通过名字查找用户信息
     * @param uname
     * @return
     */
    User findOneByName(String uname);

    /**
     * 通过id更新邮箱
     * @param userId
     * @param email
     * @return
     */
    int updateEmailById(String userId, String email);

    /**
     * 通过邮箱更新密码
     * @param email
     * @param encode
     * @return
     */
    int updatePasswordByEmail(String email, String encode);

    /**
     * 通过修改状态删除用户
     * 并不是真正把数据记录从数据库中删除
     * @param userId
     * @return
     */
    int deleteUserByState(String userId);

}
