package com.guigu.dao;
import com.guigu.pojo.User;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/7/12
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return
     */

    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示失败 其他是sql语句影响的行数
     */
    public int saveUser(User user);
}
