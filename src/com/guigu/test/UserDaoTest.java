package com.guigu.test;

import com.guigu.dao.UserDao;
import com.guigu.dao.impl.UserDaoImpl;
import com.guigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/7/12
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin123") == null) {
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在！！");
        }
    }
    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误,登入失败");
        }else {
            System.out.println("查询成功");
        }
    }
    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"zhangsan","123456","zhangsan168@qq.com")));
    }
}