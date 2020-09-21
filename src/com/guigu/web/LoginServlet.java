package com.guigu.web;

import com.guigu.pojo.User;
import com.guigu.service.UserService;
import com.guigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/7/13
 */
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
