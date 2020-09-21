package com.guigu.web;

import com.guigu.dao.UserDao;
import com.guigu.pojo.Book;
import com.guigu.pojo.User;
import com.guigu.service.UserService;
import com.guigu.service.impl.UserServiceImpl;
import com.guigu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/8/8
 */
public class UserServlet extends BaseServlet {
    private UserServiceImpl userService =new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1.获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");

//            2.处理业务  xxxService.xxx    userService.login 处理业务

        User loginUser=userService.login(new User(null,username,password,null));//??
//                3.根据login() 返回结果  判断登入是否成功
        if (loginUser==null){
            //登入失败
            //把错误信息，和回显信息表单，保存到request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回登入页面

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
//                登入成功
            System.out.println("登入成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }


    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1.获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
        //简洁代码
        Book user= WebUtils.copyParamToBean(req.getParameterMap(),new Book());


//            2.检验验证码是否正确   先写死   规定为abcde
        if ("abcde".equals(code)){
            //            正确
            if (userService.existUsername(username)){
//                3.判断用户名是否存在
//             若存在，不可以   跳回注册页面

                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                System.out.println("用户名["+username+"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);

            }else {
//                用户名不存在 ，可用
//                调用service程序保存到数据库
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }
        else {
            //失败      跳回注册页面
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }


}
