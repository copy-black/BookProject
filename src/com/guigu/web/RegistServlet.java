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
public class RegistServlet extends HttpServlet {
     private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1.获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
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
