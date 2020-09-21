package com.guigu.service.impl;

import com.guigu.dao.UserDao;
import com.guigu.dao.impl.UserDaoImpl;
import com.guigu.pojo.User;
import com.guigu.service.UserService;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/7/12
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            //等于null说明 没有查到，可以用
            return false;
        }
        return true;
    }
}


