package com.guigu.service;

import com.guigu.pojo.User;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/7/12
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登入
     * @param user
     * @return  如果返回null,说明登入失败，返回有值，则登入成功
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param username
     * @return 返回true为用户名已存在 false则为用户名可用
     */
    public boolean  existUsername(String username);
}
