package com.guigu.test;

import com.guigu.pojo.User;
import com.guigu.service.UserService;
import com.guigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/7/12
 */
public class UserServiceTest {
UserService userService=new UserServiceImpl();

    @Test
    public void registerUser() {
    userService.registerUser(new User(null,"bjbj123","666666","bjbj168@qq.com"));
    userService.registerUser(new User(null,"cjcj123","666666","cjcj168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"zhangsan","123456","null")));
    }


    @Test
    public void existUsername() {
        if (userService.existUsername("zhangsan666")){
            System.out.println("用户名存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}