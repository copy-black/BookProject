package com.guigu.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/11
 */
public abstract class BaseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String action = req.getParameter("action");
/*
        if("login".equals(action)){
            login(req,resp);
        }else  if ("regist".equals("处理注册的需求")){
        regist(req,resp);
        }*/
            try {
                //获取action业务鉴别自负床，获取相应的业务，方法反射对象。
                Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);

                //  System.out.println(method);
                //调用目标业务  方法
                method.invoke(this,req,resp);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

