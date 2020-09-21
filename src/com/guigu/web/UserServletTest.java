package com.guigu.web;

import java.lang.reflect.Method;


/**
 * TODO
 *
 * @author Administrator
 * @date 2020/8/31
 */
public class UserServletTest {
    public  void login(){
        System.out.println("这是login()方法调用了");
    }
    public  void regist(){
        System.out.println("这是regist()方法调用了");
    }
    public void updateUser(){
        System.out.println("这是updateUser()方法调用了");
    }
    public void updatePassword(){
        System.out.println("这是updatePassword()方法调用了");
    }

    public static void main(String[] args) {
        String action="login";
        try {
            //获取action业务鉴别自负床，获取相应的业务，方法反射对象。
            Method method = UserServletTest.class.getDeclaredMethod(action);

          //  System.out.println(method);
            method.invoke((new UserServletTest()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
